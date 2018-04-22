package com.gmail.thomasmoosburg.lab05.tracer;


import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
import com.gmail.thomasmoosburg.lab05.scene.Looker;
import com.gmail.thomasmoosburg.lab05.scene.Scene;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Intersection;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Surface;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Surface.Property;

/**
 * Minimal raytracer.
 * The scene contains camera, viewport and a sphere.
 * The sphere has ambient brightness 1 (white).
 * The background is black.
 * Vectors and points are 3-element double-arrays (x, y, z).
 * null vectors and null points are prohibited.
 *
 * Run program: java Raytracer -> image.pgm
 * Load image.pgm into image viewer
 *
 * @author Lausch Sebastian, slausch@hm.edu
 * @author Schulz Thomas, thomasmoosburg@gmail.com
 * @version 4.0, 26.04.2015
 */
public class Raytracer 
{
	/** Konstante zum vergleichen von Doublewerten.*/
	private static final double DELTA=2.41*Math.pow(10, -6);
    /**Looker contains Camera, ViewPort.*/
    private final Looker looker;
    /**Scene.*/
    private final Scene scene;
    /**
     * Constructor.
     * @param scene Scene
     */
    public Raytracer(Scene scene)
    {
    	this.scene=scene;
    	this.looker=scene.getLooker();
    }
    
    /**
     * Berechnung der Relativen Helligkeit.
     * @param horizontal double
     * @param vertical double
     * @return double
     * @throws IllegalArgumentException wenn h oder v nicht zwischen einschlieﬂlich -1 und +1 liegt.
     */
    public double tracePrimary(double horizontal, double vertical)
    {
    	
    	if(horizontal<-1||vertical<-1||horizontal>1||vertical>1)
    	{
    		throw new IllegalArgumentException("Parameter not in range [-1,+1]");
    	}  	
        final Ray ray = looker.getPrimaryRay(horizontal,vertical);
        // compute distance of intersection ray/sphere nearest to camera
        final Intersection distance = scene.findIntersection(ray);
        double result=0.0;
        if(scene.getLight()!=null&&distance!=null)
        {
        	result=reduceComplexity(distance, ray);
        }
        else if(scene.getLight()==null&&distance!=null)
        {
        	final Surface surface=distance.getObjectOfIntersection().getSurface();
        	result=surface.get(Property.AmbientRatio)*1;
        } 
        return checkResult(result);
    }
    /**
     * checks result.
     * @param result double
     * @return double result
     */
    private double checkResult(double result){
    	if(result<=0)
    		return 0.0;
    	else if(result>1)
    		return 1.0;
    	else
    		return result;
    }
    /**
     * just to reduce Complexity for PMD and Checkstyle. 
     * @param distance Intersection
     * @param ray Ray
     * @return double result
     */
    private double reduceComplexity(Intersection distance,Ray ray){
    	final Vector lightVector=scene.getLight().substract(distance.getPointOfIntersection()).pointToVector().getNormalizedVector();
    	final Vector distanceToCam=distance.getPointOfIntersection().substract(looker.getCamera()).pointToVector().getNormalizedVector().multVec(DELTA);
    	final Ray secondaryRay=new Ray(distance.getPointOfIntersection().substract(distanceToCam.vectorToPoint()),lightVector);
    	final Intersection shadow=scene.findIntersection(secondaryRay);
    	final Vector unnormalizedLightVector=scene.getLight().substract(distance.getPointOfIntersection()).pointToVector();
    	if(shadow==null||shadow.getDistance()>unnormalizedLightVector.getLength())
    	{
        	final Vector normale=distance.getObjectOfIntersection().getNormal(distance.getPointOfIntersection()).getNormalizedVector();
        	final Surface surface=distance.getObjectOfIntersection().getSurface(); 
        	final Vector mirrored=ray.getRayVector().mirroredAt(normale);
        	final double tempresult= surface.get(Property.AmbientRatio)+surface.get(Property.DiffuseRatio)
        		   *(lightVector.dotProduct(normale))/(lightVector.getLength()*normale.getLength());
        	final double winkelToCheck=lightVector.dotProduct(mirrored)/lightVector.getLength()*mirrored.getLength();
            if(winkelToCheck>0){
        		   return tempresult+surface.get(Property.SpecularRatio)*Math.pow(winkelToCheck,surface.get(Property.SpecularExponent));
            }
            else
            	return tempresult;
        	
    	}else
    	{
    		final Surface surface=distance.getObjectOfIntersection().getSurface();
    		return surface.get(Property.AmbientRatio)*1;
    	}
    }
    
}