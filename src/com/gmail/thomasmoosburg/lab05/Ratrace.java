/* (C) 2015, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_05, Linux i386 4.0.1
 * emma (Intel Core i7-4790 CPU/3601 MHz, 8 Cores, 32256 MB RAM)
 */
package com.gmail.thomasmoosburg.lab05;

import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Stream;

import com.gmail.thomasmoosburg.lab05.image.ImageFactory;
import com.gmail.thomasmoosburg.lab05.raster.Raster;
import com.gmail.thomasmoosburg.lab05.raster.RasterFactory;
import com.gmail.thomasmoosburg.lab05.scene.Scene;
import com.gmail.thomasmoosburg.lab05.scene.SceneFactory;
import com.gmail.thomasmoosburg.lab05.tracer.Raytracer;

/**
 * Main program for the raytracer.
 *
 * @author R. Schiedermeier
 * @version 2015-04-12
 */
public class Ratrace {
    /**
     * Entry point. Accepts strings
     * scene=Classname,arg1,arg2,...
     * raster=Classname,arg1,arg2,...
     * image=Classname,arg1,arg2,...
     *
     * Tries commandline args, then system properties, then environment vars.
     * Uses default values if nothing found.
     *
     * @param args Command line args: see above.
     * @exception ClassNotFoundException if a class does not exist.
     * @exception IOException            is a file cannot be read or written.
     */
    public static void main(final String... args) throws ClassNotFoundException, IOException {
        // Map commandline args key=values to properties
        final Properties commandlineArgs = Stream.of(args)
                .map(arg -> splitAtChar(arg, '='))
                .collect(Properties::new,
                         (properties, pair) -> properties.setProperty(pair[0], pair[1]),
                         Properties::putAll);

        // Search commandline args properties, then system properties, then environment variables for key
        // Fall back to empty string, if nothing found
        // Use first non-null value and split it at commas
        final Function<String, String[]> nameToArgs = key ->
                splitAtChar(Stream.of(commandlineArgs.getProperty(key),
                                      System.getProperty(key),
                                      System.getenv(key),
                                      "")
                                    .filter(values -> values != null)
                                    .findFirst()
                                    .get(),
                            ',');

        // Build and run raytracer pipeline
        final Scene scene = SceneFactory.make(nameToArgs.apply("scene"));
        final Raytracer raytracer = new Raytracer(scene);
        final Raster raster = RasterFactory.make(nameToArgs.apply("raster")).render(raytracer);
        ImageFactory.make(nameToArgs.apply("image")).save(raster);
    }

    /**
     * Split a string at given char and return pieces in an array.
     *
     * This method replaces String.split.
     * However, the problem statement prohibits direct or indirect use of regexes, so we do it on our own.
     * Anyway, this is interesting by itself :-)
     *
     * @param string   String to split.
     * @param splitter Char to split string at.
     * @return Array of pieces without split chars.
     */
    private static String[] splitAtChar(String string, char splitter) {
        return splitAtChar(string, splitter, 0);
    }

    /**
     * Split a string at given char and return pieces in an array.
     *
     * @param string   String to split.
     * @param splitter Char to split string at.
     * @param index    Index of array element to place next piece in.
     * @return Array of pieces without split chars.
     */
    private static String[] splitAtChar(String string, char splitter, int index) {
        final String[] result;
        final int splitterAt = string.indexOf(splitter);
        if(splitterAt < 0) {
            result = new String[index + 1];
            result[index] = string;
        }
        else {
            result = splitAtChar(string.substring(splitterAt + 1), splitter, index + 1);
            result[index] = string.substring(0, splitterAt);
        }
        return result;
    }
}
