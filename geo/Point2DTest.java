/*
 * ID: 212051007
 */
package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Point2DTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	

	@Test
	void testDiatanceP() { //Check if the distance between p1 and p2 is D.
		Point2D p1 = new Point2D(12,12);
		Point2D p2 = new Point2D(6,6);
		double D = Math.sqrt(72); //D = sqrt((12-6)^2+(12-6)^2).
		boolean check = false;
		
		if(p1.distance(p2)==D) {
			check = true;
		}
		
		assertEquals(true, check);	
	}

	@Test
	void testVector() { //Check if p1 vector is (13,13).
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(0,3);
		Point2D p3 = new Point2D(-1,1);
		Point2D vec = p1.vector(p2);
		boolean check = p3.equals(vec);
	
		assertEquals(true, check);	
	}
	
	@Test
	void testMove() { //Check if the distance between p1 and p2 is D.
		boolean check = false;
		Point2D p1 = new Point2D(1,1);;
		Point2D vec = new Point2D(1,1);
		p1.move(vec);
		
		if(p1.equals(new Point2D(2,2))) {
			check = true;
		}
		assertEquals(true, check);		
	}
	
	@Test
	void tesScale1() {  
		Point2D p1 = new Point2D(1,1);
		Point2D cen2= new Point2D(0,0);
		
		p1.scale(cen2, 0.9); //Scale 90 %
		Point2D p11 = new Point2D(0.9,0.9);

		assertEquals(p1.x(), p11.x());
		assertEquals(p1.y(), p11.y());
	}
		
	@Test
	void tesScale2() { 
		Point2D p1 = new Point2D(1,1);
		Point2D cen2= new Point2D(0,0);
		
		p1.scale(cen2, 1.1); //Scale 90 %
		Point2D p11 = new Point2D(1.1,1.1);

		assertEquals(p1.x(), p11.x());
		assertEquals(p1.y(), p11.y());
	}
	
	@Test
	void tesRotate() { 
		Point2D p1= new Point2D(2,2);
		Point2D vec= new Point2D(1,1);
		p1.rotate(vec,45);
		System.out.println(p1.x()+","+p1.y());
		
		Point2D p11= new Point2D(1.0,2.414213562373095);
		
		assertEquals(p1.x(), p11.x());
		assertEquals(p1.y(), p11.y());
	}
}
