package application;

public interface MyPositionInterface {

	double[] getPoint();
	double[] moveTo(double deltaX , double deltaY);
	double distanceTo(double x2 , double y2);
}
