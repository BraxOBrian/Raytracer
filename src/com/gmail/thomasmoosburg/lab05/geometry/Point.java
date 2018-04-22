package com.gmail.thomasmoosburg.lab05.geometry;
/**
 *Punkt der aus 3 Koordinaten besteht (X,Y,Z).
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public final class Point extends GeometryBase 
{
	/**
	 * Super-Constructor.
	 * @param x double
	 * @param y double
	 * @param z double
	 */
	
	public Point(double x, double y, double z) 
	{
		super(x, y, z);
	}
	/**
	 * Diese Methode wandelt einen Punkt zu einem Vektor um. 
	 * Indem der neue Vektor die Strecke zwischne Punkt und 
	 * Ursprung beschreibt. Wird benötigt um Rechnungen mit 
	 * Vektoren auszuführen.
	 * @return vector Vector
	 */
	public Vector pointToVector(){
		return new Vector(this.getx(),this.gety(),this.getz());
	}
	@Override
	public String toString()
	{
		return String.format("(%.15f,%.15f,%.15f)", this.getx(),this.gety(),this.getz());
	}
	/**
	 * Subtrahiert einen Point other von this.
	 * @param other Point
	 * @return Vector vector
	 */
	public Point substract(Point other){
		return new Point(this.getx()-other.getx(),this.gety()-other.gety(),this.getz()-other.getz());
	}
	/**
	 * Addiert einen Point other auf this.
	 * @param other Point
	 * @return Point point
	 */
	public Point add(Point other){
		return new Point(this.getx()+other.getx(),this.gety()+other.gety(),this.getz()+other.getz());
	}
	

}
