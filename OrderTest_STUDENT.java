import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderTest_STUDENT {

	Order r1,r2,r3;
	@Before
	public void setUp() throws Exception {
		r1 = new Order (8, Day.MONDAY, new Customer ("Rose", 22));
		r2 = new Order (12, Day.SATURDAY, new Customer ("John", 45));
		r3 = new Order (10, Day.SUNDAY, new Customer ("Jade", 21));
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee cf = new Coffee("Coffee", Size.SMALL, false,false);
		Alcohol al = new Alcohol ("Wine", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Berry Shake", Size.MEDIUM,1,false);
		Smoothie sm2 = new Smoothie("Berry Shake", Size.LARGE,1,false);
		
		r1.addNewBeverage("Coffee", Size.SMALL, false,false);
		r1.addNewBeverage("Wine", Size.SMALL); 
		r1.addNewBeverage("Berry Shake", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).equals(cf) );
		assertTrue(r1.getBeverage(1).equals(al) );
		assertTrue(r1.getBeverage(2).equals(sm1) );
		assertFalse(r1.getBeverage(2).equals(sm2) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Coffee", Size.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getType().equals(Type.COFFEE));
		r1.addNewBeverage("Rum", Size.SMALL); 
		assertTrue(r1.getBeverage(1).getType().equals(Type.ALCOHOL));
		r1.addNewBeverage("Banana Smoothie", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(r1.getTotalItems() == 3);
		
		r2.addNewBeverage("Coffee", Size.MEDIUM,4,true); 
		assertTrue(r2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		r2.addNewBeverage("Rum", Size.SMALL); 
		assertTrue(r2.getBeverage(1).getType().equals(Type.ALCOHOL));
		r2.addNewBeverage("Banana Smoothie", Size.MEDIUM, true,false);
		assertTrue(r2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(r2.getTotalItems() == 3);
		 
	}
	 
	@Test
	public void testisWeekend()   {
		assertFalse(r1.isWeekend());
		assertTrue(r2.isWeekend());
		assertTrue(r3.isWeekend());
	}
	
	@Test
	public void testCalcOrderTotal()   {
		r1.addNewBeverage("Frap", Size.SMALL, false,false);
	 	r1.addNewBeverage("Beer", Size.SMALL); 
		r1.addNewBeverage("Nutrition Shake", Size.MEDIUM,1,false); 
	 
		assertEquals(7.5,r1.calcOrderTotal(),.01);
		
		r2.addNewBeverage("Frap", Size.MEDIUM, true,false);
	 	r2.addNewBeverage("Beer", Size.SMALL); 
		r2.addNewBeverage("Nutrition Shake", Size.MEDIUM,4,true); 
		
		assertEquals(12.6,r2.calcOrderTotal(),.01);
		 
	}
	
	@Test
	public void testFindNumOfBeveType()
	{
		r1.addNewBeverage("Black Coffee", Size.SMALL, false,false);
	 	r1.addNewBeverage("Tequila", Size.SMALL); 
		r1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		r1.addNewBeverage("Pumpkin Spice", Size.LARGE, true,true);
		assertEquals(2, r1.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, r1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, r1.findNumOfBeveType(Type.ALCOHOL));
		
		r2.addNewBeverage("Black Coffee", Size.MEDIUM, true,false);
	 	r2.addNewBeverage("Tequila", Size.SMALL); 
	 	assertEquals(0, r2.findNumOfBeveType(Type.SMOOTHIE));
	}
	
	@Test
	public void testToString() {
		
		r1.addNewBeverage("regular Coffee", Size.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", Size.LARGE); 
		 
		assertTrue(r1.toString().contains( String.valueOf(r1.getOrderNo()) ));
		assertTrue(r1.toString().contains( r1.getCustomer().getName()) );
		assertTrue(r1.toString().contains(r1.getBeverage(0).getSize().toString()) )  ;
		assertTrue(r1.toString().contains(r1.getBeverage(0).getBevName()) );
		
	 	 
		assertTrue(r1.toString().contains(r1.getBeverage(1).getSize().toString()) )  ;
		assertTrue(r1.toString().contains(r1.getBeverage(1).getBevName()) );
		assertTrue(r1.toString().contains( String.valueOf(r1.getBeverage(1).calcPrice()) ));
		
		assertTrue(r1.toString().contains( String.valueOf(r1.calcOrderTotal() )  ));
	}

	@Test
	public void testGetOrderNo() {
		r1.setOrderNo(10237);
		assertEquals(r1.getOrderNo(), 10237);
	}

	@Test
	public void testGetOrderTime() {
		assertEquals(r1.getOrderTime(), 8);
		assertEquals(r2.getOrderTime(), 12);
		assertEquals(r3.getOrderTime(), 10);
	}

	@Test
	public void testGetOrderDay() {
		assertEquals(r1.getOrderDay(), Day.MONDAY);
		assertEquals(r2.getOrderDay(), Day.SATURDAY);
		assertEquals(r3.getOrderDay(), Day.SUNDAY);
	}

	@Test
	public void testGetCustomer() {
		Customer c1 = new Customer("Rose",22);
		Customer c2 = new Customer("John",45);
		Customer c3 = new Customer("Jade",21);
		
		assertTrue(r1.getCustomer().equals(c1));
		assertTrue(r2.getCustomer().equals(c2));
		assertTrue(r3.getCustomer().equals(c3));
	}

	@Test
	public void testCompareTo() {
		r1.setOrderNo(10237);
		r2.setOrderNo(88888);
		r3.setOrderNo(10237);
		
		assertEquals(r1.compareTo(r2), -1);
		assertEquals(r2.compareTo(r1), 1);
		assertEquals(r3.compareTo(r1), 0);
		assertEquals(r1.compareTo(r3), 0);
	}


	@Test
	public void testAddNewBeverageStringSizeBooleanBoolean() {
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Coffee", Size.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getType().equals(Type.COFFEE));
	 	assertTrue(r1.getTotalItems() == 1);
	 	
	 	assertTrue(r2.getTotalItems() == 0);
		r2.addNewBeverage("Tea", Size.MEDIUM, true,false);
		assertTrue(r2.getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(r2.getTotalItems() == 1);
	}

	@Test
	public void testAddNewBeverageStringSize() {
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Rum", Size.SMALL); 
		assertTrue(r1.getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(r1.getTotalItems() == 1);
		
		assertTrue(r2.getTotalItems() == 0);
		r2.addNewBeverage("Rum", Size.SMALL); 
		assertTrue(r2.getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(r2.getTotalItems() == 1);
	}

	@Test
	public void testAddNewBeverageStringSizeIntBoolean() {

		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Banana Smoothie", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).getType().equals(Type.SMOOTHIE));
		assertTrue(r1.getTotalItems() == 1);
		
		assertTrue(r2.getTotalItems() == 0);
		r2.addNewBeverage("Banana Smoothie", Size.MEDIUM, true,false);
		assertTrue(r2.getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(r2.getTotalItems() == 1);
	}


	@Test
	public void testGetTotalItems() {
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Coffee", Size.SMALL, false,false);
		assertTrue(r1.getTotalItems() == 1);
		r1.addNewBeverage("Rum", Size.SMALL); 
		assertTrue(r1.getTotalItems() == 2);
		r1.addNewBeverage("Banana Smoothie", Size.MEDIUM,1,false); 
		assertTrue(r1.getTotalItems() == 3);
	}

}
