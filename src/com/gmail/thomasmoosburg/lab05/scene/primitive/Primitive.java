package com.gmail.thomasmoosburg.lab05.scene.primitive;

import java.util.List;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
/**
 * Interface eines primitiven Objektes.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public interface Primitive 
{
	/**Liste eines Schnittpunktes.
	 * @param ray Ray
	 * @return intersection Intersection*/
	List<Intersection> intersections(Ray ray);
	/**
	 * Gibt die Normale(Vektor der senkrecht steht).
	 * @param point Point
	 * @return Vector normale
	 */
	Vector getNormal(Point point);
	/**
	 * Getter für Surface.
	 * @return surface Surface
	 */
	Surface getSurface();
}
