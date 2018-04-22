package com.gmail.thomasmoosburg.lab05.scene;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
/**Test für Scripted Scene.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 06.05.2015
*/
//CHECKSTYLE:OFF MultipleStringLiteralsCheck
public class ScriptedSceneTest {

	/**Konstante für Rundungsfehler.*/
	private static final double DELTA =2.41*Math.pow(10, -10);
	/**Test of NullPointerException.*/
	@SuppressWarnings("unused")
	@Test(expected=NullPointerException.class)
	public void testNullPointerException1() {
		final ScriptedScene test=new ScriptedScene(null);		
	}
	
	/**Test of IllegalArgumentException.
	 * too many looker.*/
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testTooManyLooker() {
		final ScriptedScene test=new ScriptedScene("looker [0 0 5] [0 0 0] 2 2","looker [0 0 5] [0 0 0] 2 2");		
	}
	/**Test of IllegalArgumentException.
	 * Kein String übergeben.
	 */
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyString() {
		final ScriptedScene test=new ScriptedScene();		
	}
	/**Test of Light.*/
	@SuppressWarnings("unused")
	@Test
	public void testLight() {
		final ScriptedScene test=new ScriptedScene("looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","plane [0 -1 0] <-1 5 0>");	
		final Point have=test.getLight();
		final Point want=new Point(0,5,0);
	}
	/**Test of Looker.*/
	@Test
	public void testLooker() {
		final ScriptedScene test=new ScriptedScene("looker [0 0 5] [0 0 0] 2 2");	
		final Point haveCenter=test.getLooker().getViewPortCenter();
		final Point wantCenter=new Point(0,0,0);
		assertEquals(wantCenter,haveCenter);
		final Point haveCamera=test.getLooker().getCamera();
		final Point wantCamera=new Point(0,0,5);
		assertEquals(wantCamera,haveCamera);
		final double wantWidth=2.0;
		final double haveWidth=test.getLooker().getWidth();
		assertEquals(wantWidth,haveWidth,DELTA);
		final double wantHeight=2.0;
		final double haveHeigth=test.getLooker().getHeight();
		assertEquals(wantHeight,haveHeigth,DELTA);
	}
}
