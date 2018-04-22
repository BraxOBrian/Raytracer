package com.gmail.thomasmoosburg.lab05.raster;

import com.gmail.thomasmoosburg.lab05.tracer.Raytracer;
/**
* Klasse definiert ein Raster. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public interface Raster {

	/** 
	 * Array wird befüllt und auf skaliert.
	 * @param tracer Raytracer
	 * @return Raster
	 */
	Raster render(Raytracer tracer);
	/**Getter Width.
	 * @return int width*/
	int getWidth();
	/**Getter Height.
	 * @return int height*/
	int getHeight();
	/**Getter Pixel.
	 * @param pixely int
	 * @param pixelx int
	 * @return int
	 * */
	int getPixel(int pixely, int pixelx);

}