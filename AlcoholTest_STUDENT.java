import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlcoholTest_STUDENT {
	Alcohol a1,a2,a3,a4,a1a,a1b,a1c,a1d;

	@Before
	public void setUp() throws Exception {
		a1 = new  Alcohol ("A1NAme", Size.SMALL, false );
		a2 = new  Alcohol ("A2NAme", Size.MEDIUM, true );
		a3 = new  Alcohol ("A3NAme", Size.LARGE, false );
		a4 = new  Alcohol ("A4NAme", Size.SMALL, true );
		
		
		a1a = new  Alcohol ("A1NAme", Size.SMALL, false );
		a1b = new  Alcohol ("A1nAme", Size.SMALL, false );
		a1c = new  Alcohol ("A1NAme", Size.MEDIUM, false );
		a1d = new  Alcohol ("A1NAme", Size.SMALL, true );
		
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=a1a=a1b=a1c=a1d=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,a1.getBasePrice(), .01);
		assertEquals(2.0,a2.getBasePrice(), .01);
		assertEquals(2.0,a3.getBasePrice(), .01);
		assertEquals(2.0,a4.getBasePrice(), .01);
	}
 
	@Test
	public void testCalPrice() {
		
		assertEquals(2,a1.calcPrice(), .01 );
		assertEquals(3.6,a2.calcPrice(), .01 );
		assertEquals(4,a3.calcPrice(), .01 );
		assertEquals(2.6,a4.calcPrice(), .01 );
	}
	@Test
	public void testToString() {
		
		assertTrue(a1.toString().contains(a1.getBevName()));
		assertTrue(a1.toString().contains(String.valueOf(a1.calcPrice()) ));
		assertTrue(a1.toString().contains(a1.getSize().toString() ));
	}
	@Test
	public void testEquals() {
		assertTrue(a1.equals(a1a));
		assertFalse(a1.equals(a1b));
		assertFalse(a1.equals(a1c));
		assertFalse(a1.equals(a1d));
	}
	
	
	

}
