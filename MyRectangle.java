package application;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;


public class MyRectangle extends MyShape {
	private double width; // the length of width
	private double lenght; // 
	private MyRectangle r1;

		public MyRectangle(double width, double lenght ,double x , double y , Color color) {
			super (x, y, color);
			this.width = width;
			this.lenght = lenght ;
		}
		public double getWidth() {
			return width;

		}
		public double getLength() {
			return lenght;

		}

		@Override
		public int getBoundingBox() {
			return 0;
		}

		@Override
		public boolean doOverlap() {
			MyRectangle r = null;
			MyOval o = null;
			MyLine l = null;
			MyPolygon p = null;
			if(this.r1.intersects(r) || this.r1.intersects(o) || this.r1.intersects(l) || this.r1.intersects(p) )
				return true;
			

			return false;
		}

		private boolean intersects(MyPolygon p) {
			this.setBounds(getX(), getY(), p.getSide(), p.getAngle());
			return false;
		}
		private boolean intersects(MyLine l) {
			this.setBounds(getX(), getX(), l.getX2(), l.getY2());
			return false;
		}
		private boolean intersects(MyOval o) {
			this.setBounds(getX(),getY(), o.getA(), o.getB());
			return false;
		}
		private void setBounds(double x, double y, double width2, double lenght2) {
			x= getX();
			y = getY();
			width2 = r1.lenght;
			lenght2 = r1.width;
			
		}
		private boolean intersects(MyRectangle r) {
			this.r1.setBounds(getX(),getY(),r1.width , r1.lenght);
			return true;
		}
		@Override
		public double getArea() {
			return lenght * width;
		}

		@Override
		public double getPerimeter() {
			return 2 * (lenght + width);
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
		
		public String toString() {
			return ("MYRectangle :: " + "Length :  " + getLength() + " " +"Width : " + getWidth() + "  " + "Perimeter : " + getPerimeter() + "  " + "Area : " + getArea() +"  "+ "super class : " + super.toString());
		}
		
		
		public void drawRectangle(GraphicsContext gc) {
			double canvasWidth = gc.getCanvas().getWidth();
		      double canvasHeight = gc.getCanvas().getHeight();
		      
		       gc.setLineWidth(2); 
		       gc.setFill(getColor());
		       
		       gc.fillRect(getX()+canvasWidth/4, getY()+canvasHeight/4, width*4, lenght);
		       
		       
		}
		
}
