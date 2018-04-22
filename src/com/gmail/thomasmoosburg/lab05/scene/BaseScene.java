package com.gmail.thomasmoosburg.lab05.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Intersection;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Primitive;
/**
* Klasse definiert einen basis Scene. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public abstract class BaseScene implements Scene
{
	/**primitveObject vom Typ Primitive.*/
	private final Primitive primitivObject;
	/**festgelegter Standard-Looker.*/
	private final Looker looker=new Looker(new Point(0,0, 5),new Point(0, 0, 0),2,2);
	/**Konstruktor.
	 * @param primitiveObject Primitive*/
	public BaseScene(Primitive primitiveObject)
	{
		this.primitivObject=primitiveObject;
	}
	/**Finds intersection ob Primitive Object.
	 * @param ray Ray
	 * @return Intersection
	 * */
	public Intersection findIntersection(Ray ray) 
	{
		final List<Intersection> intersectionList=new ArrayList<Intersection>();
		intersectionList.addAll(primitivObject.intersections(ray));
		if(!intersectionList.isEmpty())
		{
			return Collections.min(intersectionList);
		}
		return null;
	}
	
	@Override
	public Looker getLooker() 
	{
		return looker;
	}
}
