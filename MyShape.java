package application;

import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;

public  abstract class MyShape implements MyShapePositionInterface {
	private double x;
	private double y;
	private Color color;
	
	public MyShape(double x , double y , Color color) { 
		this.x=x;
		this.y = y;
		this.color = color;
	}
	public void setX(double x) { // set x
		this.x = x;
	}
	public void setY(double y) { // set y
		this.y = y;
		
	}
	public void setColor(Color color) { // set the color
	this.color = color;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public Color getColor() {
	return color;
	}

	public void shiftXY(double deltaX , double deltaY) { // move x and y
		setX(getX()+ deltaX);
		setY(getY()+ deltaY);
	}
	
	
	
	public String toString() {
	
	return ("MYSHAPE :: " + "x : " + getX() + "  " + "y : " + getY() + "  " + "color : " + getColor() );
	}
	
	public void drawShape(GraphicsContext gc) {	
		
		 gc.setFill(Color.WHITE); // it paints the canvas with white color.
		 
	}
}
