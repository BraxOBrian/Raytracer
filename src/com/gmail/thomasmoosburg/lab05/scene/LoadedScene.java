package com.gmail.thomasmoosburg.lab05.scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *LoadedScene holt sich die Szenenbeschreibung aus einem Textfile.
 *Wird anschließend an Scripted Scene übergeben und dort ausgewertet.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @author Schiedermeier, Reinhard
* @version 4.0, 26.04.2015
*/
public class LoadedScene extends ScriptedScene 
{
	/**
	 * siehe oben.
	 * @param filename String
	 * @throws IOException ask prof
	 */
	public LoadedScene(final String filename) throws IOException 
	{
        super(Files.lines(Paths.get(filename)).toArray(String[]::new));
    }
}