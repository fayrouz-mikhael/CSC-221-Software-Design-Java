package application;

import javafx.scene.canvas.GraphicsContext;

//import javafx.scene.shape.MyShape;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {


	private double x2;
	
	private double y2;
	private MyLine l1;
	
	public MyLine( double x2 , double y2 , double x , double y , Color color) {
		super (x, y, color);
		this.x2 = x2;
		this.y2 = y2;
		
	}
	// Get the lenght of the line
	public double getLenght() {
		return Math.sqrt( (Math.pow((x2-getX()), 2)) + (Math.pow((y2-getY()), 2)) );
	}
	
	// Get the x-axis angle of the line
	public double get_xAngle() {
		double xDiff = x2-getX();
		double yDiff = y2-getY();
		double slop = yDiff/xDiff;
		
		return Math.toDegrees(Math.atan(slop));
	}
	public double getX2() {
		return x2;
	}
	public double getY2() {
		return y2;
	}
	
	
	public String toString() {
		return ("MYLine :: " + "Length : " + getLenght() + "  " + "Angle : " + get_xAngle() + "  " + "Super : " + super.toString() );
			}
	
	@Override
	public int getBoundingBox() {
		MyRectangle r = null;
		if(getX() >= r.getX() && getY() >=r.getY() ||getX2() <= r.getX() && getY2() <=r.getY() )
			return 1;
		return 0;
	}
	@Override
	public boolean doOverlap() {
		MyRectangle r = null;
		MyOval o = null;
		MyLine l = null;
		MyPolygon p = null;
		if(this.l1.intersects(r) || this.l1.intersects(o) || this.l1.intersects(l) || this.l1.intersects(p) )
			return true;
		

		return false;
	}
	private boolean intersects(MyLine l) {
		this.setBounds(getX(), getX(), l.getX2(), l.getY2());
		return false;
	}
	private boolean intersects(MyPolygon p) {
		this.setBounds(getX(), getY(), p.getSide(), p.getAngle());
		return false;
	}
	private boolean intersects(MyRectangle r) {
		this.setBounds(getX(), getX(), r.getLength(), r.getWidth());
		return false;
	}
	private boolean intersects(MyOval o) {
		this.setBounds(getX(),getY(), o.getA(), o.getB());
		return false;
	}
	
	
	private void setBounds(double x, double y, double x2, double y2) {
		x= getX();
		y = getY();
		x2 = l1.getX2();
		y2 = l1.getY2();
		
	}
	
	@Override
	public double getArea() {
		return 1;
	}
	@Override
	public double getPerimeter() {
		return 0;
	}
	@Override
	public double[] getPoint() {
		double pointarr [] = new double [2];
	 	pointarr [0] = getX();
	 	pointarr [1] = getY();
	 	return pointarr;
	}
	@Override
	public double[] moveTo(double deltaX, double deltaY) {
		double movearr [] = new double [2];
		movearr [0] = getX()+ deltaX;
		movearr [1] = getY()+ deltaY;
		return movearr;
	}
	@Override
	public double distanceTo(double x2, double y2) {
		double dis = Math.sqrt( (Math.pow( x2 - getX(), 2) ) + ( ( Math.pow( y2 - getY(), 2) )) );
		return dis;
	}
    
 


	public void drawLines(GraphicsContext gc) { 
		
	// Draw the line using the canvas width and the canvas height
	
	double canvasWidth = gc.getCanvas().getWidth();
    double canvasHeight = gc.getCanvas().getHeight();
    
   
    gc.setLineWidth(2);
    gc.strokeLine(0, 0, canvasWidth, canvasHeight);
    gc.setLineWidth(5);
    gc.strokeLine(0, 0, canvasWidth, 0);
    gc.strokeLine(0, 0, 0, canvasHeight);
    gc.strokeLine(canvasWidth,0, canvasWidth,canvasHeight);
    gc.strokeLine(0,canvasHeight,canvasWidth,canvasHeight);

    }
	
}
