package com.gmail.thomasmoosburg.lab05.geometry;
/**
 * Abstrakte Basisklasse f�r Punkte und Vektoren mit 3 Koordinaten.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/

public abstract class GeometryBase 
{
	/**Konstante f�r Rundungsfehler.*/
	private static final double DELTA=2.41*Math.pow(10, -10);
	/**
	 * Private Variablen f�r X-Koordinate.
	 */
	private final double xCoordinate;
	/**
	 * Private Variablen f�r Y-Koordinate.
	 */
	private final double yCoordinate;
	/**
	 * Private Variablen f�r Z-Koordinate.
	 */
	private final double zCoordinate;
	/**
	 * Konstruktor.
	 * @param xCoordinate double;
	 * @param yCoordinate double;
	 * @param zCoordinate double;
	 */
	GeometryBase(double xCoordinate, double yCoordinate, double zCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
	}
	/**
	 * Getter X-Koordinate.
	 * @return x
	 */
	public double getx()
	{
		return xCoordinate;
	}
	/**
	 * Getter Y-Koordinate.
	 * @return y
	 */
	public double gety()
	{
		return yCoordinate;
	}
	/**
	 * Getter Z-Koordinate.
	 * @return z
	 */
	public double getz()
	{
		return zCoordinate;
	}
	/**HashCode wird wegen Equals deaktiviert.
	 * @throws UnsupportedOperationException ->immer*/
	@Override
	public int hashCode(){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean equals(Object that)
	{
		if(this==null||that==null)
			throw new NullPointerException();
		final double deltax=Math.abs(this.getx()-((GeometryBase) that).getx());
		final double deltay=Math.abs(this.gety()-((GeometryBase) that).gety());
		final double deltaz=Math.abs(this.getz()-((GeometryBase) that).getz());
		if(deltax<DELTA&&deltay<DELTA&&deltaz<DELTA)
		{
			return true;
		}
		return false;
	}
}
