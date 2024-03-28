/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import java.util.ArrayList;

/**
 * This class represents a 2D polygon, as in https://en.wikipedia.org/wiki/Polygon
 * This polygon can be assumed to be simple in terms of area and contains.
 * 
 * You should update this class!
 * @author boaz.benmoshe
 *
 */
public class Polygon2D implements GeoShapeable{
	
	private ArrayList<Point2D> _points;
	
	public Polygon2D () {
		_points = new ArrayList<>();
	}
	
	public void addPoint(Point2D p) {
		_points.add(new Point2D(p));
	}
	
	public double[] getxs() { //x-s array.
		double [] ans = new double[_points.size()];
		for(int i=0; i<_points.size(); i++) {
			ans[i] = _points.get(i).x();
		}
		return ans;
	}
	
	public double[] getys() { //y-s array.
		double [] ans = new double[_points.size()];
		for(int i=0; i<_points.size(); i++) {
			ans[i] = _points.get(i).y();
		}
		return ans;
	}
	
	public String toString() {
		String pst = " ";
//		Point2D [] poly = getPoints();
		for(int i=0; i<_points.size(); i++) {
			if(i==0) {
				pst = _points.get(i).toString(); //For do not print " , " at the beginning. Print it only between two string-s.
			}
			else {
				pst = pst +" , " + _points.get(i).toString();
			}
		}
	    return "Polygon2D:["+pst+"]";
	}
	
	//copy constructor
	@SuppressWarnings("unchecked")
	public Polygon2D(ArrayList<Point2D> points) {
		_points = (ArrayList<Point2D>)points.clone();
	}
	
	@Override
	public boolean contains(Point2D ot) {
		int x = ot.ix();
		int y = ot.iy();
		
		var in = false; //If the point is in. First, define it as "false".
		
		for(int i=0 , j=_points.size()-1; i<_points.size(); j=i++) {
			var xi = _points.get(i).ix();
			var yi = _points.get(i).iy();
			var xj = _points.get(j).ix();
			var yj = _points.get(j).iy();
			
			//According to the formula, whether a point is inside a polygon depends on the number of times its ray crosses the polygon.
			boolean check = ((yi>y) != (yj>y)) && (x < (xj-xi)*(y-yi) /(yj-yi) + xi); 
			
			if(check) { //If check==true;
				in = !in;
			}
		}
		return in;
	}

	@Override
	public double area() {
		double [] x = getxs();
		double [] y = getys();
		double sum1 = 0, sum2 = 0;
		double ans;
		
		//According to the polygon area calculation formula.
		for(int i=0; i<x.length-1; i++) { 
			sum1 = sum1 + x[i]*y[i+1];
			sum2 = sum2 +  y[i]*x[i+1];
		}
		sum1 = sum1 + x[x.length-1]*y[0];
		sum2 = sum2 +  y[x.length-1]*x[0];
		
		ans = 0.5 * (sum1 - sum2);  
		return ans;
	}

	@Override
	public double perimeter() { //According a formula for polygon's perimeter.
		double peri = 0;
		for(int i=0; i<_points.size(); i++) { //Running all the points of the polygon.
			Point2D p1 = _points.get(i);
			Point2D p2 = _points.get((i+1)%_points.size());
			peri = peri + Math.sqrt(Math.pow(p2.x()-p1.x(), 2)+Math.pow(p2.y()-p1.y(), 2));
		}
		return peri;
	}

	@Override
	public void move(Point2D vec) { //Change all the points which created the polygon by move().
		for(int i=0; i<_points.size(); i++) {
			_points.get(i).move(vec);
		}
		
		
	}

	@Override
	public GeoShapeable copy() { //Create a new Polygon with the polygon's points.
		Polygon2D poly = new Polygon2D(_points);
		return poly;
	}

	@Override
	public void scale(Point2D center, double ratio) {
		Point2D [] points = getPoints(); //All the points of the polygon.
		for(int i=0; i<points.length; i++) { //Run over all the points of the polygon and "do" scale on them.
			points[i].scale(center, ratio);
		}
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		Point2D [] points = getPoints(); //All the points of the polygon.
		for(int i=0; i<points.length; i++) { //Run over all the points of the polygon and "do" rotate on them.
			points[i].rotate(center, angleDegrees);
		}
		
	}

	@Override
	public Point2D[] getPoints() { //Convert the arraylist to a Point2D-array.
		Point2D [] ans = new Point2D[_points.size()];
		for(int i=0; i<_points.size(); i++) {
			ans[i] = _points.get(i);
		}
		return ans;
	}
	
}
