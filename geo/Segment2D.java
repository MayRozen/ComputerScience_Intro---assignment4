/*
 * ID: 212051007
 */
package Exe.Ex4.geo;


/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{

	private Point2D _p1;
	private Point2D _p2;
	
	public Segment2D (Point2D p1, Point2D p2) {
		_p1 = p1;
		_p2 = p2;
	}
	
	public Point2D getp1() {return this._p1;}
	public Point2D getp2() {return this._p2;}
	
	public String toString() {
		return "Segment2D:["+_p1+" , "+_p2+"]";
	}
	
	@Override
	public boolean contains(Point2D ot) { //Checking if the distance between the point from p1 plus the distance of the point from p2 is the all segment.
		double ans1, ans2, ansall;
		ansall = getp1().distance(getp2());
		ans1 = getp1().distance(ot);
		ans2 = ot.distance(getp2());
		
		if(ans1+ans2 == ansall) {
			return true;
		}
		return false;
	}

	@Override
	public double area() { //segment has not an area.
		return 0;
	}

	@Override
	public double perimeter() { //The perimeter is twice length of the segment.
		return 2*(getp1().distance(getp2()));
	}

	@Override
	public void move(Point2D vec) { //Change all points of the segment according to the vector.
		this._p1.move(vec);
		this._p2.move(vec);
	}

	@Override
	public GeoShapeable copy() { //Create a new segment with the points p1 and p2.
		return new Segment2D(getp1(), getp2());
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
		array[0]= getp1();
		array[1]= getp2();
		return array;
	}
	
}