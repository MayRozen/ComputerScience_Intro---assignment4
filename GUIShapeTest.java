/*
 * ID: 212051007
 */
package Exe.Ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.GeoShapeable;

class GUIShapeTest {

	private GeoShapeable Rect2D;
	private GeoShapeable Circle2D;
	GeoShapeable gs = Rect2D;
	private GUIShape C = new GUIShape(gs, false, Color.PINK, 0); 
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetShape() {
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		assertEquals(s.getShape(), Rect2D);
	}
	
	@Test
	void testIsFilled() {
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		assertEquals(false, s.isFilled());
	}
	
	@Test
	void testSetFilled() {
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		s.setFilled(true); //Filled s.
		assertEquals(true, s.isFilled()); //Check if "setfilled" is work.
	}
	
	@Test
	void testisSelected(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		assertEquals(false, s.isSelected());
	}
	
	@Test
	void testSetAndGetColor(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		s.setColor(Color.BLACK);
		assertEquals(s.getColor(),Color.BLACK);
	}
	
	@Test
	void testGetTag(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 3);
		assertEquals(s.getTag(),3);
	}
	
	@Test
	void testSetTag(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		s.setTag(3);
		assertEquals(s.getTag(),3);
	}
	
	@Test
	void testCopy(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		GUI_Shapeable s2= s.copy();
		assertEquals(s2.getColor(),s.getColor());
		assertEquals(s2.getShape(),s.getShape());
	}

	@Test
	void testIsSelected(){
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		assertEquals(false, s.isSelected());
	}
	
	@Test
	void testSetSelected() {
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		s.setSelected(true); //Change s to be selected.
		assertEquals(true, s.isSelected());
	}
	
	@Test
	void testSetShape() {
		GUIShape s = new GUIShape(gs, false, Color.PINK, 0);
		GeoShapeable gs = Circle2D;
		s.setShape(gs);
		assertEquals(s.getShape(), Circle2D);
	}


}
