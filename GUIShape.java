/*
 * ID: 212051007
 */
package Exe.Ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;


public class GUIShape implements GUI_Shapeable{
	private GeoShapeable _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected = false;
	
	public GUIShape(GeoShapeable g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	
	public GUIShape(String file) { //Convert from string to shape.
		this._g=null;
		String[] splitFile = file.split(",");
		this._color = new Color(Integer.parseInt(splitFile[1]));
		this._fill = Boolean.parseBoolean(splitFile[2]);
		this._tag = Integer.parseInt(splitFile[3]);
		this.init(splitFile);
	}
	public void init(String[] s) {
		if(s[4].equals("Rect2D")) {
			Point2D p1 = new Point2D(s[5]+","+s[6]);
			Point2D p2 = new Point2D(s[9]+","+s[10]);
			
			this._g = new Rect2D(p1,p2);
		}
		if(s[4].equals("Circle2D")){
			this._g = new Circle2D(new Point2D(s[5]+","+s[6]),Double.parseDouble(s[7]));
		}
		if(s[4].equals("Triangle2D")) {
			Point2D p1 = new Point2D(s[5]+","+s[6]);
			Point2D p2 = new Point2D(s[7]+","+s[8]);
			Point2D p3 = new Point2D(s[9]+","+s[10]);
			
			this._g = new Triangle2D(p1,p2,p3);
		}
		if(s[4].equals("Segment2D")) {
			Point2D p1 = new Point2D(s[5]+","+s[6]);
			Point2D p2 = new Point2D(s[7]+","+s[8]);
			
			this._g = new Segment2D(p1,p2);
		}
		if(s[4].equals("Polygon2D")) {
			Polygon2D temp = new Polygon2D();
			for(int i=5; i<s.length; i=i+2) {
				temp.addPoint(new Point2D(s[i]+","+s[i+1]));;
			}
			this._g = temp;
		}	
	}
	
	@Override
	public GeoShapeable getShape() {
		return _g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shapeable copy() {
		GUI_Shapeable cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	@Override
	public void setShape(GeoShapeable g) {
		this._g = g;
		
	}
}
