package com.gmail.thomasmoosburg.lab05;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
*Tests images by pixel.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class TestImages {
	/**
	 * Checks images.
	 * @param args Strings
	 * @throws Exception kjl
	 */
	@SuppressWarnings({ "PMD.OneDeclarationPerLine",
			"PMD.LocalVariableCouldBeFinal" })
	public static void main(String[] args) throws Exception {
        final BufferedImage image = ImageIO.read(new File("C:/Users/Thomas/Desktop/Workspace/Raytracer05/test.png"));
        final BufferedImage referenceImage = ImageIO.read(new File("C:/Users/Thomas/Desktop/Workspace/Raytracer05/fractal-4096x4096.png"));
        for (int x = 0, maxX = image.getWidth(); x < maxX; x++) 
        {
            for (int y = 0, maxY = image.getHeight(); y < maxY; y++) 
            {
                final double pixel =new Color(image.getRGB(y, x),true).getRed()*0.299+0.587*new Color(image.getRGB(y, x),true).getGreen()+0.114*new Color(image.getRGB(y, x),true).getBlue();
                final double referencepixel=new Color(referenceImage.getRGB(y, x),true).getRed()*0.299+0.587*new Color(referenceImage.getRGB(y, x),true).getGreen()+0.114*new Color(referenceImage.getRGB(y, x),true).getBlue();
                final double delta=Math.abs(pixel-referencepixel);
                
                if(delta>3)
                	System.out.println("Fehler bei: "+"X="+x+" "+"Y="+y+" "+"WertPixel: "+pixel+" WertRef: "+referencepixel+" DELTA: "+delta);
            }
        }
        System.out.println("done");
	}

}
