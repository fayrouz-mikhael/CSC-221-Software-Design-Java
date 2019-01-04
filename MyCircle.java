package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle  extends MyOval {
	
	 
	 public MyCircle( double a ,  double b , double radius , double x , double y  ,Color color) {
			super (a, b, radius, -x, y, color);
		
		}
	
	  public void drawCircle(GraphicsContext gc) {
		  gc.setLineWidth(2); // The width of the circle
	      gc.setFill(getColor()); // To Get the color of the circle.
	       
		      gc.fillOval( (getX()+250), (getY()+125), getA()*2, getB()*2);
		 
	  }

}
