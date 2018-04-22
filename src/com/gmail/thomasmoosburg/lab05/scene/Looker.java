package com.gmail.thomasmoosburg.lab05.scene;

import com.gmail.thomasmoosburg.lab05.geometry.Point;
import com.gmail.thomasmoosburg.lab05.geometry.Ray;
import com.gmail.thomasmoosburg.lab05.geometry.Vector;

/**
* Klasse definiert Lage von Kamera und Viewport. 
* Ebenso wird die Größe des Viewports festgelegt.
* @author Lausch Sebastian, slausch@hm.edu
* @author Schulz Thomas, thomasmoosburg@gmail.com
* @version 4.0, 26.04.2015
*/
public class Looker {
	
	/** Position of Camera.*/
	private final Point camera;
	/**Position of ViewPort Center.*/
	private final Point viewPortCenter;
	/**Width of ViewPort.*/
	private final Double width;
	/**Height of ViewPort.*/
	private final Double height;
	/**BlickVektor steht senkrecht auf ViewPort.*/
	private final Vector blickVektor;
	/**Vector right side.*/
	private final Vector rightVector;
	/**Vector up side.*/
	private final Vector upVector;
	
	/** 
	 * Dies ist der Konstruktor von Looker.
	 * @param camera Point Position of Camera
	 * @param viewPortCenter Point Position of ViewPortCenter
	 * @param width Double Width of ViewPort
	 * @param height Double Height of ViewPort
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Looker(Point camera,Point viewPortCenter,double width,double height)
	{
		if(camera == null || viewPortCenter == null)
			throw new NullPointerException();
		this.camera=camera;
		this.viewPortCenter=viewPortCenter;
		if(width<=0.0)
			throw new IllegalArgumentException("Width too small");
		this.width=width;
		if(height<=0.0)
			throw new IllegalArgumentException("Height too small");
		this.height=height;
		blickVektor = new Vector(viewPortCenter.getx()-camera.getx(), 
								 viewPortCenter.gety()-camera.gety(),
								 viewPortCenter.getz()-camera.getz());

		final Vector normVektor=new Vector(0, 1, 0);
        final Vector viewVector=viewPortCenter.substract(camera).pointToVector();
        this.rightVector = viewVector.crossProduct(normVektor).getNormalizedVector().multVec(width  / 2);
        this.upVector = rightVector.crossProduct(viewVector).getNormalizedVector().multVec(height / 2);
		//rightVector=new Vector((-1.0)*blickVektor.getz(),0,blickVektor.getx()).getNormalizedVector().multVec(width/2.0);
		//upVector=new Vector(0,(-1.0)*blickVektor.getz(),blickVektor.gety()).getNormalizedVector().multVec(height/2.0);
	}
	 /**
     * Primary Ray berechnen.
     *
     * @param horizontal double
     * @param vertical double
     * @return Ray.
     */
	public Ray getPrimaryRay(double horizontal, double vertical)
	{
		final Point startPoint = camera;
		final double vectorX=blickVektor.getx()+(rightVector.getx()*horizontal)+(upVector.getx()*vertical);
		final double vectorY=blickVektor.gety()+(rightVector.gety()*horizontal)+(upVector.gety()*vertical);
		final double vectorZ=blickVektor.getz()+(rightVector.getz()*horizontal)+(upVector.getz()*vertical);
		final Vector primaryVector=new Vector(vectorX,vectorY,vectorZ);
		return  new Ray(startPoint,primaryVector.getNormalizedVector());
	}
	public Point getCamera() 
	{
		return camera;
	}

	public Point getViewPortCenter() 
	{
		return viewPortCenter;
	}

	public Double getWidth() 
	{
		return width;
	}

	public Double getHeight() 
	{
		return height;
	}

	public Vector getBlickVektor() 
	{
		return blickVektor;
	}

	public Vector getRightVector() 
	{
		return rightVector;
	}

	public Vector getUpVector() 
	{

		return upVector;
	}
	@Override
	public String toString() 
	{
		return "Looker [camera=" + camera + ", viewPortCenter=" + viewPortCenter + ", width=" + width + ", height="
				+ height + ", blickVektor=" + blickVektor + ", rightVector=" + rightVector + ", upVector=" + upVector
				+ "]";
	}
	
}
