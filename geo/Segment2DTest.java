/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Segment2DTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testToString() { //Check if we get the segment's points.
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(10,10);
		
		Segment2D S = new Segment2D(p1,p2); //Create a new segment.
		String st = S.toString();
		String Scheck = "Segment2D:["+p1+" , "+p2+"]"; //The string we need to get.
		
		assertEquals(st, Scheck);	
	}

	
	@Test
	void testContains() { //Check if pcheck is in the segment.
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(10,10);
		Segment2D S = new Segment2D(p1,p2); //Create a new segment.
		Point2D pcheck = new Point2D(8,8);
		
		assertEquals(true, S.contains(pcheck));	
	}
	
	@Test
	void testArea() { //Check if S's area is 0.
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(10,10);
		Segment2D S = new Segment2D(p1,p2); //Create a new segment.
		
		assertEquals(0, S.area());	
	}
	
	@Test
	void testPerimeter() { //Check if S's perimeter is 2 * p1.distance(p2).
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(10,10);
		Segment2D S = new Segment2D(p1,p2); //Create a new segment.
		
		double perimeter = 2 * p1.distance(p2);
		
		assertEquals(perimeter, S.perimeter());	
	}
	
	@Test
	void testMove() { 
		boolean check = false;
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(6,6);
		Point2D vec = new Point2D(1,1);
		
		Segment2D S = new Segment2D(p1,p2);
		S.move(vec);
		
		if(S.getp1().equals(new Point2D(2,2)) && S.getp2().equals(new Point2D(7,7))) {
			check = true;
		}
		
		assertEquals(true, check);	
	}
	
	@Test
	void testcopy() { 
		Point2D p1= new Point2D(12,12);
		Point2D p2= new Point2D(1,1);
		Segment2D S= new Segment2D(p1,p2); //Create a new segment.
		Segment2D S1= new Segment2D(p1,p2); //Create a the copy segment.
		
		Point2D[] arry= S.copy().getPoints();
		Point2D[] arry1= S1.getPoints();
		assertEquals(arry[0],arry1[0]);
		assertEquals(arry[1],arry1[1]);
	}
	
	@Test
	void tesScale1() {  
		Point2D pmax= new Point2D(2,2);
		Point2D pmin= new Point2D(0,0);
		Segment2D S= new Segment2D(pmax,pmin);
		Point2D cen1= new Point2D(0,0);
		S.scale(cen1, 0.9); //Scale 90 %
		
		Point2D p1= new Point2D(1.8,1.8);
		Segment2D S1= new Segment2D(p1,pmin);
		
		Point2D[] arry= S.getPoints();
		Point2D[] arry1= S1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
	}
		
	@Test
	void tesScale2() { 
		Point2D pmax= new Point2D(2,2);
		Point2D pmin= new Point2D(0,0);
		Segment2D S= new Segment2D(pmax,pmin);
		Point2D cen2= new Point2D(0,0);
		S.scale(cen2, 1.1); //Scale 110 % 
		
		Point2D p1= new Point2D(2.2,2.2);
		Segment2D S1= new Segment2D(p1,pmin);
		
		Point2D[] arry= S.getPoints();
		Point2D[] arry1= S1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
	}
	
	@Test
	void tesRotate() { 
		Point2D pmax= new Point2D(8,8);
		Point2D pmin= new Point2D(3,3);
		Point2D vec= new Point2D(1,1);
		Segment2D s = new Segment2D(pmin,pmax);
		s.rotate(vec,45);
		Point2D [] arr = s.getPoints();
		System.out.println(arr[0].toString());
		
		assertTrue(arr[0].close2equals(new Point2D(1.0,3.82842712474619)));
	}
	
	@Test
	void testGetPoints() { 
		boolean check = false;
		int count = 0;
		Point2D p1 = new Point2D(6,6);
		Point2D p2 = new Point2D(10,10);
		Segment2D S = new Segment2D(p1,p2); //Create a new segment.
		
		
		Point2D [] arrayTest = new Point2D[2];
		arrayTest[0] = p1;
		arrayTest[1] = p2;

		Point2D [] arrayCheck = S.getPoints();
		
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
