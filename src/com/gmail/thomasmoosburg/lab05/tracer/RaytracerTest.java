package com.gmail.thomasmoosburg.lab05.tracer;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.scene.Scene;
import com.gmail.thomasmoosburg.lab05.scene.SceneFactory;
/**
 *Testklasse für die Klasse Raytracer.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
//CHECKSTYLE:OFF MagicNumber
//CHECKSTYLE:OFF MultipleStringLiteralsCheck
@SuppressWarnings({"PMD.MethodNamingConventions","PMD.TooManyMethods","PMD.AvoidDuplicateLiterals"})
public class RaytracerTest
{
	/**Toleranz für Rundungsfehler.*/
	private static final double DELTA=2.41*Math.pow(10, -10);
	/**Test Raytracer für Exceptiontests.*/
	private final Raytracer testTracer;
	/**Test IllegalArgumentException.
	 * Höhe kleiner -1
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	
	public RaytracerTest() throws ClassNotFoundException, IOException 
	{
		testTracer=new Raytracer(SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light 0 5 0","sphere [0 0 -5] 1","ambient 0.0","diffuse 1.0"));
	}
	/**Test von IllegalArgumentException.*/
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentI()
	{
		final double have=testTracer.tracePrimary(-2,0);
	}
	/**Test IllegalArgumentException.
	 * Width kleiner -1
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentII()
	{
		final double have=testTracer.tracePrimary(0,-2);
	}
	/**Test IllegalArgumentException.
	 * Höhe größer 1
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentIII()
	{
		final double have=testTracer.tracePrimary(2,0);
	}
	/**Test IllegalArgumentException.
	 * Width größer 1
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentIV()
	{
		final double have=testTracer.tracePrimary(0,2);
	}
	/**Test: Kein Licht vorhanden.
	 * @throws ClassNotFoundException 
	 * @throws IOException */
	@Test
	public void testNoLight() throws ClassNotFoundException, IOException
	{
		final Scene testScene=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","sphere [0 0 -5] 1","sphere [0 0 -10] 1");
		final Raytracer test=new Raytracer(testScene);
		final double have=test.tracePrimary(0.5, 0.5); //random values between -1 and 1
		final double want=0.0;
		assertEquals(want,have,DELTA);
	}
	/**Test von TracePrimary.*/
	@Test
	public void testTracePrimaryI()
	{
		final double have=testTracer.tracePrimary(-0.5,0.5);
		final double want=0;
		assertEquals(want,have,DELTA);
	}
	/**Test von TracePrimary.*/
	@Test
	public void testTracePrimaryII()
	{
		final double have=testTracer.tracePrimary(0,0);
		final double want=0.624695047554424;
		assertEquals(want,have,DELTA);
	}
	/**Test von TracePrimary.
	 * @throws ClassNotFoundException 
	 * @throws IOException */
	@Test
	public void testTracePrimary() throws ClassNotFoundException, IOException	
	{
	final Scene testScene=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light 0 5 0","sphere [0 0 -5] 1","ambient 0.0","diffuse 1.0","sphere [0 0 -16] 0.5","ambient 0.0","diffuse 1.0");
	final Raytracer test=new Raytracer(testScene);
	final double want=0.624695047554424;
	final double have=test.tracePrimary(0,0);

	assertEquals(want, have,DELTA);
	}
}


