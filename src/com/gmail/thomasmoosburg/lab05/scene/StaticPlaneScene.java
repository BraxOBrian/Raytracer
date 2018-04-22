package com.gmail.thomasmoosburg.lab05.scene;


import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Plane;
/**
* Klasse Scene mit einem Plane. 
* Ebenso wird die Gr��e des Viewports festgelegt.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class StaticPlaneScene extends BaseScene
{
	/** Plane der Scene.*/
	private static final Plane PLANE=new Plane(new Point(0,-1,0),new Vector(-1,5,0));
	/**
	 * Superkonstruktor.
	 */
	public StaticPlaneScene() 
	{
		super(PLANE);
	}
	@Override
	public Point getLight() 
	{
		return null;
	}
}
