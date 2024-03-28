/*
 * ID: 212051007
 */
package Exe.Ex4;
import java.awt.Color;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;
import Exe.Ex4.gui.Ex4;
/**
 * A very simple main class for basic code for Ex4
 * 
 * t2: output:
 * GUIShape,0,true,1,Circle2D,3.0,4.0, 2.0
 * GUIShape,255,false,2,Circle2D,6.0,8.0, 4.0
 * 
 * @author boaz.ben-moshe
 *
 */
public class Ex4Main {

	public static void main(String[] args) {
		// t1();
		t2();
		// t3(); // won't work "out of the box" - requires editing the code (save, load..)
	}
	// Minimal empty frame (no shapes)
	public static void t1() {
		Ex4 ex4 = Ex4.getInstance();
		ex4.show();
	} 
	// Two simple circles
	public static void t2() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		Point2D p1 = new Point2D(3,4);
		Point2D p2 = new Point2D(6,8);
		Point2D p3 = new Point2D (5,2);
		
		
		//-----------------Circle2D------------------
		Circle2D c1 = new Circle2D(p1,2);
		Circle2D c2 = new Circle2D(p2,4);
		GUI_Shapeable gs1 = new GUIShape(c1, true, Color.black, 1);
		GUI_Shapeable gs2 = new GUIShape(c2, false, Color.blue, 2);
		shapes.add(gs1);
		shapes.add(gs2);
		
		//-----------------Rect2D------------------
		Rect2D R1 = new Rect2D(p1,p2); //Create a new rectangle.
		GUI_Shapeable gs3 = new GUIShape(R1, true, Color.green, 3);
		shapes.add(gs3);
		
		//-----------------Segment2D------------------
		Segment2D S1 = new Segment2D(p1,p2); //Create a new segment.
		GUI_Shapeable gs4 = new GUIShape(S1, true, Color.yellow, 4);
		shapes.add(gs4);
		
		//-----------------Triangle2D------------------
		Triangle2D T1 = new Triangle2D(p1,p2,p3); //Create a new segment.
		GUI_Shapeable gs5 = new GUIShape(T1, true, Color.red, 5);
		shapes.add(gs5);
		
		//-----------------Polygon2D------------------
		Point2D p11 = new Point2D (4,4);
		Point2D p21 = new Point2D (7,9);
		Point2D p31 = new Point2D (1,9);
		Point2D p41 = new Point2D (8,2);
		
		Polygon2D P1 = new Polygon2D(); //Create a new polygon.
		P1.addPoint(p11);
		P1.addPoint(p21);
		P1.addPoint(p2);
		P1.addPoint(p31);
		P1.addPoint(p41);
		P1.addPoint(p1);
		
		GUI_Shapeable gs6 = new GUIShape(P1, true, Color.yellow, 6);
		shapes.add(gs6);
		
//-------------------------------------------
		//ex4.init(shapes);
		ex4.show();
		System.out.print(ex4.getInfo());
	}
	// Loads a file from file a0.txt (Circles only).
	public static void t3() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		String file = "a0.txt"; //make sure the file is your working directory.
		shapes.load(file);
		ex4.init(shapes);
		ex4.show();
	}

}
