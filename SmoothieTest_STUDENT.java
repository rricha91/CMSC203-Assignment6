import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SmoothieTest_STUDENT {


	Smoothie s1,s2,s3,s4,s1a,s1b,s1c,s1d,s1e;
	@Before
	public void setUp() throws Exception {
		s1 = new  Smoothie ("s1Name", Size.SMALL, 1,false );
		s2 = new  Smoothie ("s2Name", Size.MEDIUM, 2,true );
		s3 = new  Smoothie ("s3Name", Size.LARGE, 3, true );
		s4 = new  Smoothie ("s4Name", Size.SMALL, 4, false );
		
		s1a = new  Smoothie ("s1Name", Size.SMALL, 1,false );
		s1b = new  Smoothie ("s1NAme", Size.SMALL, 1,false );
		s1c = new  Smoothie ("s1Name", Size.MEDIUM, 1,false );
		s1d = new  Smoothie ("s1Name", Size.SMALL, 2,false );
		s1e = new  Smoothie ("s1Name", Size.SMALL, 1,true );
	}

	@After
	public void tearDown() throws Exception {
		s1=s2=s3=s4=s1a=s1b=s1c=s1d=s1e=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,s1.getBasePrice(), .01);
		assertEquals(2.0,s2.getBasePrice(), .01);
		assertEquals(2,s3.getBasePrice(), .01);
		assertEquals(2,s4.getBasePrice(), .01);
	}
 
	@Test
	public void testCalcPrice() {
		
		assertEquals(2.5,s1.calcPrice(), .01 );
		assertEquals(5.5,s2.calcPrice(), .01 );
		assertEquals(7,s3.calcPrice(), .01 );
		assertEquals(4,s4.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		assertTrue(s1.toString().contains(s1.getBevName()));
		assertTrue(s1.toString().contains(String.valueOf(s1.calcPrice()) ));
		assertTrue(s1.toString().contains(s1.getSize().toString() ));
		assertTrue(s1.toString().contains( String.valueOf(s1.getNumOfFruits()) ));
	}

	@Test
	public void testEquals() {
		assertTrue(s1.equals(s1a));
		assertFalse(s1.equals(s1b));
		assertFalse(s1.equals(s1c));
		assertFalse(s1.equals(s1d));
		assertFalse(s1.equals(s1e));
	}
}
