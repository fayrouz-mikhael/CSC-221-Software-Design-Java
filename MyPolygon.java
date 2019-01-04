package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape {
	private double sidelength; // the length of one side
	private double n; // number of the sides
   private MyPolygon p1;
		public MyPolygon(double sidelength, double n ,double x , double y , Color color) {
			super (x, y, color);
			this.n = n;
			this.sidelength = sidelength;
		}
		
		@Override
		public double getArea() {
			double x = 2* Math.tan(Math.toRadians(180/n));
			double perimeter = n*sidelength;
			double apothem = sidelength / x ;
			double area = (perimeter * apothem)/2 ;
			return area;
		}

		@Override
		public double getPerimeter() {
			return (n*sidelength );
		}

		
		//Get the Angle
		public double getAngle() {
			double s = n-2;
			return (s* 180);
		}
		//Get the side length
		public double getSide() {
			return sidelength;
		}
		//Get the radius
		public double getRadius() {
			return (getSide()/(2*Math.sin(Math.toRadians(180/n))));
		}
		
		public String toString() {
			return ("MYPOLYGON :: " + "side Length : " + getSide() + "  " + " perimeter : " + getPerimeter() + "  " + "Angle : " + getAngle() + "  " + "Area : " + getArea() + "  " + "super class : " + super.toString());
		}
		

		@Override
		public int getBoundingBox() {
			MyRectangle r = null;
			if ( r.getX() == getX() && r.getY()==getY())
				return 1;
			return 0;
		}

		@Override
		public boolean doOverlap() {
			MyRectangle r = null;
			MyOval o = null;
			MyLine l = null;
			MyPolygon p = null;
			if(this.p1.intersects(r) || this.p1.intersects(o) || this.p1.intersects(l) || this.p1.intersects(p) )
				return true;
			return false;
		}


		private boolean intersects(MyPolygon p) {
			this.setBounds(getX(), getY(), p.getSide(), p.getAngle());
			return false;
		}

		private void setBounds(double x, double y, double side, double angle) {
			
			x= getX();
			y = getY();
			side = p1.getSide();
			angle = p1.getAngle();
			
		}

		private boolean intersects(MyLine l) {
			this.setBounds(getX(), getX(), l.getX2(), l.getY2());
			return false;
		}

		private boolean intersects(MyOval o) {
			this.setBounds(getX(),getY(), o.getA(), o.getB());
			return false;
		}

		private boolean intersects(MyRectangle r) {
			this.setBounds(getX(), getX(), r.getLength(), r.getWidth());
			return false;
		}

		@Override
		public double[] getPoint() {
			double pointarr [] = new double [2];
			pointarr [0] = getX();
			pointarr [1] = getY();
			return pointarr;
			
		}

		@Override
		public double[] moveTo(double deltaX , double deltaY) {
			
			double movearr [] = new double [2];
			movearr [0] = getX()+ deltaX;
			movearr [1] = getY()+ deltaY;
			return movearr;
		}


		@Override
		public double distanceTo(double x2 , double y2) {
			double dis = Math.sqrt( (Math.pow( x2 - getX(), 2) ) + ( ( Math.pow( y2 - getY(), 2) )) );
			return dis;
		}
		
		
		
		public void drawPolygon(GraphicsContext gc) {
			double canvasWidth = gc.getCanvas().getWidth();
		      double canvasHeight = gc.getCanvas().getHeight();
		
		      
		 gc.setLineWidth(2); // The width of the polygon
	     gc.setFill(getColor()); // To Get the color of the polygon.
		
	    // It draws the polygon using the radius of the previous circle and the center of the circle to draw the polygon
	     
	     gc.fillPolygon(new double[]{canvasWidth/2 + getRadius()* Math.cos(Math.toRadians(55+0)) ,canvasWidth/2+ getRadius()* Math.cos(Math.toRadians(72+55)),canvasWidth/2 +getRadius()* Math.cos(Math.toRadians(144+55)),canvasWidth/2 +getRadius()* Math.cos(Math.toRadians(216+55)),canvasWidth/2 +getRadius()* Math.cos(Math.toRadians(288+55))},  
	     new double[]{canvasHeight/2 + getRadius()* Math.sin(Math.toRadians(0+55)),canvasHeight/2 +getRadius()* Math.sin(Math.toRadians(72+55)),canvasHeight/2 +getRadius()* Math.sin(Math.toRadians(144+55)),canvasHeight/2 +getRadius()* Math.sin(Math.toRadians(216+55)),canvasHeight/2 +getRadius()* Math.sin(Math.toRadians(288+55))}, 5);
		   
		}
}
