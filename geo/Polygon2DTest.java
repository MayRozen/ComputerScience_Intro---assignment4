/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Polygon2DTest {
	private ArrayList<Point2D> polypoints(){ //Create a Test - Polygon which help us to check the polygon's functions.
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(8,2);
		Point2D p3 = new Point2D(8,10);
		Point2D p4 = new Point2D(6,10);
		Point2D p5= new Point2D(3,16);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		
		return points;
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void testToString() { //Check if we get the Polygon's points.
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(8,2);
		Point2D p3 = new Point2D(8,10);
		Point2D p4 = new Point2D(6,10);
		Point2D p5= new Point2D(3,16);
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.

		//The string we need to get.
		String Scheck = "Polygon2D:["+p1.toString()+" , "+p2.toString()+" , "+p3.toString()+" , "+p4.toString()+" , "+p5.toString()+"]"; 
		
		assertEquals(po.toString(), Scheck);	
	}

	
	@Test
	void testContains() { //Check if pcheck is in the polygon.
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		Point2D pcheck = new Point2D(5,5);
		
		assertEquals(true, po.contains(pcheck));	
	}
	
	@Test
	void testArea() { //Check if S's area is 63 (According to the formula of polygon's area.
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		assertEquals(63, po.area());	
	}
	
	@Test
	void testPerimeter() { //Check if S's perimeter is the sum of all the points' distances.
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		double poperi = po.perimeter();	
		System.out.println( po.perimeter());
	
		assertEquals(37.850339556230324,poperi);	
	}
	
	@Test
	void testMove() { 
		double count = 0;
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
//		Point2D p1 = new Point2D(1,2);
//		Point2D p2 = new Point2D(8,2);
//		Point2D p3 = new Point2D(8,10);
//		Point2D p4 = new Point2D(6,10);
//		Point2D p5= new Point2D(3,16);
		
		Point2D[]array = po.getPoints();
		Point2D vec = new Point2D(1,1);
		po.move(vec);
		
		if(array[0].equals(new Point2D (2,3))) {
			count++;
		}
		if(array[1].equals(new Point2D (9,3))) {
			count++;
		}
		if(array[2].equals(new Point2D (9,11))) {
			count++;
		}
		if(array[3].equals(new Point2D (7,11))) {
			count++;
		}
		if(array[4].equals(new Point2D (4,17))) {
			count++;
		}
		
		
		assertEquals(5, count);	
	}
	
	@Test
	void testcopy() { 
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		Polygon2D po1 = new Polygon2D(polypoints()); //Create more polygon.
		
		Point2D[] arry= po.copy().getPoints();
		Point2D[] arry1=po1.getPoints();
		assertEquals(arry[0],arry1[0]);
		assertEquals(arry[1],arry1[1]);
	}
	
	@Test
	void tesScale1() {  
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		Point2D cen2= new Point2D(0,0);
		po.scale(cen2, 0.9); //Scale 90 %
		

		ArrayList<Point2D> points1 = new ArrayList<Point2D>();
		Point2D p1 = new Point2D(0.9,1.8);
		Point2D p2 = new Point2D(7.2,1.8);
		Point2D p3 = new Point2D(7.2,9);
		Point2D p4 = new Point2D(5.4,9);
		Point2D p5= new Point2D(2.7,14.4);
		points1.add(p1);
		points1.add(p2);
		points1.add(p3);
		points1.add(p4);
		points1.add(p5);
		Polygon2D po1 = new Polygon2D(points1);
		
		
		Point2D[] arry= po.getPoints();
		Point2D[] arry1= po1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
		assertEquals(arry[2], arry1[2]);
		assertEquals(arry[3], arry1[3]);
		assertEquals(arry[4], arry1[4]);
	}
		
	@Test
	void tesScale2() { 
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		Point2D cen2= new Point2D(0,0);
		po.scale(cen2, 1.1); //Scale 110 %
		

		ArrayList<Point2D> points1 = new ArrayList<Point2D>();
		Point2D p1 = new Point2D(1.1,2.2);
		Point2D p2 = new Point2D(8.8,2.2);
		Point2D p3 = new Point2D(8.8,11);
		Point2D p4 = new Point2D(6.6000000000000005,11);
		Point2D p5= new Point2D(3.3000000000000003,17.6);
		points1.add(p1);
		points1.add(p2);
		points1.add(p3);
		points1.add(p4);
		points1.add(p5);
		Polygon2D po1 = new Polygon2D(points1);
		
		
		Point2D[] arry= po.getPoints();
		Point2D[] arry1= po1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
		assertEquals(arry[2], arry1[2]);
		assertEquals(arry[3], arry1[3]);
		assertEquals(arry[4], arry1[4]);
	}
	
	@Test
	void tesRotate() { 
		ArrayList<Point2D> points1 = new ArrayList<Point2D>();
		Point2D p1 = new Point2D(14,13);
		Point2D p2 = new Point2D(12,12);
		Point2D p3 = new Point2D(15,19);
		Point2D p4 = new Point2D(18,14);
		Point2D p5= new Point2D(16,20);
		points1.add(p1);
		points1.add(p2);
		points1.add(p3);
		points1.add(p4);
		points1.add(p5);
		Polygon2D po1 = new Polygon2D(points1);
		Point2D vec= new Point2D(12,12);

		po1.rotate(vec,45);
		Point2D [] arr = po1.getPoints();
		System.out.println(arr[0].toString());
		System.out.println(arr[1].toString());
		System.out.println(arr[2].toString());
		System.out.println(arr[3].toString());
		System.out.println(arr[4].toString());
		
		Point2D p1v = new Point2D(12.707106781186548,14.121320343559644);
		Point2D p2v = new Point2D(12.0,12.0);
		Point2D p3v = new Point2D(9.17157287525381,19.071067811865476);
		Point2D p4v = new Point2D(14.828427124746188,17.65685424949238);
		Point2D p5v = new Point2D(9.17157287525381,20.48528137423857);
		
		assertTrue(arr[0].close2equals(p1v));
		assertTrue(arr[1].close2equals(p2v));
		assertTrue(arr[2].close2equals(p3v));
		assertTrue(arr[3].close2equals(p4v));
		assertTrue(arr[4].close2equals(p5v));
	}
	
	@Test
	void testGetPoints() { 
		boolean check = false;
		int count = 0;
		Polygon2D po = new Polygon2D(polypoints()); //Create a new polygon.
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(8,2);
		Point2D p3 = new Point2D(8,10);
		Point2D p4 = new Point2D(6,10);
		Point2D p5= new Point2D(3,16);
		
		
		Point2D [] arrayTest = new Point2D[5];
		arrayTest[0] = p1;
		arrayTest[1] = p2;
		arrayTest[2] = p3;
		arrayTest[3] = p4;
		arrayTest[4] = p5;

		Point2D [] arrayCheck = po.getPoints();
		
		for(int i=0; i<arrayTest.length; i++) { //Check if the arrays are equal.
			if(arrayTest[i].equals(arrayCheck[i])){
				count++;
			}
		}
		 if(count==arrayTest.length) { //If we run over all the points in this array - it means the arrays are equal.
			 check = true;
		 }
		 
		assertEquals(true, check);	
	}

}
