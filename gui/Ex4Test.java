/*
 * ID: 212051007
 */
package Exe.Ex4.gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.ShapeCollectionable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;

class Ex4Test {
	
	private  ShapeCollectionable _shapes = new ShapeCollection();
	Point2D p1=new Point2D(2,2);
	Point2D p2 = new Point2D(1, 2);
	Point2D p3 = new Point2D(3, 4);
	Point2D p4 = new Point2D(2, 4);
	Point2D p5 = new Point2D(-6, -8);
	Circle2D c1= new Circle2D(p1,1);
	Rect2D r1 = new Rect2D(p2, p3);
	Segment2D s1 = new Segment2D(p4, p5);
	Triangle2D t1 = new Triangle2D(p1, p3,p5);
	GUIShape _gcircle = new GUIShape(c1,true, Color.blue, 0);
	GUIShape _grect = new GUIShape(r1,true, Color.red, 1);
	GUIShape _gseg = new GUIShape(s1,false, Color.green, 2);
	GUIShape _gtri = new GUIShape(t1,false, Color.yellow, 3);
	private static Ex4 e = Ex4.getInstance();

	
		@Test
		void testAPAnti() { //Checking if the anti select does change the isSellected boolean.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			e.init(_shapes);
			e.getShape_Collection().get(0).setSelected(true);
			e.getShape_Collection().get(1).setSelected(false);
			e.actionPerformed("Anti");
			assertFalse(e.getShape_Collection().get(0).isSelected());
			assertTrue(e.getShape_Collection().get(1).isSelected());
		}
		
		@Test
		void testAPNone() { //Checking if the none select does change the isSellected boolean to false for each shape.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			e.init(_shapes);
			e.getShape_Collection().get(0).setSelected(true);
			e.getShape_Collection().get(1).setSelected(false);
			e.actionPerformed("None");
			assertFalse(e.getShape_Collection().get(0).isSelected());
			assertFalse(e.getShape_Collection().get(1).isSelected());
		}

		@Test
		void testAPAll() { //Checking if the all select does change the isSellected boolean to true for each shape.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			e.init(_shapes);
			e.getShape_Collection().get(0).setSelected(true);
			e.getShape_Collection().get(1).setSelected(false);
			e.actionPerformed("All");
			assertTrue(e.getShape_Collection().get(0).isSelected());
			assertTrue(e.getShape_Collection().get(1).isSelected());
		}

		@Test
		void testRotate() { //Checking if calling rotate in Ex4 does rotate the shape.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			_shapes.add(_gseg);
			_shapes.add(_gtri);
			e.init(_shapes);
			e.getShape_Collection().get(1).setSelected(true);
			e.rotate(p1,30);
			assertEquals( e.getShape_Collection().get(1).getShape().toString(),"Rect2D:[1.0,1.0 , 1.0,4.0]");
		}

		@Test
		void testScale() { //Checking if calling scale in Ex4 does scale the shape.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			_shapes.add(_gseg);
			_shapes.add(_gtri);
			e.init(_shapes);
			e.getShape_Collection().get(3).setSelected(true);
			e.scale(p1, 0.9);
			assertEquals(e.getShape_Collection().get(3).getShape().toString(),"Triangle2D:[2.0,2.0 , 2.9,3.8 , -5.2,-7.0]");
		}

		@Test
		void testRemove() { //Checking if remove in Ex4 does remove the shape.
			_shapes.add(_gcircle);
			_shapes.add(_grect);
			_shapes.add(_gseg);
			_shapes.add(_gtri);
			e.init(_shapes);
			e.getShape_Collection().get(2).setSelected(true);
			e.remove();
			boolean ans=true;
			for(int i=0;i<e.getShape_Collection().size();i++) {
				if(e.getShape_Collection().get(i).equals(_gseg)) {ans=false;}
			}
			assertTrue(ans);
		}
}
