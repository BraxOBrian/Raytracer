package com.gmail.thomasmoosburg.lab05.geometry;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 *Testklasse für die Klasse Point.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/

public class PointTest {
	/**
	 * Test für X-Coordinate.
	 */
	@Test
	public void testXCoordinate()
	{
		final Point point=new Point(1,2,3);
		final double want = 1;
		final double have = point.getx();
		assertEquals(want,have,0.0);
	}
	/**
	 * Test für Y-Coordinate.
	 */
	@Test
	public void testYCoordinate()
	{
		final Point test=new Point(1,2,3);
		final double want = 2;
		final double have = test.gety();
		assertEquals(want,have,0.0);
	}
	/**
	 * Test für Z-Coordinate.
	 */
	@Test
	public void testZCoordinate()
	{
		final Point test=new Point(0,0,3);
		final double want = 3;
		final double have = test.getz();
		assertEquals(want,have,0.0);
	}
	/**Test von Point.*/
	@Test
	public void testPoint1()
	{
		final Point test=new Point(0,0,3);
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
	/**Test von Point.*/
	@Test
	public void testPoint2()
	{
		final Point test=new Point(5,40,300);
		final double want1 = 5;
		final double have1 = test.getx();
		final double want2=40;
		final double have2=test.gety();
		final double want3=300;
		final double have3=test.getz();
		assertEquals(want1,have1,0.0);
		assertEquals(want2,have2,0.0);
		assertEquals(want3,have3,0.0);
	}
	/**Test von Point.*/
	@Test
	public void testPoint3()
	{
		final Point test=new Point(5000,-10000,60000);
		final double want1 = 5000;
		final double have1 = test.getx();
		final double want2=-10000;
		final double have2=test.gety();
		final double want3=60000;
		final double have3=test.getz();
		assertEquals(want1,have1,0.0);
		assertEquals(want2,have2,0.0);
		assertEquals(want3,have3,0.0);
	}
}
