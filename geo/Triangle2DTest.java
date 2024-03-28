/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Triangle2DTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void testToString() { //Check if we get the Triangle's points.
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.

		//The string we need to get.
		String Scheck = "Triangle2D:["+p1.toString()+" , "+p2.toString()+" , "+p3.toString()+"]"; 
		
		assertEquals(T.toString(), Scheck);	
	}

	
	@Test
	void testContains() { //Check if pcheck is in the Triangle.
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		
		Point2D pcheck = new Point2D(2,2);
		
		assertEquals(true, T.contains(pcheck));	
	}
	
	@Test
	void testArea() { //According to the formula of Triangle's area.
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		double halfperi = 0.5*(p1.distance(p2)+p2.distance(p3)+p3.distance(p1));
		double area = Math.sqrt(halfperi*((halfperi-p1.distance(p2))*(halfperi-p2.distance(p3))*(halfperi-p3.distance(p1))));
		assertEquals(area, T.area());	
	}
	
	@Test
	void testPerimeter() { //Check if T's perimeter is the sum of all the points' distances.
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		
		double perimeter = p1.distance(p2)+p2.distance(p3)+p3.distance(p1);
		
		assertEquals(perimeter, T.perimeter());	
	}
	
	@Test
	void testMove() { 
		boolean check = false;
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		
		Point2D vec = new Point2D(1,1);
		T.move(vec);
		
		if(T.getp1().equals(new Point2D(3,3)) && T.getp2().equals(new Point2D(9,9)) && T.getp3().equals(new Point2D(9,3))) {
			check = true;
		}
		
		assertEquals(true, check);	
	}
	
	@Test
	void testcopy() { 
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		Triangle2D T1 = new Triangle2D(p1,p2,p3); //Create a the copy segment.
		
		Point2D[] arry= T.copy().getPoints();
		Point2D[] arry1= T1.getPoints();
		assertEquals(arry[0],arry1[0]);
		assertEquals(arry[1],arry1[1]);
	}
	
	@Test
	void tesScale1() {  
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,0);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		Point2D cen2= new Point2D(0,0);
		
		T.scale(cen2, 0.9); //Scale 90 %
		
		Point2D p11 = new Point2D(0,0);
		Point2D p22= new Point2D(7.2,7.2);
		Point2D p33 = new Point2D(7.2,0);
		Triangle2D T1 = new Triangle2D(p11,p22,p33);
		
		Point2D[] arry= T.getPoints();
		Point2D[] arry1= T1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
		assertEquals(arry[2], arry1[2]);
	}
		
	@Test
	void tesScale2() { 
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,0);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		Point2D cen2= new Point2D(0,0);
		
		T.scale(cen2, 1.1); //Scale 110 % 
		
		Point2D p11 = new Point2D(0,0);
		Point2D p22= new Point2D(8.8,8.8);
		Point2D p33 = new Point2D(8.8,0);
		Triangle2D T1 = new Triangle2D(p11,p22,p33);
		
		Point2D[] arry= T.getPoints();
		Point2D[] arry1= T1.getPoints();
		assertEquals(arry[0], arry1[0]);
		assertEquals(arry[1], arry1[1]);
		assertEquals(arry[2], arry1[2]);
	}
	
	@Test
	void tesRotate() { 
		Point2D p1 = new Point2D(5,3);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,0);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		
		Point2D vec= new Point2D(1,1);

		T.rotate(vec,45);
		Point2D [] arr = T.getPoints();
		System.out.println(arr[0].toString());
		System.out.println(arr[1].toString());
		System.out.println(arr[2].toString());
		
		Point2D p1v = new Point2D(2.4142135623730954,5.242640687119285);
		Point2D p2v = new Point2D(1.0000000000000009,10.899494936611664);
		Point2D p3v = new Point2D(6.65685424949238,5.242640687119284);
		
		assertTrue(arr[0].close2equals(p1v));
		assertTrue(arr[1].close2equals(p2v));
		assertTrue(arr[2].close2equals(p3v));
	}
	
	@Test
	void testGetPoints() { 
		boolean check = false;
		int count = 0;
		Point2D p1 = new Point2D(2,2);
		Point2D p2 = new Point2D(8,8);
		Point2D p3 = new Point2D(8,2);
		Triangle2D T = new Triangle2D(p1,p2,p3); //Create a new Triangle.
		
		Point2D [] arrayTest = new Point2D[3];
		arrayTest[0] = p1;
		arrayTest[1] = p2;
		arrayTest[2] = p3;

		Point2D [] arrayCheck = T.getPoints();
		
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
