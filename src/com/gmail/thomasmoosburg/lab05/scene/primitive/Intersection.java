package com.gmail.thomasmoosburg.lab05.scene.primitive;

import com.gmail.thomasmoosburg.lab05.geometry.Point;

/**
* Klasse definiert einen Schnittpunkt und erstellt eine List der Schnittpunkte.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public final class Intersection implements Comparable<Intersection>
{
	/** Konstante zum vergleichen von Double werten.*/
	private static final double DELTA=2.41*Math.pow(10, -10);
	/** Punkt des Schnittes.*/
	private final Point pointOfIntersection;
	/** Objekt das geschnitten wurde.*/
	private final Primitive objectOfIntersection;
	/** Ditstanz des Schnittes.*/
	private final double distance;
	/** Eintritts Punkt true, austritt false.*/
	private final boolean rayInOut;

	
	/** 
	 * Dies ist der Konstruktor von Intersection.
	 * @param pointOfIntersection Point
	 * @param objectOfIntersection Primitive
	 * @param distance double
	 * @param rayInOut boolean
	 * @throws NullPointerException
	 */
	public Intersection(Point pointOfIntersection, Primitive objectOfIntersection,double distance,boolean rayInOut)
	{
		if(pointOfIntersection==null||objectOfIntersection==null)
		{
			throw new NullPointerException();
		}
		this.pointOfIntersection=pointOfIntersection;
		this.objectOfIntersection=objectOfIntersection;
		this.distance=distance;
		this.rayInOut=rayInOut;
	}
	
	public Point getPointOfIntersection()
	{
		return pointOfIntersection;
	}
	
	public Primitive getObjectOfIntersection()
	{
		return objectOfIntersection;
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public boolean isRayInOut()
	{
		return rayInOut;
	}
	@Override
	public String toString()
	{
		return String.format("[%s,%s,%.15f,%b]", pointOfIntersection.toString(),getObjectOfIntersection().getClass().getName(),getDistance(),isRayInOut());
	}
	
	/**HashCode wird wegen Equals deaktiviert.
	 * @throws UnsupportedOperationException ->immer*/
	@Override
	public int hashCode()
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object that) 
	{
		if(this==null||that==null){
			throw new NullPointerException();
		}
		final double dDistance=Math.abs(this.getDistance()-((Intersection) that).getDistance());
		
		if(dDistance<DELTA&&this.pointOfIntersection.equals(((Intersection) that).getPointOfIntersection())&&this.rayInOut==((Intersection) that).isRayInOut())
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Intersection that) 
	{
		if(that.getDistance()<this.distance)
		{
			return 1;
		}else
		{
		
			if(that.getDistance()>this.distance)
			{
				return -1;
			}else
				return 0;
		}
	}
}
