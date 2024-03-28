/*
 * ID: 212051007
 */
package Exe.Ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

class ShapeCollectionTest {
	
		ShapeCollection shapes = new ShapeCollection();
		Point2D p1 = new Point2D(8,8);
		Point2D p2 = new Point2D(6,2);
		Point2D p3 = new Point2D(8,10);
		
		Circle2D C = new Circle2D(p1, 2);
		GUIShape GC = new GUIShape (C, true, Color.blue,0);
		Rect2D R = new Rect2D(p1,p2);
		GUIShape GR = new GUIShape (R, true, Color.yellow,1);
		Triangle2D T = new Triangle2D(p1,p2,p3);
		GUIShape GT = new GUIShape (T, true, Color.green,2);
		
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() { //Check if get(2) will give us T.
		shapes.add(GC);
		shapes.add(GR);
		shapes.add(GT);

		//We use toString due to we want to check the values and not the value in the computer's memory.
		assertEquals(shapes.get(2).toString(), GT.toString()); 
	}
	
	@Test
	void testSize() { //Check if we get 3.
		shapes.add(GC);
		shapes.add(GR);
		shapes.add(GT);
		assertEquals(3, shapes.size()); 
	}
	
	@Test
	void testRemoveElementAt() { //Check if we get R.
		shapes.add(GC);
		shapes.add(GR);
		shapes.add(GT);

		shapes.removeElementAt(1); //Remove GR.
		
		assertTrue(shapes.get(1).equals(GT)); //Now we have in index 1 - GT.
	}
	
	@Test
	void testAddAt() { //Check if we get GR at index 1.
		shapes.add(GC); //Index 0.
		shapes.add(GT); //Index 1.
		//We want to in for index 1 - GR.
		
		
		shapes.addAt(GR,1);
		assertTrue(shapes.get(1).equals(GR)); 
	}
	
	@Test
	void testAdd() { //Check if we get GT at index 2.
		shapes.add(GC);
		shapes.add(GR);
		
		
		shapes.add(GT);
		assertTrue(shapes.get(2).equals(GT)); 
	}
	
	@Test
	void testCopy() { //Check if we get all the shapes from "shapes" to SH.
		shapes.add(GC);
		shapes.add(GR);
		shapes.add(GT);
		
		ShapeCollectionable SH = new ShapeCollection();
		SH.add(GC);
		SH.add(GR);
		SH.add(GT);
		
		ShapeCollectionable scheck = shapes.copy();
		
		
		assertTrue(scheck.toString().equals(SH.toString())); 
	}
	
	@Test
	void testSort() { //Check if we get all the shapes from "shapes" to SH.
		shapes.add(GC); //area = 3.14.
		shapes.add(GR); //area = 8.
		shapes.sort(ShapeComp.CompByArea);
		
		assertEquals(shapes.get(0).toString(), GC.toString()); 
		assertEquals(shapes.get(1).toString(), GR.toString());
	}
	
	@Test
	void testRemoveAll() { //Check if shapes equals to its first value after we are remove all its values.
		ShapeCollectionable SH = shapes;
		
		shapes.add(GC);
		shapes.add(GR);
		shapes.add(GT);
		shapes.removeAll();
		
		assertEquals(shapes.toString(), SH.toString()); 
	}
	
	@Test
	void testSavaAndLoad() { 
		shapes.save("C:\\Users\\mayro\\Desktop");
		ShapeCollectionable _shapes2 = new ShapeCollection();
		for(int i=0; i<shapes.size(); i++) {
			assertEquals(_shapes2.get(i).toString(), shapes.get(i).toString());
		}
	}
	
	@Test
	void testGetBoundingBox() { //Check if we get the rectangle which clock all the shapes from "shapes".
		shapes.add(GR); //Rect.
		shapes.add(GT); // Triangle.
		
		Point2D pmin = new Point2D(6,2);
		Point2D pmax = new Point2D(8,10);
//		Rect2D R = new Rect2D (pmin,pmax);
		
		Rect2D RCHECK = shapes.getBoundingBox();
		System.out.println(RCHECK.getpmin());
		
		Point2D [] ar = RCHECK.getPoints();
		assertEquals(ar[0].x(),pmin.x()); //pmin.
		assertEquals(ar[0].y(),pmin.y()); //pmin.
		assertEquals(ar[1].x(),pmax.x()); //pmax.
		assertEquals(ar[1].y(),pmax.y()); //pmax.
	}
	
	
}
