package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Geometric_Figure_2 {
	
	public static void drawShape2(GraphicsContext gc) {
		
		double canvasWidth = gc.getCanvas().getWidth();
	    double canvasHeight = gc.getCanvas().getHeight();
	    double both = canvasWidth + canvasHeight ;
	    
	  MyRectangle r1 = new MyRectangle (canvasWidth/8 ,canvasHeight/2 ,0,0,Color.BURLYWOOD);
		   r1.setColor(Color.BURLYWOOD);      
	      r1.drawRectangle(gc);
	     
	      
	      MyCircle c1 = new MyCircle(r1.getLength() , r1.getWidth() ,r1.getWidth() ,0,0,Color.GREENYELLOW);
	      c1.setColor(Color.GREENYELLOW);      
	      c1.drawCircle(gc);
	      
	     double x1 = c1.getA()/Math.sqrt(2);
	     double y1 = c1.getB()/Math.sqrt(2);
	      
	    
	     
	      MyRectangle r2 = new MyRectangle (c1.getB()/1.4, c1.getA()/1.4 , x1/2.5,y1/2.5, Color.BROWN);
		  r2.setColor(Color.BROWN);      
	      r2.drawRectangle(gc);
	      
	      MyCircle c2 = new MyCircle(r2.getLength() , r2.getWidth() ,r2.getWidth() ,-r2.getX(),r2.getY(),Color.SKYBLUE);
	      c2.setColor(Color.SKYBLUE);      
	      c2.drawCircle(gc);
	      
	    
	      double x2 = c2.getA()/Math.sqrt(2);
		  double y2 = c2.getB()/Math.sqrt(2);
	      MyRectangle r3 = new MyRectangle (c2.getB()/1.4, c2.getA()/1.4 , x2,y2, Color.ORANGE);
		  r3.setColor(Color.ORANGE);      
	      r3.drawRectangle(gc);
	      
	      MyCircle c3 = new MyCircle(r3.getLength() , r3.getWidth() ,r3.getWidth() ,-r3.getX(),r3.getY(),Color.LAVENDER);
	      c3.setColor(Color.LAVENDER);      
	      c3.drawCircle(gc);
	      
	      
	   // Draw  a black line 
	       
	        MyLine line = new MyLine(canvasWidth,canvasHeight,0.0,0.0, Color.BLACK);
	        line.drawLines(gc);
	      
	   
		
	}

}
