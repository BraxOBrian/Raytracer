package com.gmail.thomasmoosburg.lab05.scene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Intersection;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Plane;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Primitive;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Sphere;
import com.gmail.thomasmoosburg.lab05.scene.primitive.Surface.Property;
/**
 *Klasse ScriptedScene.
 *erhält mehrere Argumente und bildet daraus eine Szene.
 *vergleichbar mit den StaticScenes, nur dass die Argumente
 *variabel sind. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 06.05.2015
*/
class ScriptedScene implements Scene
{
	/**looker der Szene, es darf nur einen geben.*/
	private Looker looker;
	/**light der Szene, mehrere möglich.
	 * nur eines soll benutzt werden.
	 */
	private Point light;
	/**Liste von Planes in dieser Szene.*/
	private final List<Primitive> objects=new ArrayList<>();


	
	/**Konstruktor von ScriptedScene.
	 * hier wird die Szene festgelegt. 
	 * @param args String
	 * @throws NullPointerException if null
	 * @throws IllegalArgumentException wenn ungültiges Argument
	 */
	public ScriptedScene(String...args) throws NullPointerException,IllegalArgumentException
	{
		final List<String> arguments;
		arguments=Arrays.asList(args);
		if(arguments==null)
			throw new NullPointerException();
		if(arguments.isEmpty())
			throw new IllegalArgumentException();
		
		for(final String counter:arguments)
		{
			final String currentString=deleteBraces(counter);
			if(!currentString.isEmpty())
			{
				getStuffDone(currentString);
			}
		}		
	}
	/**
	 * Setzt den Wert einer Property.
	 * Darf nur einmal pro Property gesetzt werden.
	 * @param value double 
	 * @param property Property
	 */
	private void setProperty(double value,Property property)
	{
			objects.get(objects.size()-1).getSurface().set(property, value);
	}
	
	@Override
	public Intersection findIntersection(Ray ray) 
	{
		final List<Intersection> intersectionList=new ArrayList<Intersection>();
		List<Intersection> temp=new ArrayList<Intersection>();

		for(int counter=0;counter<objects.size();counter++)
		{
			temp=objects.get(counter).intersections(ray);
			for(int counterA=0;counterA<temp.size();counterA++)
			{
				intersectionList.add(temp.get(counterA));
			}
		}	
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

	@Override
	public Point getLight() 

	{
		return light;
	}
	/**
	 * Gets all the stuff of ScriptedScene done.
	 * Is just here because of Complexity.
	 * @param currentString String
	 */
	private void getStuffDone(String currentString)
	{
		final StringIterator iterator=new StringIterator(currentString);
		final String start=iterator.next();
					
		if(start.startsWith("looker"))
		{
			this.looker=makeLooker(iterator);
		}
		else if(start.startsWith("light")){
			this.light=makeLight(iterator);
		}
		else if(start.startsWith("sphere")||start.startsWith("plane"))
		{
			makePlaneOrSphere(start, iterator);
		}
		else if(start.startsWith("ambient")){
			final double value=Double.parseDouble(iterator.next());
			setProperty(value,Property.AmbientRatio);
		}
		else if(start.startsWith("diffuse")){
			final double value=Double.parseDouble(iterator.next());
			setProperty(value,Property.DiffuseRatio);
		}
		else if(start.startsWith("specular")){
			final double value=Double.parseDouble(iterator.next());
			final double exponent=Double.parseDouble(iterator.next());
			setProperty(value,Property.SpecularRatio);
			setProperty(exponent,Property.SpecularExponent);
		}
		
	}
	/**
	 * Diese Methode entfernt die Klammern von einem übergebenen String.
	 * @param string String: übergebenes Argument
	 * @return String
	 */
	private String deleteBraces(String string)
	{
		String myString=string;
		myString = myString.replace("[", "");
		myString = myString.replace("]", "");
		myString = myString.replace("<", "");
		myString = myString.replace(">", "");
		return myString.trim();
	}
	/**
	 * makes the looker.
	 * just there to reduce Complexity.
	 * @param iterator StringIterator
	 * @return looker Looker
	 */
	private Looker makeLooker(StringIterator iterator){
		int lookerCounter=0;	
		if(lookerCounter<1)
			lookerCounter++;				
		else
			throw new IllegalArgumentException();
		final Point camera=new Point(Double.parseDouble(iterator.next()),
						   Double.parseDouble(iterator.next()),
						   Double.parseDouble(iterator.next()));
		final Point viewPortCenter=new Point(Double.parseDouble(iterator.next()),
			   					   Double.parseDouble(iterator.next()),
			   					   Double.parseDouble(iterator.next()));
		return new Looker(camera,viewPortCenter,Double.parseDouble(iterator.next()),Double.parseDouble(iterator.next()));
	}
	/**
	 * makes sphere or plane and adds them to the List.
	 * just there to reduce Complexity.
	 * @param start String
	 * @param iterator StringIterator
	 */
	private void makePlaneOrSphere(String start, StringIterator iterator){
		if(start.startsWith("sphere")){
			final Point sphereCenter=new Point(Double.parseDouble(iterator.next()),
				   	 					 Double.parseDouble(iterator.next()),
				   	 					 Double.parseDouble(iterator.next()));
			objects.add(new Sphere(sphereCenter,Double.parseDouble(iterator.next())));
		}
		else if(start.startsWith("plane")){
			final Point planeCenter=new Point(Double.parseDouble(iterator.next()),
	 					 Double.parseDouble(iterator.next()),
	 					 Double.parseDouble(iterator.next()));
			final Vector normal=new Vector(Double.parseDouble(iterator.next()),
	 					 Double.parseDouble(iterator.next()),
	 					 Double.parseDouble(iterator.next()));
			objects.add(new Plane(planeCenter,normal));
		}
	}
	/**
	 * makes a light.
	 * @param iterator StringIterator
	 * @return Point light
	 */
	private Point makeLight(StringIterator iterator){
		return new Point(Double.parseDouble(iterator.next()),
			   	 Double.parseDouble(iterator.next()),
			   	 Double.parseDouble(iterator.next()));
	}
}	
	/**
	*Innere Klasse StringIterator.
 	*Iteriert über einen String. 
 	* @author Lausch Sebastian, slausch@hm.edu
	* @author Schulz Thomas, thomasmoosburg@gmail.com
	* @version 5.0, 06.05.2015
	*/
	class StringIterator implements Iterator<String>
	{
		/**Variable für den momentan ausgewählten Char.*/
		private int current;
		/**String der iteriert wird.*/
		private final String myString;
		
		/**Konstruktor.
		 * @param string String: zu iterierender String
		 * Der String darf keine Leerzeichen am Anfang oder Ende haben
		 */
		public StringIterator(String string){
			this.current=0;
			this.myString=string;
		}
		/**prüft ob es einen weiteren String gibt.*/
		@Override
		public boolean hasNext() 
		{
			return current < myString.length();
		}
		/**gibt das nächste Element zurück.
		 * falls es ein solches gibt.*/
		@Override
		public String next() 
		{			
			if(!hasNext())
				throw new NoSuchElementException("there is no next");
			if(java.lang.Character.isSpaceChar(myString.charAt(current)))
				throw new IllegalArgumentException("watch out for spaces");
			int counter;
			counter=myString.indexOf(' ',current);
			if(counter==-1&&current>=0){
				final String result=myString.substring(current);
				current=myString.length();
				return result;
			}
			else{
			final String result=myString.substring(current,counter);
			current=counter+1;
			return result;		
			}
		}		
	}	
