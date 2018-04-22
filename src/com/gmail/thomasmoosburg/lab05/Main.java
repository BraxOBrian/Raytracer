package com.gmail.thomasmoosburg.lab05;

import java.io.IOException;

import com.gmail.thomasmoosburg.lab05.image.ImageFactory;
import com.gmail.thomasmoosburg.lab05.raster.Raster;
import com.gmail.thomasmoosburg.lab05.raster.RasterFactory;
import com.gmail.thomasmoosburg.lab05.scene.Scene;
import com.gmail.thomasmoosburg.lab05.scene.SceneFactory;
import com.gmail.thomasmoosburg.lab05.tracer.Raytracer;
/**
 * The program prints an ASCII portable gray map (pgm) image to System.out.
 */

public class Main 
{
	/** int resolution.*/
	private static final String WIDTH = "4096"; 
	/**int resolution.*/
	private static final String HEIGHT = "4096";
	 /**
     * The program prints an ASCII portable gray map (pgm) image to System.out.
     * @param args Command line args: none.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
     */
    public static void main(final String... args) throws IOException, ClassNotFoundException
    {
    	//final Scene scene=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","plane [0 -1 0] <-1 5 0>"); //entspricht StaticPlaneScene
    	//final Scene scene2=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","sphere [0 0 -5] 1","plane [0 -3 0] <0 1 0>");
    	//final Scene scene3=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","sphere [0 0 -5] 1"); //entspricht StaticSphereScene
    	//final Scene scene4=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [0 5 0]","sphere [2 1 -10] 1"); //entspricht StaticShiftedSphereScene
    	//final Scene scene5=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light 0 5 0","sphere [0 0 -5] 1","sphere [0 0 -10] 2");
    	final Scene scene5=SceneFactory.make("ScriptedScene","looker [0 0 5] [0 0 0] 2 2","light [2 10 0]","sphere [0 0 -4] 1","ambient 0.05","diffuse 0.8","specular 1 60","plane [0 -1.5 0] <0 1 0");
    	
    	//final Scene scene6=SceneFactory.make("LoadedScene","schatten.txt");
    	final Raytracer tracer = new Raytracer(scene5);
    	final Raster raster=RasterFactory.make("ArrayRaster",WIDTH,HEIGHT).render(tracer);
		ImageFactory.make("PNGImage","test.png").save(raster);
		//ImageFactory.make("PGMOut").save(raster);
		//new PGMOut().save(raster);
    	
    }
}
