package com.gmail.thomasmoosburg.lab05.scene;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
/**
 *Testklasse für die Klasse Looker.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
//CHECKSTYLE:OFF MagicNumber

public class LookerTest 
{
	/**Test des Skalarprodukts.*/
	@Test
	public void testDotProduct1()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final double have1=test.getRightVector().dotProduct(test.getBlickVektor());
		final double have2=test.getRightVector().dotProduct(test.getUpVector());
		final double have3=test.getBlickVektor().dotProduct(test.getUpVector());
		final double want=0.0;
		assertEquals(want, have1,0.00000000001);
		assertEquals(want, have2,0.00000000001);
		assertEquals(want, have3,0.00000000001);
	}
	/**Test des Skalarprodukts.*/
	@Test
	public void testDotProduct2()
	{
		final Point camera = new Point(3,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final double have1=test.getRightVector().dotProduct(test.getBlickVektor());
		final double have2=test.getRightVector().dotProduct(test.getUpVector());
		final double have3=test.getBlickVektor().dotProduct(test.getUpVector());
		final double want=0.0;
		assertEquals(want, have1,0.00000000001);
		assertEquals(want, have2,0.00000000001);
		assertEquals(want, have3,0.00000000001);
	}
	/**Test des Skalarprodukts.*/	
	@Test
	public void testDotProduct3()
	{
		final Point camera = new Point(3,4,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final double have1=test.getRightVector().dotProduct(test.getBlickVektor());
		final double have3=test.getBlickVektor().dotProduct(test.getUpVector());
		final double want=0.0;
		assertEquals(want, have1,0.00000000001);
		assertEquals(want, have3,0.00000000001);
	}
	/**Test des Blickvektors.*/	
	@Test
	public void testBlickVector1()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final Vector have=test.getBlickVektor();
		final Vector want=new Vector(0, 0, -5);
		
		assertEquals(want, have);
	}
	/**Test des Blickvektors.*/	
	@Test
	public void testBlickvector2()
	{
		final Point camera = new Point(-3,4,1);
		final Point viewPortCenter=new Point(6,7,8);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final Vector have=test.getBlickVektor();
		final Vector want=new Vector(9, 3, 7);
		
		assertEquals(want, have);
	}
	/**Test des RightVectors.*/	
	@Test
	public void testRightVector1()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final Vector have=test.getRightVector();
		final Vector want=new Vector(1, 0, 0);
		
		assertEquals(want, have);
	}
	/**Test des UpVector.*/	
	@Test
	public void testUpVector1()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		
		final Vector have=test.getUpVector();
		final Vector want=new Vector(0, 1, 0);
		
		assertEquals(want, have);
	}
	/**Test des UpVector.*/	
	@Test
	public void testUpVector2()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 4.0, 4.0);
		
		final Vector have=test.getUpVector();
		final Vector want=new Vector(0, 2, 0);
		
		assertEquals(want, have);
	}
	/**Test von Primary Ray.*/	
	@Test
	public void testPrimaryRay1()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		final double horizontal=-0.5;
		final double vertical=0.5;
		
		final Ray have=test.getPrimaryRay(horizontal, vertical);
		final Ray want=new Ray(camera,new Vector(-0.5,0.5,-5));
		
		assertEquals(want, have);
	}
	/**Test von Primary Ray.*/	
	@Test
	public void testPrimaryRay2()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 3.0, 3.0);
		final double horizontal=0;
		final double vertical=0;
		
		final Ray have=test.getPrimaryRay(horizontal, vertical);
		final Ray want=new Ray(camera,new Vector(0,0,-5));
		
		assertEquals(want, have);
	}
	/**Test von Primary Ray.*/	
	@Test
	public void testPrimaryRay3()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 4.0, 4.0);
		final double horizontal=0.75;
		final double vertical=-0.75;
		
		final Ray have=test.getPrimaryRay(horizontal, vertical);
		final Ray want=new Ray(camera,new Vector(1.5,-1.5,-5));
		
		assertEquals(want, have);
	}
	/**Test von Primary Ray.*/	
	@Test
	public void testPrimaryRay4()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 4.0, 4.0);
		final double horizontal=0.75;
		final double vertical=0.75;
		
		final Ray have=test.getPrimaryRay(horizontal, vertical);
		final Ray want=new Ray(camera,new Vector(1.5,1.5,-5));
		
		assertEquals(want, have);
	}
	/**
	 * Test of NullPointerException.
	 */
	@SuppressWarnings("unused")
	@Test(expected=NullPointerException.class)
	public void testCameraNull()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		final Looker testLooker2 = new Looker(null,viewPortCenter,2.0,2.0);
	}
	/**
	 * Test of NullPointerException.
	 */
	@SuppressWarnings("unused")
	@Test(expected=NullPointerException.class)
	public void testViewPortCenterNull()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		final Looker testLooker2 = new Looker(camera,null,2.0,2.0);
	}
	/**
	 * Test of IllegalArgumentException.
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testHeightTooSmall()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		final Looker testLooker2 = new Looker(camera,viewPortCenter,2.0,0.0);
	}
	/**
	 * Test of IllegalArgumentException.
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testWidthTooSmall()
	{
		final Point camera = new Point(0,0,5);
		final Point viewPortCenter=new Point(0,0,0);
		final Looker test = new Looker(camera, viewPortCenter, 2.0, 2.0);
		final Looker testLooker2 = new Looker(camera,viewPortCenter,0.0,2.0);
	}
}
