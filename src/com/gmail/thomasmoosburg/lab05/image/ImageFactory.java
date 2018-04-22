package com.gmail.thomasmoosburg.lab05.image;
/**
 *Factoryklasse für Images. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 13.05.2015
*/
public class ImageFactory {
	/**
	 * Factorymethode für ein Image. 
	 * Default ist PGMOut.
	 * @param args List of Arguments
	 * @return Image image
	 * @throws ClassNotFoundException falls es diese ImageKlasse nicht gibt.
	 */
	public static Image make(String...args) throws ClassNotFoundException{
		if(args==null){
			throw new NullPointerException();
		}
		//Default Objekt
		if(args[0].isEmpty()){
			return new PGMOut();
		}
		if("PNGImage".equals(args[0])&&args.length==2){
			return new PNGFile(args[1]);
		}
		if("PGMOut".equals(args[0])&&args.length==1){
			return new PGMOut();
		}
		else
			throw new ClassNotFoundException();
	}
}
