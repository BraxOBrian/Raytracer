package com.gmail.thomasmoosburg.lab05.scene.primitive;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
/**
 *Testklasse für die Klasse Plane.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class PlaneTest {
	
	/**Test für Exception bei Null-Vector.*/
	@SuppressWarnings("unused")
	@Test(expected=NullPointerException.class)
	public void testNullVector()
	{
		final Plane testPlane = new Plane(new Point(1,2,3),null);			//random Point
	}
	/**Test für Exception bei Null-Point.*/
	@SuppressWarnings("unused")
	@Test(expected=NullPointerException.class)
	public void testNullPoint()
	{
		final Plane testPlane = new Plane(null,new Vector(1,2,3));			//random Vector
	}
	/**Test für unendlich viele Schnittpunkte, Vektor ist in Ebene.*/
	@Test 
	public void testNoIntersectionsI(){
		final Ray testRay=new Ray(new Point(0,0,0),new Vector(1,1,0));
		final Plane testPlane=new Plane(new Point(0,0,0),new Vector(0,0,-1));
		final int want=0;
		final int have=testPlane.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für unendlich viele Schnittpunkte, Vektor ist in Ebene.*/
	@Test
	public void testNoIntersectionsII(){
		final Ray testRay=new Ray(new Point(1,1,1),new Vector(-1,-1,-1));
		final Plane testPlane=new Plane(new Point(0,0,0),new Vector(0,1,-1));
		final int want=0;
		final int have=testPlane.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für keinen Schnittpunkt.*/
	@Test
	public void testNoIntersectionsIII(){
		final Ray testRay=new Ray(new Point(0,0.25,1),new Vector(1,0,-1));
		final Plane testPlane=new Plane(new Point(0,0,1.25),new Vector(4,4,4));
		final int want=0;
		final int have=testPlane.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für keinen Schnittpunkt.*/
	@Test
	public void testNoIntersectionsIV(){
		final Ray testRay=new Ray(new Point(100,100,100),new Vector(1,0,-1));
		final Plane testPlane=new Plane(new Point(0,0,1.25),new Vector(4,4,4));
		final int want=0;
		final int have=testPlane.intersections(testRay).size();
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/
	@Test
	public void testIntersectionII() {
		final Ray testRay=new Ray(new Point(1,1,1), new Vector(-1, -1,-1));
		final Plane testPlane= new Plane(new Point(0,0,0), new Vector(0,0,1));
		final Intersection have=testPlane.intersections(testRay).get(0);
		final Intersection want=new Intersection(new Point(0,0,0),testPlane,1.732050807568877,true);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/	
	@Test
	public void testIntersectionIII() {
		final Ray testRay=new Ray(new Point(1,1,1), new Vector(-1, -1,-1));
		final Plane testPlane= new Plane(new Point(0,0,0), new Vector(0,1,0));
		final Intersection have=testPlane.intersections(testRay).get(0);
		final Intersection want=new Intersection(new Point(0,0,0),testPlane,1.732050807568877,true);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/	
	@Test
	public void testIntersectionIV() {
		final Ray testRay=new Ray(new Point(1,1,1), new Vector(-1, -1,-1));
		final Plane testPlane= new Plane(new Point(0,0,0), new Vector(1,0,0));
		final Intersection have=testPlane.intersections(testRay).get(0);
		final Intersection want=new Intersection(new Point(0,0,0),testPlane,1.732050807568877,true);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/	
	@Test
	public void testIntersectionV() {
		final Ray testRay=new Ray(new Point(23,5,14), new Vector(-1, -1,-1));
		final Plane testPlane= new Plane(new Point(0,0,0), new Vector(1,0,0));
		final Intersection have=testPlane.intersections(testRay).get(0);
		final Intersection want=new Intersection(new Point(0,-18.0,-9.0),testPlane,39.8371685740842,true);
		assertEquals(want,have);
	}
	/**Test für einen Schnittpunkt.*/	
	@Test
	public void testIntersectionVI() {
		final Ray testRay=new Ray(new Point(-46,20,140), new Vector(0, 0,-1));
		final Plane testPlane= new Plane(new Point(0,0,0), new Vector(0,0,1));
		final Intersection have=testPlane.intersections(testRay).get(0);
		final Intersection want=new Intersection(new Point(-46.0,20,0),testPlane,140.0,true);
		assertEquals(want,have);
	}
	/**Test der Normalen.*/
	@Test
	public void testNormal(){
		final Plane testPlane=new Plane(new Point(0,0,0),new Vector(0,0,-1));
		final Vector have=testPlane.getNormal(new Point(-46,20,0));
		final Vector want=new Vector(0,0,-1).getNormalizedVector();
		assertEquals(want,have);
	}
}
