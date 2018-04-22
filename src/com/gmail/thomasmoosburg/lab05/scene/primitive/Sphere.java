package com.gmail.thomasmoosburg.lab05.scene.primitive;

import java.util.ArrayList;
import java.util.List;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;

/**
 * Klasse die eine Kugel definiert.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class Sphere implements Primitive
{
	 /**Center of Sphere.*/
	 private final Point sphereCenter;
	 /**Radius of Sphere.*/
	 private final double sphereRadius;
	 /**Surface of Sphere.*/
	 private final Surface surface=new Surface();
	 /**
	 * Konstruktor.
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * @param sphereCenter Point
	 * @param sphereRadius double
	 */
	 public Sphere(final Point sphereCenter,final double sphereRadius)
	 {
		 if(sphereRadius<=0)
		 {
			 throw new IllegalArgumentException("Radius too small");
		 }
		 if(sphereCenter==null)
		 {
	    	throw new NullPointerException();
		 }
		 this.sphereCenter=sphereCenter;
		 this.sphereRadius=sphereRadius;
	 }

	 public Point getSphereCenter()
	 {
		 return sphereCenter;
	 }

	 public double getSphereRadius()
	 {
		 return sphereRadius;
	 }
	
	public Surface getSurface()
	{
		return surface;
	}
	 /**
	     * Nearest intersection of ray (point and vector) with the sphere.
	     * @param ray Ray
	     * @return List : Empty if there is no intersection.
	     * Distance of nearest intersection from ray base point otherwise.
	     */
	 public List<Intersection> intersections(Ray ray) 
	 {
		 	if(ray==null)
		 	{
		 		throw new NullPointerException();
		 	}
		 	final List<Intersection> result = new ArrayList<Intersection>();
	        final double alpha=-1*(ray.getRayPoint().substract(sphereCenter).
	        					pointToVector().
	        					dotProduct(ray.getRayVector()));
	        final Vector crossVector=ray.getRayPoint().pointToVector().add(ray.getRayVector().multVec(alpha));
	        final double compare=crossVector.substract(sphereCenter.pointToVector()).getLength();
	        if(compare>sphereRadius)
	        	return result;
	        final double variationsparameter=Math.sqrt(sphereRadius*sphereRadius-compare*compare);
	        if(alpha>=variationsparameter){
	        	final Point crossCoordinate=crossCoordinates(ray,alpha-variationsparameter);
	        	final double distance=crossCoordinate.substract(ray.getRayPoint()).pointToVector().getLength();
	        	result.add(new Intersection(crossCoordinate,this,distance,true));
	        	return result;
	        }
	        else if(alpha+variationsparameter>0){
	        	final Point crossCoordinate=crossCoordinates(ray,alpha+variationsparameter);
	        	final double distance=crossCoordinate.substract(ray.getRayPoint()).pointToVector().getLength();
	        	result.add(new Intersection(crossCoordinate,this,distance,false));
	        	return result;
	        }
	        else
	        	return result;
	  }
	 /**
	  * Berechnung der Schnittkoordinaten.
	  * @param ray Ray
	  * @param rootX double
	  * @return Point Schnittkoordinaten
	  */
	 private Point crossCoordinates(Ray ray, double rootX){
		final double rayX=ray.getRayPoint().getx()+rootX*ray.getRayVector().getx();
 		final double rayY=ray.getRayPoint().gety()+rootX*ray.getRayVector().gety();
 		final double rayZ=ray.getRayPoint().getz()+rootX*ray.getRayVector().getz();
 		return new Point(rayX,rayY,rayZ);
	 }
	@Override
	public Vector getNormal(Point point) 
	{
		return new Vector(point.getx()-sphereCenter.getx(),point.gety()-sphereCenter.gety(),point.getz()-sphereCenter.getz()).getNormalizedVector();
	}
	@Override
	public String toString()
	{
		return sphereCenter.toString()+" "+sphereRadius;
		
	}
}
