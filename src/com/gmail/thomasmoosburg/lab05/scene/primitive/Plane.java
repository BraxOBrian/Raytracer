package com.gmail.thomasmoosburg.lab05.scene.primitive;

import java.util.ArrayList;
import java.util.List;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;

/**
* Klasse definiert eine Plane und berechnet den Schnittpunk mit einem Ray. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class Plane implements Primitive
{
	/** Konstante zum vergleichen von Doublewerten.*/
	private static final double DELTA=2.41*Math.pow(10, -10);
	/** Point im Plane.*/
	private final Point point;
	/** Senkrechter Vektor auf der Plane.*/
	private final Vector vector;
	/**Surface of Plane.*/
	private final Surface surface=new Surface();
	/** 
	 * Dies ist der Konstruktor von Plane.
	 * @param point Point
	 * @param vector Vector
	 * @throws NullPointerException
	 */
	public Plane(final Point point,final Vector vector)
	{
		if(point==null||vector==null)
		{
			throw new NullPointerException();
		}
		this.point=point;
		this.vector=vector.getNormalizedVector();
	}
	
	 /**
     * Nearest intersection of ray (point and vector) with the Plane.
     * @param ray Ray
     * @return List : Empty if there is no intersection.
     * Distance of nearest intersection from ray base point otherwise.
     */

	public List<Intersection> intersections(final Ray ray)
	{
	    if(ray == null) 
	     {
	        throw new NullPointerException();
	     }
	      
		final List<Intersection> result = new ArrayList<Intersection>();
		final double nennerAlpha=vector.dotProduct(ray.getRayVector());
		
		if(nennerAlpha>DELTA||nennerAlpha==0)
		{
			return result;
		}
		final double zaehlerAlpha=vector.dotProduct(ray.getRayPoint().substract(point).pointToVector());
		final double alpha=(-1*zaehlerAlpha)/nennerAlpha;
		final Point intersectionPoint=ray.intersectionPoint(alpha);
		
		final Vector distanceVector=intersectionPoint.substract(ray.getRayPoint()).pointToVector();
		final double distance=distanceVector.getLength();
		
		if(distance>0)
		{
			result.add(new Intersection(intersectionPoint, this, distance, true));
			return result;
		}
		return result;
	}


	@Override
	public String toString()
	{
		return point.toString()+" "+vector.toString();
	}

	@Override
	public Vector getNormal(Point point1) 
	{
		return vector;
	}
	public Surface getSurface(){
		return surface;
	}
}