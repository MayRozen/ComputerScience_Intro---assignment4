/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import java.util.Comparator;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUI_Shapeable;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shapeable>{
	
	public static final Comparator<GUI_Shapeable> CompByArea = new ShapeComp(Ex4_Const.Sort_By_Area);
	public static final Comparator<GUI_Shapeable> CompByAntiArea = new ShapeComp(Ex4_Const.Sort_By_Anti_Area);
	public static final Comparator<GUI_Shapeable> ByPerimeter = new ShapeComp(Ex4_Const.Sort_By_Perimeter);
	public static final Comparator<GUI_Shapeable> ByAntiPerimeter = new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter);
	public static final Comparator<GUI_Shapeable> CompByToString = new ShapeComp(Ex4_Const.Sort_By_toString);
	public static final Comparator<GUI_Shapeable> CompByAntiToString = new ShapeComp(Ex4_Const.Sort_By_Anti_toString);
	public static final Comparator<GUI_Shapeable> ByTag = new ShapeComp(Ex4_Const.Sort_By_Tag);
	public static final Comparator<GUI_Shapeable> ByAntiTag = new ShapeComp(Ex4_Const.Sort_By_Anti_Tag);
	
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
		
	}
	@Override
	public int compare(GUI_Shapeable o1, GUI_Shapeable o2) {
		int ans=0;
		//--------------------Area--------------------
		if(_flag == Ex4_Const.Sort_By_Area) {
			if(o1.getShape().area() == o2.getShape().area()) {
				ans = 0;
			}
			if(o1.getShape().area() < o2.getShape().area()) {
				ans = -1;
			}
			if(o1.getShape().area() > o2.getShape().area()) {
				ans = 1;
			}	
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			if(o1.getShape().area() == o2.getShape().area()) {
				ans = 0;
			}
			if(o1.getShape().area() < o2.getShape().area()) {
				ans = -1;
			}
			if(o1.getShape().area() > o2.getShape().area()) {
				ans = 1;
			}	
		}
		//--------------------Perimeter--------------------
		if(_flag == Ex4_Const.Sort_By_Perimeter) {
			if(o1.getShape().perimeter() == o2.getShape().perimeter()) {
				ans = 0;
			}
			if(o1.getShape().perimeter() < o2.getShape().perimeter()) {
				ans = -1;
			}
			if(o1.getShape().perimeter() > o2.getShape().perimeter()) {
				ans = 1;
			}	
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			if(o1.getShape().perimeter() == o2.getShape().perimeter()) {
				ans = 0;
			}
			if(o1.getShape().perimeter() < o2.getShape().perimeter()) {
				ans = -1;
			}
			if(o1.getShape().perimeter() > o2.getShape().perimeter()) {
				ans = 1;
			}	
		}
		//--------------------toString--------------------
		if(_flag == Ex4_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		if(_flag == Ex4_Const.Sort_By_Anti_toString) {
			ans = o2.toString().compareTo(o1.toString());
		}
		//--------------------Tag--------------------
		if(_flag == Ex4_Const.Sort_By_Tag) {
			if(o1.getTag() == o2.getTag()) {
				ans = 0;
			}
			if(o1.getTag() < o2.getTag()) {
				ans = -1;
			}
			if(o1.getTag() > o2.getTag()) {
				ans = 1;
			}	
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Tag) {
			if(o1.getTag() == o2.getTag()) {
				ans = 0;
			}
			if(o1.getTag() < o2.getTag()) {
				ans = -1;
			}
			if(o1.getTag() > o2.getTag()) {
				ans = 1;
			}	
		}
		
		return ans;
	}

}
