/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rect2DTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() { //Check if we get the rect's points.
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		
		Rect2D R = new Rect2D(p1,p2); //Create a new rectangle.
		System.out.println(R);
		
		String st = R.toString();
		String Rst = "Rect2D:["+p2+" , "+p1+"]"; //The string we need to get.
		
		assertEquals(st, Rst);	
	}

	
	@Test
	void testContains() { //Check if pcheck is in the rect.
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		Point2D pcheck = new Point2D(10,10);
		
		Rect2D R = new Rect2D(p1,p2);
		
		assertEquals(true, R.contains(pcheck));	
	}
	
	@Test
	void testArea() { //Check if R's area is 36.
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		double area = (12-6)*(12-6);
		
		Rect2D R = new Rect2D(p1,p2);
		
		assertEquals(area, R.area());	
	}
	
	@Test
	void testPerimeter() { //Check if R's perimeter is 24.
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		double perimeter = (12-6)*2 +(12-6)*2;
		
		Rect2D R = new Rect2D(p1,p2);
		
		assertEquals(perimeter, R.perimeter());	
	}
	
	@Test
	void testMove() { 
		boolean check = false;
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(8,8);
		Rect2D R = new Rect2D(p1,p2);
		
		Point2D vec = new Point2D(1,1);
		R.move(vec);
		
		if(R.getpmin().equals(new Point2D(2,2)) && R.getpmax().equals(new Point2D(9,9))) {
			check = true;
		}
		assertEquals(true, check);	
	}
	
	@Test
	void testcopy() { 
		Point2D p1= new Point2D(12,12);
		Point2D p2= new Point2D(1,1);
		Rect2D r= new Rect2D(p1,p2);
		Rect2D r1= new Rect2D(p1,p2);
		
		Point2D[] arry= r.copy().getPoints();
		Point2D[] arry1= r1.getPoints();
		assertEquals(arry[0],arry1[0]);
		assertEquals(arry[1],arry1[1]);
	}
	
	@Test
	void tesScale1() {  
		Point2D pmax= new Point2D(2,2);
		Point2D pmin= new Point2D(0,0);
		Rect2D r= new Rect2D(pmax,pmin);
		Point2D cen1= new Point2D(0,0);
		r.scale(cen1, 0.9); //Scale 90 %
		
		Point2D p1= new Point2D(1.8,1.8);
		Rect2D r1= new Rect2D(p1,pmin);
		
		Point2D[] arry= r.getPoints();
		Point2D[] arry1= r1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
	}
		
	@Test
	void tesScale2() { 
		Point2D pmax= new Point2D(2,2);
		Point2D pmin= new Point2D(0,0);
		Rect2D r= new Rect2D(pmax,pmin);
		Point2D cen1= new Point2D(0,0);
		r.scale(cen1, 1.1); //Scale 10 %
		
		Point2D p1= new Point2D(2.2,2.2);
		Rect2D r1= new Rect2D(p1,pmin);
		
		Point2D[] arry= r.getPoints();
		Point2D[] arry1= r1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
	}
	
	@Test
	void tesRotate() { 
		Point2D pmax= new Point2D(8,8);
		Point2D pmin= new Point2D(3,3);
		Point2D vec= new Point2D(1,1);
		Rect2D r1 = new Rect2D(pmin,pmax);
		r1.rotate(vec,45);
		Point2D [] arr = r1.getPoints();
		System.out.println(arr[0].toString());
		
		assertTrue(arr[0].close2equals(new Point2D(1,3)));
	}
	
	@Test
	void testGetPoints() { 
		boolean check = false;
		int count = 0;
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		Rect2D R = new Rect2D(p1,p2);
		
		Point2D [] arrayTest = new Point2D[2];
		arrayTest[0] = p2;
		arrayTest[1] = p1;

		Point2D [] arrayCheck = R.getPoints();
		
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
