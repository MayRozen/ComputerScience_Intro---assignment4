/*
 * ID: 212051007
 */
package Exe.Ex4.gui;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.ShapeCollectionable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

/**
 * 
 * This class is a simple "inter-layer" connecting (aka simplifying) the
 * StdDraw with the Map class.
 * Written for 101 java course it uses simple static functions to allow a 
 * "Singleton-like" implementation.
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private  ShapeCollectionable _shapes = new ShapeCollection();
	private  GUI_Shapeable _gs;
	private  Color _color = Color.blue;
	private  boolean _fill = false;
	private  String _mode = "";
	private  Point2D _p1;
	private  Point2D _p2;
	private ArrayList<Point2D> _polyPoints = new ArrayList<>();
	private int _counter=0;
	
	private  static Ex4 _winEx4 = null;
	
	private Ex4() {
			init(null);
	}
	public void init(ShapeCollectionable s) {
		if(s==null) {_shapes = new ShapeCollection();}
		else {_shapes = s.copy();}
		GUI_Shapeable _gs = null;
		Polygon2D _pp = null;
		_color = Color.blue;
		_fill = false;
		_mode = "";
		Point2D _p1 = null;
	}
	public void show(double d) {
		StdDraw_Ex4.setScale(0,d);
		StdDraw_Ex4.show();
		drawShapes();
	}
	public static Ex4 getInstance() {
		if(_winEx4 ==null) {
			_winEx4 = new Ex4();
		}
		return _winEx4;
	}
	
	public void drawShapes() {
		StdDraw_Ex4.clear();
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable sh = _shapes.get(i);
				
				drawShape(sh);
			}
			if(_gs!=null) {drawShape(_gs);}
		StdDraw_Ex4.show();
	}
	private static void drawShape(GUI_Shapeable g) {
		StdDraw_Ex4.setPenColor(g.getColor());
		if(g.isSelected()) {StdDraw_Ex4.setPenColor(Color.gray);}
		GeoShapeable gs = g.getShape();
		boolean isFill = g.isFilled();
		
		//-----------------Circle2D------------------
		if(gs instanceof Circle2D) { //Create a new circle.
			Circle2D c = (Circle2D)gs;
			Point2D cen = c.getPoints()[0];
			double rad = c.getRadius();
			if(isFill) {
				StdDraw_Ex4.filledCircle(cen.x(), cen.y(), rad);
			}
			else { 
				StdDraw_Ex4.circle(cen.x(), cen.y(), rad);
			}
		}
		//-----------------Rect2D------------------
		if(gs instanceof Rect2D) { //Create a new rectangle.
			Rect2D R = (Rect2D)gs;
			Point2D []array = R.getPoints();
			Point2D p1 = array[0];
			Point2D p2 = array[1];
			
			double halfWidth = (p2.x()-p1.x())/2;
			double halfHeight = (p2.y()-p1.y())/2;
			double x = p1.x() + halfWidth;
			double y = p1.y() + halfHeight;
			
			if(isFill) {
				StdDraw_Ex4.filledRectangle(x, y, halfWidth, halfHeight);
			}
			else { 
				StdDraw_Ex4.rectangle(x, y, halfWidth, halfHeight);
			}
		}
		//-----------------Segment2D------------------
		if(gs instanceof Segment2D) { //Create a new segment. 
			Segment2D S1 = (Segment2D)gs;
			Point2D []array = S1.getPoints();
			Point2D p1 = array[0];
			Point2D p2 = array[1];
			double x0 = p1.x();
			double y0 = p1.y();
			double x1 = p2.x();
			double y1 = p2.y();
			
			StdDraw_Ex4.line(x0, y0, x1, y1);
		}
		//-----------------Triangle2D------------------
		if(gs instanceof Triangle2D) { //Create a new Triangle. 
			Triangle2D T1 = (Triangle2D)gs;
			Point2D []array = T1.getPoints();
			Point2D p1 = array[0];
			Point2D p2 = array[1];
			Point2D p3 = array[2];
			double x0 = p1.x();
			double y0 = p1.y();
			double x1 = p2.x();
			double y1 = p2.y();
			double x2 = p3.x();
			double y2 = p3.y();
			
			double [] arr1 = new double [3]; //Including all the x-s of the points.
			arr1[0] = x0;
			arr1[1] = x1;
			arr1[2] = x2;
					
			double [] arr2 = new double [3]; //Including all the y-s of the points.
			arr2[0] = y0;
			arr2[1] = y1;
			arr2[2] = y2;
			
			if(isFill) { //Draw the triangle by Polygon2D.
				StdDraw_Ex4.filledPolygon(arr1, arr2);
			}
			else { 
				StdDraw_Ex4.polygon(arr1, arr2);
			}
		}
		//-----------------Polygon2D------------------
		if(gs instanceof Polygon2D) { //Create a new polygon. 
			Polygon2D P1 = (Polygon2D)gs;
			double[] x = P1.getxs(); //array of the x-s of the polygon.
			double[] y = P1.getys(); //array of the y-s of the polygon.
			
			if(isFill) { //Draw the Polygon2D.
				StdDraw_Ex4.filledPolygon(x, y);
			}
			else { 
				StdDraw_Ex4.polygon(x, y);
			}
		}
		
		
	}
	private void setColor(Color c) {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			if(s.isSelected()) {
				s.setColor(c);
			}
		}
	}
	private void setFill() {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			if(s.isSelected()) {
				s.setFilled(_fill);
			}
		}
	}

	public void actionPerformed(String p) {
		_mode = p;
		if(p.equals("Blue")) {_color = Color.BLUE; setColor(_color);}
		if(p.equals("Red")) {_color = Color.RED; setColor(_color);}
		if(p.equals("Green")) {_color = Color.GREEN; setColor(_color);}
		if(p.equals("White")) {_color = Color.WHITE; setColor(_color);}
		if(p.equals("Black")) {_color = Color.BLACK; setColor(_color);}
		if(p.equals("Yellow")) {_color = Color.YELLOW; setColor(_color);}
		if(p.equals("Fill")) {_fill = true; setFill();}
		if(p.equals("Empty")) {_fill = false; setFill();}
		
		if(p.equals("Clear")) {_shapes.removeAll();}
		if(p.equals("Save")) {save();}
		if(p.equals("Load")) {load();}
		
		if(p.equals("None")) {
			for(int i=0; i<_shapes.size(); i++) {
				GUI_Shapeable s = _shapes.get(i);
				s.setSelected(false);
			}
		}
		if(p.equals("Info")) {System.out.println(this.getInfo());;}
		if(p.equals("All")) {setSelectedForShapes(true);}
		
		if(p.equals("Remove")) {remove();}

		drawShapes();
	}
	
	private void setSelectedForShapes(boolean selected) {
		for(int i=0; i<_shapes.size(); i++) {
			_shapes.get(i).setSelected(selected);
		}
	}

	
	public void mouseClicked(Point2D p) {
		System.out.println("Mode: "+_mode+"  "+p);
		//-----------------Circle2D------------------
		if(_mode.equals("Circle")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}
		}
		//-----------------Rect2D------------------
		if(_mode.equals("Rect")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}
		}
		//-----------------Segment2D------------------
		if(_mode.equals("Segment")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}
		}
		//-----------------Triangle2D------------------
		if(_mode.equals("Triangle")) {
			if(_gs==null) { 
				_p1 = new Point2D(p);
			}
			else {
				if(_p2==null) {
					_p2 = new Point2D(p);
				}
				else {
					_gs.setColor(_color);
					_gs.setFilled(_fill);
					_shapes.add(_gs);
					_gs = null;
					_p1 = null;
					_p2 = null;
				}
			}
		}
		//-----------------Polygon2D------------------
		//The termination conditions to drawing the polygon is in "mouseRightClicked" function.
		if(_mode.equals("Polygon")) {
			if(_gs==null) { 
				_polyPoints.add(p);	//Add p to the ArrayList.
				_p1 = new Point2D(p);
			}
			else {
				_polyPoints.add(p);
			}
		}
		
	   //------------------Move-----------------
	   //will move the drawing we selected according to the distance between the two points.
		if(_mode.equals("Move")) { 
			if(_p1==null) {_p1 = new Point2D(p);}
			else {
				_p1 = new Point2D(p.x()-_p1.x(), p.y()-_p1.y());
				move();
				_p1 = null;
			}
		}
		
	//-------------------Point---------------------
		if(_mode.equals("Point")) {
			select(p);
		}
	
	//------------------Copy----------------------
	if(_mode.equals("Copy")) { 
		if(_p1==null) {
			_p1 = new Point2D(p);
		}
		else {
			_p1 = new Point2D(p.x()-_p1.x(), p.y()-_p1.y());
			copy();
			_p1 = null;
		}
	}
	
	//---------------Scale-----------------
	if(_mode.equals("Scale_90%")) {scale(p,0.9);}
	if(_mode.equals("Scale_110%")) {scale(p,1.1);}
	
	//---------------Rotate-----------------
	if(_mode.equals("Rotate")) { 
		double move, rad, deg;
		if(_p1==null) {
			_p1 = new Point2D(p);
		}
		else {
			_p2 = new Point2D(p);
			double dx = _p2.x() - _p1.x();
			double dy = _p2.y() - _p1.y();
			if(_p2.x()<_p1.x()) {
				move = Math.PI;
			}
			else {
				move = 0;
			}
			rad = Math.atan(dy/dx)+move;
			deg = Math.toDegrees(rad);
			
			if(deg<0) {
				deg = deg +360;
			}
			this.rotate(_p1, deg);

			_p1 = null;
			_p2 = null;
		}
	}
	
	//---------------Anti-----------------
		if(_mode.equals("Anti")) { 
			for(int i=0; i<_shapes.size(); i++) {
				if(_shapes.get(i).isSelected()) {
					_shapes.get(i).setSelected(false);
				}
				else if(!_shapes.get(i).isSelected()){
					_shapes.get(i).setSelected(true);	
				}
			}	
		}
	
	
	//---------------Sort-----------------
		if(_mode.equals("ByArea")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Area));
		}
		if(_mode.equals("ByAntiArea")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Area));
		}
		if(_mode.equals("ByPerimeter")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Perimeter));
		}
		if(_mode.equals("ByAntiPerimeter")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter));
		}
		if(_mode.equals("ByToString")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_toString));
		}
		if(_mode.equals("ByAntiToString")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_toString));
		}
		if(_mode.equals("ByTag")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Tag));
		}
		if(_mode.equals("ByAntiTag")) { 
			_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Tag));
		}
		
	
	
	drawShapes();
}
	
	
	
	
	//--------------select----------------
	private void select(Point2D p) {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();			
			if(g!=null && g.contains(p)) {
				s.setSelected(!s.isSelected());
			}
		}
	}
	
	//----------------move---------------
	private void move() {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();
			if(s.isSelected() && g!=null) {
				g.move(_p1);
			}
		}
	}
	
	//------------------Copy----------------------
	//Copy the shape to more place.
	private void copy() {
		int originalSize = _shapes.size(); //Because the function changes the size on the fly.
		
		for(int i=0; i<originalSize; i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();
			if(s.isSelected() && g!=null) {
				GUI_Shapeable ns = s.copy();
				GeoShapeable ng = ns.getShape();
				ng.move(_p1);
				_shapes.add(ns);
			}
		}
	}
	
	//--------------remove----------------
	public void remove() {
		for(int i=0; i<_shapes.size(); i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();			
			if(s.isSelected() && g!=null) { //If this shape is chosen and it's not null.
				_shapes.removeElementAt(i); //Remove it.
			}
		}
	}
	//--------------rotate----------------
	public void rotate(Point2D cen, double ang) {
		for(int i=0; i<_shapes.size(); i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();			
			if(s.isSelected() && g!=null) { //If this shape is chosen and it's not null.
				g.rotate(cen, ang); //Do "rotate" on it.
			}
		}
	}
	//--------------scale----------------
	public void scale(Point2D p, double ratio) {
		for(int i=0; i<_shapes.size(); i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();			
			if(s.isSelected() && g!=null) { //If this shape is chosen and it's not null.
				g.scale(p, ratio);; //Do "scale" on it.
			}
		}
	}
	//--------------Save----------------
	private void save() {
		FileDialog file = new FileDialog(StdDraw_Ex4.getFrame(),"Save",1); //Create a new file.
		file.setVisible(true);
		if(file.getFile()!=null) {
			this._shapes.save(file.getDirectory()+File.separator+file.getFile()); //Save the directory of this file dialog.
		}
	}
	//--------------Load----------------
	private void load() {
		FileDialog file = new FileDialog(StdDraw_Ex4.getFrame(),"Load",0); 
		file.setVisible(true);
		if(file.getFile()!=null) {
			this._shapes.load(file.getDirectory()+File.separator+file.getFile());
		}
	}
	
	
	public void mouseRightClicked(Point2D p) {
		System.out.println("right click!");
		
		//---------------Polygon2D-----------------
		//Termination conditions to drawing the polygon.
		if(_mode.equals("Polygon") && _p1!=null) {
			Polygon2D poly = new Polygon2D(_polyPoints);
			
			_gs = new GUIShape(poly,_fill, _color, 0);
			_shapes.add(_gs);
			_gs = null;
			_p1 = null;	
			_polyPoints.clear(); //Rest _polyPoints.
			
			drawShapes(); //Paint the polygon by right click.
		}
	
	}
	
	
	
	
	
	
	
	public void mouseMoved(MouseEvent e) {
		if(_p1!=null) {
			double x1 = StdDraw_Ex4.mouseX();
			double y1 = StdDraw_Ex4.mouseY();
			GeoShapeable gs = null;
		//	System.out.println("M: "+x1+","+y1);
			Point2D p = new Point2D(x1,y1);
			
			//-----------------Circle2D------------------
			if(_mode.equals("Circle")) {
				double r = _p1.distance(p);
				gs = new Circle2D(_p1,r);
			}
			
			//-----------------Rect2D------------------
			if(_mode.equals("Rect")) {
				gs = new Rect2D(_p1,p);
			}
			
			//-----------------Segment2D------------------
			if(_mode.equals("Segment")) {
				gs = new Segment2D(_p1,p);
			}
			//-----------------Triangle2D------------------
			if(_mode.equals("Triangle")) {
				if(_p2==null) { //If it has only 2 points, draw a segment between it.
					gs = new Triangle2D(_p1,p, p);
				}
				else { //If it has 3 points, draw a triangle.
					gs = new Triangle2D(_p1, p, _p2);
				}
			}
			//-----------------Polygon2D------------------
			if(_mode.equals("Polygon")) {
				Polygon2D poly = new Polygon2D(_polyPoints); //Create a new polygon by _polyPoints.
				poly.addPoint(p); //Add p to the arraylist. 
				gs = poly;
			}
			
			_gs = new GUIShape(gs,false, Color.pink, _counter);
			_counter++;
			drawShapes();
		}

	}
	@Override
	public ShapeCollectionable getShape_Collection() {
		// TODO Auto-generated method stub
		return this._shapes;
	}
	@Override
	public void show() {show(Ex4_Const.DIM_SIZE); }
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String ans = "";
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			ans +=s.toString()+"\n";
		}
		return ans;
	}
}
