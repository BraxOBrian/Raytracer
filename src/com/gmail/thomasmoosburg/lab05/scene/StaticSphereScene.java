package com.gmail.thomasmoosburg.lab05.scene;


import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Sphere;
/**
* Klasse definiert Scene mit Sphere. 
* Ebenso wird die Gr��e des Viewports festgelegt.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class StaticSphereScene extends BaseScene
{
	/** Sphere der Scene.*/
	private static final Sphere SPHERE = new Sphere(new Point(0,0,-5),1);
	/**
	 * Superkonstruktor.
	 */
	public StaticSphereScene() 
	{
		super(SPHERE);
	}
	@Override
	public Point getLight() 
	{
		return null;
	}

}
