package com.gmail.thomasmoosburg.lab05.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 *Testklasse für die Klasse Ray.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
@SuppressWarnings({"PMD.MethodNamingConventions","PMD.TooManyMethods","PMD.AvoidDuplicateLiterals"})
public class RayTest {
	/** Point Variable für Testzwecke.*/
	private static final Point TESTPOINT = null;
	/** Vector Variable für Testzwecke.*/
	private static final Vector TESTVECTOR = null;
	/**
	 * Test der Nullpointer Exception.
	 */
	@Test(expected=NullPointerException.class)
	public void testPointNull()
	{
		@SuppressWarnings("unused")
		final Ray testRay1 = new Ray(TESTPOINT, new Vector(1,2,3));
	}
	/**
	 * Test der Nullpointer Exception.
	 */
	@Test(expected=NullPointerException.class)
	public void testVectorNull()
	{
		@SuppressWarnings("unused")
		final Ray testRay2 = new Ray(new Point(1,2,3), TESTVECTOR);
	}
	/**Test von Ray.*/
	@Test
	public void testRay1()
	{
		final Point testPoint=new Point(0,0,3);
		final Vector testVector=new Vector(1,2,3);
		final Ray test=new Ray(testPoint,testVector);
		final Point want1 =new Point(0,0,3);
		final Point have1 =test.getRayPoint();
		final Vector want2=new Vector(1,2,3).getNormalizedVector();
		final Vector have2=test.getRayVector();
		assertEquals(want1,have1);
		assertEquals(want2,have2);
	}
	/**Test von Ray.*/
	@Test
	public void testRay2()
	{
		final Point testPoint=new Point(-30,60,1000);
		final Vector testVector=new Vector(-50,-20,50000);
		final Ray test=new Ray(testPoint,testVector);
		final Point want1 =new Point(-30,60,1000);
		final Point have1 =test.getRayPoint();
		final Vector want2=new Vector(-25,-10,25000).getNormalizedVector();
		final Vector have2=test.getRayVector();
		assertEquals(want1,have1);
		assertEquals(want2,have2);
	}
	/**Test von Ray.*/
	@Test
	public void testRay3()
	{
		final Point testPoint=new Point(6000,-70000,1000);
		final Vector testVector=new Vector(-50,-20,50000);
		final Ray test=new Ray(testPoint,testVector);
		final Point want1 =new Point(6000,-70000,1000);
		final Point have1 =test.getRayPoint();
		final Vector want2=new Vector(-25,-10,25000).getNormalizedVector();
		final Vector have2=test.getRayVector();
		assertEquals(want1,have1);
		assertEquals(want2,have2);
	}
	
}
