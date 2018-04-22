package com.gmail.thomasmoosburg.lab05.image;

import java.io.IOException;

import com.gmail.thomasmoosburg.lab05.raster.Raster;
/**
 *Interface für die Verarbeitung der Ergebnisse des Raytracers zu Bildern.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 13.05.2015
*/
public interface Image {

	/**
	 * Entry-Point. Schreibt ein monochromes png-File.
	 * Beispiel: java PNGFileDemo 640 480 224 lightgray.png
	 *@param raster Raster
	 * @throws IOException wenn die Datei nicht geschrieben werden kann.
	 */
	void save(Raster raster) throws IOException;

}