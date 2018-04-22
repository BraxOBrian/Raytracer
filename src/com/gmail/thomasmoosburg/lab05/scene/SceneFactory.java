package com.gmail.thomasmoosburg.lab05.scene;

import java.io.IOException;

/**
 *Factoryklasse für Scenes. 
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 5.0, 13.05.2015
*/
public class SceneFactory 
{
	/**
	 * Factorymethode für eine Scene.
	 * @param args List of Arguments
	 * @return Scene 
	 * @throws ClassNotFoundException angeforderte Scene existiert nicht.
	 * @throws IOException ask whoever.
	 */
	public static Scene make(String...args) throws ClassNotFoundException, IOException
	{
		if(args==null)
		{
			throw new NullPointerException();
		}
		//Default-Objekt
		if(args[0].isEmpty())
		{
			return new ScriptedScene("looker [0 0 5] [0 0 0] 2 2",
				       "sphere [0 0 -5] 1",
				       "ambient 1");
		}
		if("ScriptedScene".equals(args[0]))
		{
			final String[]temp=new String[args.length-1];
			System.arraycopy(args, 1,temp, 0, args.length-1);
			return new ScriptedScene(temp);
		}
		if("LoadedScene".equals(args[0])&&args.length==2)
		{
			return new LoadedScene(args[1]);
		}
		else
			throw new ClassNotFoundException();
	}

}
