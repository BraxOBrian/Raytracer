package com.gmail.thomasmoosburg.lab05.raster;

import com.gmail.thomasmoosburg.lab05.tracer.Raytracer;

/**
* Klasse definiert das ArrayRaster der Helligkeit. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
class ArrayRaster implements Raster 
{
	/**Konstante für Weiß-Wert.*/
	private static final int WHITE=255;
	/** Brightness.*/
	private final int[][] brightness;
	/** Width.*/
	private final int width;
	/** Heigth.*/
	private final int height;
	/** 
	 * Dies ist der Konstruktor von ArrayRaster.
	 * @param width int
	 * @param height int
	 * @throws IllegalArgumentException
	 */
	public ArrayRaster(int width, int height)
	{
    	if(width<1||height<1)
    	{
			 throw new IllegalArgumentException("resolution too small");
    	}
		this.width=width;
		this.height=height;
		brightness=new int[height][width];
	}
	
	 /**
     * Array wird befüllt und auf skaliert.
     *
     * @param tracer Raytracer
     * @return Raster.
     */

	@Override
	public Raster render(Raytracer tracer)
	{
	    	if(width<1||height<1)
	    	{
				 throw new IllegalArgumentException("resolution too small");
	    	}
	        // Trace rays through viewport pixels from top to bottom, each row left to right ...
	    	int yyy = 0;
	        for(int countery = height - 1; countery >= 0; ++yyy, countery--)
	        {
	        	
	            for(int counterx = 0; counterx < width; counterx++)
	            {
	            	// x, y coordinates of pixel on viewport
	                final double viewportX=(2.0*counterx+1)/width-1;
	                final double viewportY=(2.0*countery+1)/height-1;
	                brightness[yyy][counterx]=(int) (tracer.tracePrimary(viewportX, viewportY)*WHITE);
	            }
	        }
	        return this;        
	 }
	
	@Override
	public int getWidth()
	{
		return width;
	}
	
	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public int getPixel(int pixely,int pixelx)
	{
		return brightness[pixely][pixelx];
	}

}
