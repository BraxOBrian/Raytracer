package com.gmail.thomasmoosburg.lab05.image;

import com.gmail.thomasmoosburg.lab05.raster.Raster;

/**
 * Klasse um int Werte in PGM umzuwandeln.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
class PGMOut implements Image
{
	/** 
	 * Wandelt Werte eines Rasters zu String um.
	 * @param brightness Raster
	 * @return String 
	 */
	public String asString(Raster brightness)
    {
		if(brightness==null)
		{
			throw new NullPointerException();
		}
		if(brightness.getHeight()<1||brightness.getWidth()<1)
		{
			throw new IllegalArgumentException();
		}
		
		final StringBuilder output= new StringBuilder();
		// print PGM file header
		output.append("P2\n"+brightness.getWidth()+ " " +brightness.getHeight()+"\n255\n");       
		for(int yCount = 0; yCount<brightness.getHeight(); yCount++) 
		   {
				for(int xCount = 0; xCount <brightness.getWidth(); xCount++) 
				{
					output.append(brightness.getPixel(yCount, xCount)).append(' ');
				}
			output.append('\n');
        	
		   }
        return output.toString();
    }

	/**
	 * Gibt String für PGM auf Konsole aus.
	 * @param brightness Raster
	 */
	public void save(Raster brightness)
	{
		System.out.println(asString(brightness));       
	}
}
