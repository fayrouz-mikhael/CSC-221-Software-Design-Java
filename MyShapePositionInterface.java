package application;

public interface MyShapePositionInterface  extends MyShapeInterface , MyPositionInterface {
	public int getBoundingBox();
    public boolean doOverlap();

}
