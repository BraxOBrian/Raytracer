package com.gmail.thomasmoosburg.lab05.scene;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Intersection;
/**
* Klasse definiert eine Plane und berechnet den Schnittpunk mit einem Ray. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public interface Scene 
{
	/** 
	 * Finds intersection points.
	 * @param ray Ray
	 * @return Intersection mit kürzester Distanz
	 */
	Intersection findIntersection(Ray ray);

	/**
	 * Looker zurück geben.
	 * @return Looker
	 */
	Looker getLooker();
	/**
	 * Getter für Light.
	 * @return Point light
	 */
	Point getLight();
}