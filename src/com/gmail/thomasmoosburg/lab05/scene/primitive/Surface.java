package com.gmail.thomasmoosburg.lab05.scene.primitive;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
/**
 *Beschreibt die Oberflächeneigenschaften eines Objekts(Primitives).
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 19.05.2015
*/
public class Surface 
{
	/**Maximaler Exponent für SpecularExponent.*/
	private static final int MAXEXPONENT=1000;
	/**EnumMap in der die gesetteten Propertys mit ihren Values aufgelistet sind.*/
	private final Map<Property,Double> surfaceMap=new EnumMap<Property,Double>(Property.class);
	/**Liste mit Propertys deren Werte bereits gesetzt wurden.
	 * Dient zur Überprüfung, dass die Werte von Properties nur
	 * einmal gesetzt werden dürfen.*/
	private final List<Property> counters=new ArrayList<>();
	/**
	  *Enum enthält mögliche Eigenschaften von Surface mit Defaultwerten.
	  * @author Lausch Sebastian, slausch@hm.edu
	  * @author Schulz Thomas, thomasmoosburg@gmail.com
	  * @version 4.0, 26.04.2015
	  */
	public static enum Property {AmbientRatio(0.05), DiffuseRatio(0.95),SpecularRatio(0),SpecularExponent(30);
		/**Defaultwert.*/
		private final double value;
		/**Konstruktor weist property seinen Defaultwert zu.
		 * @param value Defaultvalue of property*/
		Property(double value){
			this.value=value;
		}
	}
	/**Getter für den Wert einer Property.
	 * @return double value of property
	 * @param property Property*/
	public double get(Property property)
	{
		if(counters.contains(property)){
			return surfaceMap.get(property);
			
		}
		else
			return property.value;
	}
	/**
	 * Setzt einen neuen Wert für ein Property. 
	 * Darf nur einmal pro Property gesetzt werden. 
	 * @param property Property
	 * @param newValue double
	 */
	public void set(Property property, double newValue)
	{
		if(checkValue(property, newValue)){
			if(counters.contains(property)){
				throw new IllegalStateException();
			}
			else{
				surfaceMap.put(property, newValue);
				counters.add(property);
			}
		}
		else
			throw new IllegalArgumentException();
	}
	/**
	 * Simply checking if newValue is a correct value.
	 * @param property Property
	 * @param newValue double
	 * @return boolean 
	 */
	private boolean checkValue(Property property,double newValue){
		if(property==Property.SpecularExponent&&newValue>=0&&newValue<=MAXEXPONENT){
			return true;
		}
		else 
			return newValue<=1&&newValue>=0;
	}
}
