/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {

	private Point2D _p1;
	private Point2D _p2;
	
	public Rect2D (Point2D p1, Point2D p2) {
		_p1 = p1;
		_p2 = p2;
	}
	public Point2D getpmin() {
		int x1 = this._p1.ix(), x2 = this._p2.ix();
		int y1 = this._p1.iy(), y2 = this._p2.iy();
		int xmin = Math.min(x1, x2);
		int ymin = Math.min(y1, y2);
		Point2D pmin = new Point2D (xmin,ymin);
		return pmin;}
	
	public Point2D getpmax() {
		int x1 = this._p1.ix(), x2 = this._p2.ix();
		int y1 = this._p1.iy(), y2 = this._p2.iy();
		int xmax = Math.max(x1, x2);
		int ymax = Math.max(y1, y2);
		Point2D pmax = new Point2D (xmax,ymax);
		return pmax;}
	
	public String toString() {
		return "Rect2D:["+getpmin()+" , "+getpmax()+"]";
	}

	@Override
	public boolean contains(Point2D ot) { //Checking if the point is in the rectangle.
		double xot = ot.ix();
		double yot = ot.iy();
		if((xot>getpmin().ix() && xot<getpmax().ix() ) && (yot>getpmin().iy() && yot<getpmax().iy())){
			return true;
		}
		return false;
	}

	@Override
	public double area() { //Calculates the area of the rectangle.
		double length = getpmax().ix() - getpmin().ix();
		double width = getpmax().iy() - getpmin().iy();
		double ans = length * width;
		if (ans != 0) {
			return ans;
		}
		return 0;
	}

	@Override
	public double perimeter() { //Calculate the perimeter.
		double length = getpmax().ix() - getpmin().ix();
		double width = getpmax().iy() - getpmin().iy();
		double ans = 2*length + 2*width;
		if (ans != 0) {
			return ans;
		}
		return 0;
	}

	@Override
	public void move(Point2D vec) { //Change all points of the rectangle according to the vector.
		this._p1.move(vec);
		this._p2.move(vec);
	}

	@Override
	public GeoShapeable copy() { //Create a new rectangle with the points p1 and p2.
		return new Rect2D(getpmin(), getpmax());
	}

	@Override
	public void scale(Point2D center, double ratio) {
		this._p1.scale(center, ratio);
		this._p2.scale(center, ratio);
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		this._p1.rotate(center, angleDegrees);
		this._p2.rotate(center, angleDegrees);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D [] array = new Point2D[2];
		array[0] = getpmin();
		array[1] = getpmax();
		return array;
	}

}
