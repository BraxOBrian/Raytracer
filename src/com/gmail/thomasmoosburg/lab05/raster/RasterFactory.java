package com.gmail.thomasmoosburg.lab05.raster;
/**
 *Factoryklasse für Raster. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 13.05.2015
*/
public class RasterFactory {
	/**Defaultwert für die Auflösung eines Rasters.*/
	private static final int DEFAULTRESOLUTION=128;
	/**maximale Anzahl von argumenten.*/
	private static final int MAXARGUMENTS=3;
	/**
	 *Factorymethode für einen Raster.
	 *@param args Liste von Argumenten
	 *@return ArrayRaster
	 *@throws ClassNotFoundException wenn kein Raster mit dem gegebenen Namen existiert.
	 */
	public static Raster make(String...args) throws ClassNotFoundException{
		if(args==null){
			throw new NullPointerException();
		}
		//Default Objekt.
		if(args[0].isEmpty()){
			return new ArrayRaster(DEFAULTRESOLUTION,DEFAULTRESOLUTION);
		}
		if("ArrayRaster".equals(args[0])&&args.length==MAXARGUMENTS){
			return new ArrayRaster(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		}
		else
			throw new ClassNotFoundException();
	}

}
