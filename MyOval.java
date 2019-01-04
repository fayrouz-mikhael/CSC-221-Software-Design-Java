package application;

import javafx.scene.paint.Color;

public class MyOval extends MyShape  {

	 private double radius;
	 private double a ;
	 private double b ;
	 private MyOval o1;
	 
	public MyOval(double a ,  double b ,double radius , double x , double y  ,Color color) {
		super (x, y, color);
		this.radius = radius;
		this.a = a; 
		this.b = b; 
	}
	
	 public void setRadius(double r)
	  {  
	   this.radius = r; 
	  }
	 public void setA(double a)
	  {  
	   this.a = a; 
	  }
	 public void setB(double b)
	  {  
	   this.b = b; 
	  }
	 
	 public double getRadius() {
			return radius;

		}
	 public double getA() {
			return a;

		}
	 public double getB() {
			return b;
	 }
	 
	 
 @Override
public double[] getPoint() {
	 	double pointarr [] = new double [2];
	 	pointarr [0] = getX();
	 	pointarr [1] = getY();
	 	return pointarr;
	 	
	 }	 
	 
@Override
public int getBoundingBox() {
	int x = (int) (getA()/Math.sqrt(2));
	int y = (int) (getB()/Math.sqrt(2));
	setX(x);
	setY(y);
	return 0;
}

@Override
public boolean doOverlap() {
	MyRectangle r = null;
	MyOval o = null;
	MyLine l = null;
	MyPolygon p = null;
	if(this.o1.intersects(r) || this.o1.intersects(o) || this.o1.intersects(l) || this.o1.intersects(p) )
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

private boolean intersects(MyRectangle r) {
	this.setBounds(getX(), getX(), r.getLength(), r.getWidth());
	return false;
}

private void setBounds(double x, double y, double a, double b) {
	x= getX();
	y = getY();
	a = o1.getA();
	b = o1.getB();
	
}

@Override
public double getArea() {
	return Math.PI * a * b;
}

@Override
public double getPerimeter() {
	double p = 2 * Math.PI * Math.sqrt( (a*a + b*b) / 2);
	return p;
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
	return ("MYCICLE :: " + "Radius : " + getRadius() + "  " + "Perimeter : " + getPerimeter() + "  " + "Area : " + getArea() +"  "+ "super class : " + super.toString());
}

}



	