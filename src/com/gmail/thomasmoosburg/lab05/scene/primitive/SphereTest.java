package com.gmail.thomasmoosburg.lab05.scene.primitive;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
/**
 *Testklasse für die Klasse Sphere.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
//CHECKSTYLE:OFF MagicNumber

@SuppressWarnings({"PMD.MethodNamingConventions","PMD.TooManyMethods","PMD.AvoidDuplicateLiterals"})

public class SphereTest 
{
	/** null Point für Testzwecke.*/
	private static final Point TESTPOINT = null;
	/** random Sphere für Testzwecke.*/
	 

	/**
	 * Test IllegalArgumentException.
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testSphereRadius0()
	{
		final Sphere test = new Sphere(new Point(1,2,3),0);			//random Point
	}
	/**
	 * Test NullPointerException.
	 */
	@Test(expected=NullPointerException.class)
	public void testSphereCenter()
	{
		@SuppressWarnings("unused")
		final Sphere test = new Sphere(TESTPOINT,3);					//random Radius
	}
	/**
	 * Test NullPointerException.
	 */
	@Test(expected=NullPointerException.class)
	public void testIntersectionNullRay()
	{
		final Sphere testSphere =new Sphere(new Point(1,2,3),4);
		testSphere.intersections(null);
	}
	/**Test für keinen Schnittpunkt.*/
	@Test 
	public void testNoIntersectionsI(){
		final Ray testRay=new Ray(new Point(2,2,2),new Vector(1,1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final int want=0;
		final int have=testSphere.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für keinen Schnittpunkt.*/
	@Test 
	public void testNoIntersectionsII(){
		final Ray testRay=new Ray(new Point(-2,-2,-2),new Vector(-1,-1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final int want=0;
		final int have=testSphere.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für keinen Schnittpunkt.
	 * Dieser Test ist sehr knapp und soll zeigen bis 
	 * zu welcher Nachkommastelle genau gerechnet wird.
	 * Würde man eine weitere 0 hinzufügen, würde der Test
	 * einen Fehler anzeigen, da ein Schnittpunkt bestünde.*/
	@Test 
	public void testNoIntersectionsIII(){
		final Ray testRay=new Ray(new Point(0,0,1.000000000000001),new Vector(0,1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final int want=0;
		final int have=testSphere.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsI(){
		final Ray testRay=new Ray(new Point(0,0,1),new Vector(0,1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0,0,1),testSphere, 0,true);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsII(){
		final Ray testRay=new Ray(new Point(0,0,1),new Vector(0,1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0,0,1),testSphere, 0,true);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsIII(){
		final Ray testRay=new Ray(new Point(0,0,0),new Vector(0,1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0,1,0),testSphere, 1,false);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsIV(){
		final Ray testRay=new Ray(new Point(0,0,0),new Vector(0,-1,0));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0,-1,0),testSphere, 1,false);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsV(){
		final Ray testRay=new Ray(new Point(0,0,3),new Vector(0,0,-1));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0,0,1),testSphere,2,true);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsVI(){
		final Ray testRay=new Ray(new Point(2,2,2),new Vector(-1,-1,-1));
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Intersection want=new Intersection(new Point(0.5773502691896257,
														   0.5773502691896257,
														   0.5773502691896257),testSphere,2.46410161513775,true);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test 
	public void testIntersectionsVII(){
		final Ray testRay=new Ray(new Point(0,0,0),new Vector(-1,-1,-1));
		final Sphere testSphere=new Sphere(new Point(5,2,-10),15);
		final Intersection want=new Intersection(new Point(-6.74456264653803,
														   -6.74456264653803,
														   -6.74456264653803),testSphere,11.6819251786351,false);
		final Intersection have=testSphere.intersections(testRay).get(0);
		assertEquals(want,have);
	}
	/**Test für Normale.*/
	@Test
	public void testNormaleI(){
		final Sphere testSphere=new Sphere(new Point(0,0,0),1);
		final Vector have=testSphere.getNormal(new Point(0,0,1));
		final Vector want=new Vector(0,0,1).getNormalizedVector();
		assertEquals(want,have);
	}
}
