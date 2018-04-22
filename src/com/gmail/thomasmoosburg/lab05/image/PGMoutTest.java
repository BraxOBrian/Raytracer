package com.gmail.thomasmoosburg.lab05.image;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.raster.Raster;
import com.gmail.thomasmoosburg.lab05.raster.RasterFactory;
import com.gmail.thomasmoosburg.lab05.scene.Scene;
import com.gmail.thomasmoosburg.lab05.scene.SceneFactory;
import com.gmail.thomasmoosburg.lab05.tracer.Raytracer;
/**
 *Testklasse für die Klasse Vector.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
//CHECKSTYLE:OFF MagicNumber
//CHECKSTYLE:OFF MultipleStringLiteralsCheck

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class PGMoutTest 
{
	/** String für resolution 3.*/
	private static final String STRINGCONST3="P2\n3 3\n255\n0 0 0 \n0 159 0 \n0 0 0 \n";
	/** String für resolution 11. */
	private static final String STRINGCONST11="P2\n11 11\n255\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 234 254 234 0 0 0 0 "
														+ "\n0 0 0 157 207 221 207 157 0 0 0 "
														+ "\n0 0 0 104 147 159 147 104 0 0 0 "
														+ "\n0 0 0 20 66 78 66 20 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 "
														+ "\n0 0 0 0 0 0 0 0 0 0 0 \n";
	/** Test Scene.*/
	private final Scene testScene; 
	/** Test PGMout.*/
	private final PGMOut test=new PGMOut();
	/**
	 * Testklasse für PGMout.
	 * @throws ClassNotFoundException bla
	 * @throws IOException bla
	 */
	public PGMoutTest() throws ClassNotFoundException, IOException
	{
		testScene=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","sphere [0 0 -5] 1","ambient 0.0","diffuse 1.0");//entspricht StaticSphereScene
	}
	
	/**
	 * Test ob Int-Arrays richtig zu Strings verarbeitet werden für Resolution 11.
	 * @throws ClassNotFoundException 
	 */
	@Test public void testToRaster11() throws ClassNotFoundException
	{
		final Raster raster =RasterFactory.make("ArrayRaster","11","11").render(new Raytracer(testScene));
		final String want=STRINGCONST11;
		final String have=test.asString(raster);
		assertEquals(want,have);
	}
	/**
	 * Test ob Int-Arrays richtig zu Strings verarbeitet werden für Resolution 3.
	 * @throws ClassNotFoundException 
	 */
	@Test public void testToRaster3() throws ClassNotFoundException
	{
		final Raster raster =RasterFactory.make("ArrayRaster","3","3").render(new Raytracer(testScene));
		final String want=STRINGCONST3;
		final String have=test.asString(raster);
		assertEquals("testToRaster(3)",want,have);
	}
	/**
	 * Test ob Zeitlimit auch bei hochauflösenden Bildern nicht überschritten wird.
	 * @throws ClassNotFoundException 
	 */
	@Test (timeout=5000) public void testToRaster1200() throws ClassNotFoundException
	{
		final Raster raster =RasterFactory.make("ArrayRaster","1200","1200").render(new Raytracer(testScene));
		test.asString(raster);
	}
	/**
	 * Test von IllegalArgumentException.
	 * @throws ClassNotFoundException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testToRaster0() throws ClassNotFoundException
	{
		final Raster raster =RasterFactory.make("ArrayRaster","0","0").render(new Raytracer(testScene));
		test.asString(raster);
	}
	/**
	 * Test von IllegalArgumentException.
	 * @throws ClassNotFoundException 
	 */
	@Test(expected=IllegalArgumentException.class) 
	public void testToRasterNeg1() throws ClassNotFoundException
	{
		final Raster raster =RasterFactory.make("ArrayRaster","-1","-1").render(new Raytracer(testScene));
		test.asString(raster);
	}

}
