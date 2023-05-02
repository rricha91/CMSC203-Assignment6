import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoffeeTest_STUDENT {

	Coffee c1,c2,c3,c4, c1a, c1b, c1c, c1d, c1e;
	@Before
	public void setUp() throws Exception {
		c1 = new  Coffee ("c1Name", Size.SMALL, false,false );
		c2 = new  Coffee ("c2NAme", Size.MEDIUM, true,true );
		c3 = new  Coffee ("c3NAme", Size.LARGE, false, true );
		c4 = new  Coffee ("c4NAme", Size.SMALL, true, false );
		
		c1a = new  Coffee ("c1Name", Size.SMALL, false,false );
		c1b = new  Coffee ("c1nAme", Size.SMALL, false,false );
		c1c = new  Coffee ("c1Name", Size.SMALL, false,true );
		c1d = new  Coffee ("c1Name", Size.SMALL, true,false );
		c1e = new  Coffee ("c1Name", Size.MEDIUM, false,false );
		
	}

	@After
	public void tearDown() throws Exception {
		c1=c2=c3=c4=c1a=c1b=c1c=c1d=c1e=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,c1.getBasePrice(), .01);
		assertEquals(2.0,c2.getBasePrice(), .01);
		assertEquals(2,c3.getBasePrice(), .01);
		assertEquals(2,c4.getBasePrice(), .01);
	}

	@Test
	public void testCalcPrice() {
		
		assertEquals(2,c1.calcPrice(), .01 );
		assertEquals(4,c2.calcPrice(), .01 );
		assertEquals(4.5,c3.calcPrice(), .01 );
		assertEquals(2.5,c4.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(c1.toString().contains(c1.getBevName()));
		assertTrue(c1.toString().contains(String.valueOf(c1.calcPrice()) ));
		assertTrue(c1.toString().contains(c1.getSize().toString() ));
	 
	 
	}

	@Test
	public void testGetExtraShot() {
		assertFalse(c1.getExtraShot());
		assertTrue(c2.getExtraShot());
		assertFalse(c3.getExtraShot());
		assertTrue(c4.getExtraShot());
	}

	@Test
	public void testGetExtraSyrup() {
		assertFalse(c1.getExtraSyrup());
		assertTrue(c2.getExtraSyrup());
		assertTrue(c3.getExtraSyrup());
		assertFalse(c4.getExtraSyrup());
	}

	@Test
	public void testEqualsCoffee() {
		assertTrue(c1.equals(c1a));
		assertFalse(c1.equals(c1b));
		assertFalse(c1.equals(c1c));
		assertFalse(c1.equals(c1d));
		assertFalse(c1.equals(c1e));
	}
}
