import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest_STUDENT {

	Customer c1,c2;
	@Before
	public void setUp() throws Exception {
		 c1 = new Customer("name1", 10);
	 
	}

	@After
	public void tearDown() throws Exception {
		
		c1=null;
	}

	@Test
	public void testCustomer() {
		Customer c2  = new Customer(c1);
		
		assertFalse(c1 == c2);
		assertTrue(c2.equals(c1));
		assertTrue(c2.getName().equals(c1.getName()));
		assertTrue(c2.getAge() == c1.getAge());
		
		c2.setName("name2");
		c2.setAge(20);
		assertFalse(c2.getName().equals(c1.getName()));
		assertFalse(c2.getAge() == c1.getAge());
	}

	@Test
	public void testGetName() {
		assertEquals(c1.getName(), "name1");
	}

	@Test
	public void testSetName() {
		assertEquals(c1.getName(),"name1");
		c1.setName("name3");
		assertEquals(c1.getName(),"name3");
	}

	@Test
	public void testGetAge() {
		assertEquals(c1.getAge(),10);
	}

	@Test
	public void testSetAge() {
		assertEquals(c1.getAge(),10);
		c1.setAge(30);
		assertEquals(c1.getAge(),30);
	}

	@Test
	public void testToString() {
		assertEquals(c1.toString(), "Name: name1, Age: 10");
	}

}
