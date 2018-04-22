package com.gmail.thomasmoosburg.lab05.image;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

import javax.imageio.ImageIO;

import com.gmail.thomasmoosburg.lab05.raster.Raster;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Diese Klasse erzeugt ein PNG File.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
class PNGFile implements Image 
{
	/**Zielpfad auf dem das PNG abgespeichert werden soll.*/
	private final String filepath;
	/**
	 * Konstruktor für PNGFile. Verlangt den Pfad des Bildes als Eingabe.
	 * @param filepath String
	 */
	public PNGFile(String filepath){
		this.filepath=filepath;
	}
	/** 
	 * Erzeugt das PNG File unter dem namen "test".
	 * @param raster Raster
	 * @return void 
	 */
    @Override
	public void save(Raster raster) throws IOException 
    {
        // Kommandozeilenargumente auswerten
        final int width = raster.getWidth();
        final int height = raster.getHeight();

        // Das Bild im Speicher zusammenbauen
        final BufferedImage image = new BufferedImage(width, height, TYPE_INT_ARGB);
        for(int countery =0; countery<height; countery++)
            for(int counterx = 0; counterx < width; counterx++)
                // Das Pixel an Position (x, y) setzen
                image.setRGB(counterx, countery, byteToARGB(raster.getPixel(countery, counterx)));

        // Das Bild auf die Datei schreiben
        ImageIO.write(image, "png", new File(filepath));
    }

    /**
     * Berechnet aus einer Helligkeit den korrespondierenden ARGB-Farbwert.
     *
     * @param brightness Helligkeit zwischen 0 = schwarz und 255 = weiss.
     * @return Farbwert im ARGB-Format.
     */
    private static int byteToARGB(int brightness) 
    {
        final int bitsInByte = 8;
        final int opaqueBitmask = 0xFF;
        return ((opaqueBitmask << bitsInByte | brightness) << bitsInByte | brightness) << bitsInByte | brightness;
    }
}
