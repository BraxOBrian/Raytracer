package com.gmail.thomasmoosburg.lab05.geometry;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 *Testklasse für die Klasse Vector.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
//CHECKSTYLE:OFF MagicNumber

public class VectorTest 
{
	/** Vector Variable für Testzwecke.*/
	private final Vector test1 = new Vector(1,1,1); // not random
	/** Vector Variable für Testzwecke.*/
	private final Vector testNormalized = new Vector(4,5,6); // random Values for Vector
	/**
	 * Test von getLength.
	 */
	@Test
	public void testGetLength() 
	{
		final double want = Math.sqrt(3);
		final double have = test1.getLength();
		assertEquals(want,have,0.0);
	}
	/**
	 * Test von getNormalizedVector.
	 */
	@Test
	public void testGetNormalizedVector()
	{
		final double want = 1;
		final double have = testNormalized.getNormalizedVector().getLength();
		
		assertEquals(want, have,0.000001);		
	}
	/**Test von Vector.*/
	@Test
	public void testVector1()
	{
		final Vector test=new Vector(0,0,3);
		final double want1 = 0;
		final double have1 = test.getx();
		final double want2=0;
		final double have2=test.gety();
		final double want3=3;
		final double have3=test.getz();
		assertEquals(want1,have1,0.0);
		assertEquals(want2,have2,0.0);
		assertEquals(want3,have3,0.0);
	}
	/**Test von Vector.*/
	@Test
	public void testVector2()
	{
		final Vector test=new Vector(-4000,0,-20);
		final double want1 = -4000;
		final double have1 = test.getx();
		final double want2=0;
		final double have2=test.gety();
		final double want3=-20;
		final double have3=test.getz();
		assertEquals(want1,have1,0.0);
		assertEquals(want2,have2,0.0);
		assertEquals(want3,have3,0.0);
	}
	/**Test von Vector.getLength().*/
	@Test
	public void testVectorGetLength2()
	{
		final Vector test=new Vector(10,0,0);
		final double want3=10;
		final double have3=test.getLength();
		assertEquals(want3,have3,0.0);
	}
	/**Test von Vector.getLength().*/
	@Test
	public void testVectorGetLength3()
	{
		final Vector test=new Vector(1,0,0);
		final double want3=1;
		final double have3=test.getLength();
		assertEquals(want3,have3,0.0);
	}
	/**Test von Vector.getNormalizedVector().*/
	@Test
	public void testVectorGetNormalizedVector1()
	{
		final Vector test=new Vector(1,0,0);
		final Vector want=new Vector(1,0,0);
		final Vector have=test.getNormalizedVector();
		assertEquals(want,have);
	}
	/**Test von Vector.getNormalizedVector().*/
	@Test
	public void testVectorGetNormalizedVector2()
	{
		final Vector test=new Vector(0,10,0);
		final Vector want=new Vector(0,1,0);
		final Vector have=test.getNormalizedVector();
		assertEquals(want,have);
	}

}
