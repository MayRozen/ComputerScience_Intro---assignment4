/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShapeable{
	private Point2D _p1;
	private Point2D _p2;
	private Point2D _p3;
	
	public Triangle2D (Point2D p1, Point2D p2, Point2D p3) {
		_p1 = p1;
		_p2 = p2;
		_p3 = p3;
	}
	
	public Point2D getp1() {return this._p1;}
	public Point2D getp2() {return this._p2;}
	public Point2D getp3() {return this._p3;}
	
	public String toString() {
		return "Triangle2D:["+_p1+" , "+_p2+" , "+_p3+"]";
	}
	
	
	@Override
	public boolean contains(Point2D ot) {
		//We will check if "ot - point" create a three triangles which the sum of their areas equal to our big triangle's area.
		double sall = area();
		
		Triangle2D s12ot = new Triangle2D(getp1(),getp2(),ot);
		Triangle2D s23ot = new Triangle2D(getp2(),getp3(),ot);
		Triangle2D s31ot = new Triangle2D(getp3(),getp1(),ot);
		
		if((s12ot.area() + s23ot.area() + s31ot.area())==sall) {
			return true;
		}
		return false;
	}

	@Override
	public double area() { //Calculating the area of a triangle by three side - Heron's formula.
	//Triangle's area is 0.5*(side 1 + side 2 + side 3)
		double side12, side23, side31;
		side12 = getp1().distance(getp2());
		side23 = getp2().distance(getp3());
		side31 = getp3().distance(getp1());
		
		double halfprei = 0.5*(side12+side23+side31);
		double area = Math.sqrt(halfprei*(halfprei-side12)*(halfprei-side23)*(halfprei-side31));
		
		return area;				
	}
	
	@Override
	public double perimeter() { //The perimeter of the triangle is the sum of all its sides.
		double side12, side23, side31;
		side12 = getp1().distance(getp2());
		side23 = getp2().distance(getp3());
		side31 = getp3().distance(getp1());
		return side12+side23+side31;
	}

	@Override
	public void move(Point2D vec) { //Change all points of the triangle according to the vector.
		this._p1.move(vec);
		this._p2.move(vec);
		this._p3.move(vec);
	}

	@Override
	public GeoShapeable copy() { //Create a new Triangle with the points p1, p2 and p3.
		return new Triangle2D(getp1(), getp2(), getp3());
	}

	@Override
	public void scale(Point2D center, double ratio) {
		this._p1.scale(center, ratio);
		this._p2.scale(center, ratio);
		this._p3.scale(center, ratio);		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		this._p1.rotate(center, angleDegrees);
		this._p2.rotate(center, angleDegrees);
		this._p3.rotate(center, angleDegrees);	
		
	}

	@Override
	public Point2D[] getPoints() {
		Point2D [] array = new Point2D[3];
		array[0]= getp1();
		array[1]= getp2();
		array[2]= getp3();
		return array;
	}
	
}
