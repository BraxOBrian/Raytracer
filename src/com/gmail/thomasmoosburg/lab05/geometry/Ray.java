package com.gmail.thomasmoosburg.lab05.geometry;
/**
 *Test für die Klasse Ray.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public final class Ray {
	/** Vector Variable für Vector des Ray.*/
	private final Vector rayVector;
	/** Point Variable für Startpunkt des Ray.*/
	private final Point rayPoint;
	/**
	 * Konstruktor.
	 * @throws NullPointerException
	 * @param rayPoint Point
	 * @param rayVector Vector
	 */
	public Ray(Point rayPoint, Vector rayVector)
	{
		if(rayPoint==null||rayVector==null)
		{
			final NullPointerException npe=new NullPointerException("rayPoint and rayVector are null");
			throw npe;
		}
		this.rayVector = rayVector.getNormalizedVector();
		this.rayPoint = rayPoint;
		
	}
	/**
	 * Getter RayPoint.
	 * @return rayPoint
	 */
	public Point getRayPoint()
	{
		return rayPoint;
	}
	/**HashCode wird wegen Equals deaktiviert.
	 * @throws UnsupportedOperationException ->immer*/
	@Override
	public int hashCode()
	{
		throw new UnsupportedOperationException();
	}
	/**
	 * Getter RayVector.
	 * @return rayVector
	 */
	public Vector getRayVector()
	{
		return rayVector;
	}
	@Override
	public boolean equals(Object other)
	{
		if(this==null||other==null){
			throw new NullPointerException();
		}
		
		if(this.getRayPoint().equals(((Ray) other).getRayPoint())
		 &&this.getRayVector().equals(((Ray) other).getRayVector()))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("[%s,%s]", this.getRayPoint().toString(),this.rayVector.toString());
	}
	/** Berechnet den Schnittpunkt anhand der übergebenen Distanz=Alpha.
	 * @param distance double
	 * @return Point Schnittpunkt
	 */
	public Point intersectionPoint(final double distance)
	{
        return new Point(rayPoint.getx() + rayVector.getx()*distance,
        		rayPoint.gety() + rayVector.gety()*distance,
        		rayPoint.getz() + rayVector.getz()*distance);
	}
}
