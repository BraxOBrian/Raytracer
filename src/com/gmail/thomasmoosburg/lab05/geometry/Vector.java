package com.gmail.thomasmoosburg.lab05.geometry;
/**
 * Klasse für einen Vektor mit 3 Koordinaten.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public final class Vector extends GeometryBase 
{
	/**
	 * Konstruktor.
	 * @param x double
	 * @param y double
	 * @param z double
	 */
	public Vector(double x, double y, double z) 
	{
		super(x, y, z);
	}
	/**
	 * Länge des Vektors berechnen.
	 * @return double Länge des Vektors
	 */
	public double getLength()
	{
		return Math.sqrt(this.getx()*this.getx() + this.gety()*this.gety() + this.getz()*this.getz());
	}
	/**
	 * Vektor normalisieren.
	 * @return Vector gibt normalisierten Vektor zurück.
	 */
	public Vector getNormalizedVector()
	{
		return new Vector(this.getx()/this.getLength(), this.gety()/this.getLength(), this.getz()/this.getLength());
	}
	/**
	 * Diese Methode wandelt einen Vektor zu einem Punkt um. 
	 * @return point Point
	 */
	public Point vectorToPoint(){
		return new Point(this.getx(),this.gety(),this.getz());
	}
	
	/**
	 * Crossproduct.
	 * @param other Vector
	 * @return Vector.
	 */
	public Vector crossProduct(Vector other)
	{
		final double newX=this.gety()*other.getz()-this.getz()*other.gety();
		final double newY=this.getz()*other.getx()-this.getx()*other.getz();
		final double newZ=this.getx()*other.gety()-this.gety()*other.getx();
		
		return new Vector(newX,newY,newZ);
	}
	/**
	 * Subtrahiert einen Vector other von this.
	 * @param other Vector
	 * @return Vector vector
	 */
	public Vector substract(Vector other){
		return new Vector(this.getx()-other.getx(),this.gety()-other.gety(),this.getz()-other.getz());
	}
	/**
	 * Addiert einen Vector other auf this.
	 * @param other Vector
	 * @return Vector vector
	 */
	public Vector add(Vector other){
		return new Vector(this.getx()+other.getx(),this.gety()+other.gety(),this.getz()+other.getz());
	}
	
	/**
	 * Multipliziert einen Vector.
	 * @param mult double
	 * @return Vector.
	 */
	public Vector multVec(double mult)
	{
		return new Vector(this.getx()*mult,this.gety()*mult,this.getz()*mult);
	}
	
	/**
	 * Liefert den an der durch den Ray.
	 * gegebenen Gerade gespiegelten Vektor.
	 * normalisiert zurück.
	 * @param vector Vector
	 * @return Vector vector
	 */
	public Vector mirroredAt(Vector vector)
	{
		final double mirror = 2* vector.dotProduct(this);
        final Vector twistedNormal = vector.multVec(mirror);
		return this.substract(twistedNormal);
	}
	/**
	 * Berechnet das Skalarprodukt zweier Vektoren.
	 * @param other Vector
	 * @return double Kreuzprodukt result
	 */
	public double dotProduct(Vector other)
	{
		return other.getx()*this.getx()+other.gety()*this.gety()+other.getz()*this.getz();
	}
	@Override
	public String toString()
	{
		return String.format("(%.2f,%.2f,%.2f)", this.getx(),this.gety(),this.getz());
	}
}
