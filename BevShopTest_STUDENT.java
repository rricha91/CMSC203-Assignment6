import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BevShopTest_STUDENT {


	BevShop bevShop;
	@Before
	public void setUp() throws Exception {
		bevShop = new BevShop();
	}

	@After
	public void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	public void testIsValidTime()
	{
		assertTrue(bevShop.isValidTime(8));
		assertTrue(bevShop.isValidTime(23));
		assertFalse(bevShop.isValidTime(7));
		assertFalse(bevShop.isValidTime(24));
	}
	 
	@Test
	public void testIsValidAge()
	{
		assertFalse(bevShop.isValidAge(20));
		assertTrue(bevShop.isValidAge(27));
	}
	
	@Test
	public void testStartNewOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"John", 30);
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("John", bevShop.getCurrentOrder().getCustomer().getName());
		assertEquals(30, bevShop.getCurrentOrder().getCustomer().getAge());
		assertEquals(0,bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 0);
	}
	
	@Test
	public void testProcessAlcoholOrder()
	{
		bevShop.startNewOrder(9,Day.MONDAY,"Rose", 30);
		
		bevShop.processAlcoholOrder("Wine", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Wine"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));	
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Wiskey", Size.MEDIUM);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Wiskey"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));	
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Vodka", Size.SMALL);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getBevName().equals("Vodka"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getType().equals(Type.ALCOHOL));	
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
		
	}
	
	@Test
	public void testProcessSmoothieOrder()
	{
		bevShop.startNewOrder(11,Day.MONDAY,"Roxy", 30);
		assertTrue ( bevShop.isMaxFruit(6) );
		assertFalse ( bevShop.isMaxFruit(5) );
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		
		Smoothie sm = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);
		
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Detox"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));
		
		
		assertTrue(sm.getNumOfFruits() == 1);
		assertFalse(sm.getAddProtien());
		 
		
		bevShop.processSmoothieOrder("Green Sun", Size.LARGE, 4, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		
		sm =  (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Green Sun"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));
		
		assertTrue(sm.getNumOfFruits() == 4);
		assertTrue(sm.getAddProtien());
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
		
	}
	
	@Test
	public void testProcessCoffeeOrder()
	{
		Coffee cf;
		bevShop.startNewOrder(8,Day.MONDAY,"Jane", 20);
		bevShop.processCoffeeOrder("Expresso", Size.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Expresso"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(cf.getExtraShot()); 
		assertFalse(cf.getExtraSyrup()); 
		
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(1);
		
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Cappuccino"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.COFFEE));
		assertFalse(cf.getExtraShot()); 
		assertFalse(cf.getExtraSyrup()); 
		
	}
	
	@Test
	public void testFindOrder()
	{
		int orderNum;
		bevShop.startNewOrder(8,Day.MONDAY,"Equius", 20);
		bevShop.processCoffeeOrder("Black Ground Coffee", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("Morning SunShine", Size.LARGE, 4, true);
		
		orderNum = bevShop.getCurrentOrder().getOrderNo();
		
		bevShop.startNewOrder(8,Day.SUNDAY,"Vriska", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		
		assertEquals(0,bevShop.findOrder(orderNum));
		
		orderNum = bevShop.getCurrentOrder().getOrderNo();
		assertEquals(1,bevShop.findOrder(orderNum));
		
	}
	@Test
	public void testTotalOrderPrice(){
	 	int orderNum1,orderNum2;
		
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);
		
		orderNum1 = bevShop.getCurrentOrder().getOrderNo();
		
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
	
		orderNum2 = bevShop.getCurrentOrder().getOrderNo();
	 
		assertEquals(11.5,bevShop.totalOrderPrice(orderNum1),.01);
		assertEquals(2.5,bevShop.totalOrderPrice(orderNum2),.01 );
		
	}
	
	@Test
	public void testTotalMonthlySale() {
		bevShop.startNewOrder(8,Day.MONDAY,"Feferi", 20);
		bevShop.processCoffeeOrder("Cappuccino", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);
	
		bevShop.startNewOrder(8,Day.SUNDAY,"Rose", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);
		
		bevShop.startNewOrder(12,Day.SATURDAY,"Kanaya", 43);
		bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 4, true);
		bevShop.processCoffeeOrder("Latte", Size.SMALL,false, false);		 

		assertEquals(25.1, bevShop.totalMonthlySale(), .01 );
 
	}
	
	@Test
	public void testSortOrders()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Dirk", 20);
		bevShop.startNewOrder(8,Day.SUNDAY,"Dave", 30);
		bevShop.startNewOrder(12,Day.SATURDAY,"Damara", 43);
		
		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNo()< bevShop.getOrderAtIndex(1).getOrderNo());	 
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNo()< bevShop.getOrderAtIndex(2).getOrderNo());
		
	}@Test
	public void testToString() {
		
		bevShop.startNewOrder(8,Day.MONDAY,"Jane", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		 
	
		bevShop.startNewOrder(14,Day.SUNDAY,"June", 30);
		bevShop.processSmoothieOrder("Chocolate Milkshake", Size.SMALL, 1, false);
			  
		 
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(0).getOrderNo()) ));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getCustomer().getName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getBevName()) );
		
	 	
		assertTrue(bevShop.toString().contains(String.valueOf(bevShop.getOrderAtIndex(1).getOrderNo()) ));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getCustomer().getName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getBevName()) );
		
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.totalMonthlySale() )  ));
		
 
		 
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		bevShop.startNewOrder(11,Day.SUNDAY,"Rose", 30);
		
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 1);
		bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 4, true);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 1);
		bevShop.processCoffeeOrder("Latte", Size.SMALL,false, false);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 1);
		bevShop.processAlcoholOrder("Wine", Size.LARGE);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 2);
		bevShop.processAlcoholOrder("Wiskey", Size.MEDIUM);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 3);
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(bevShop.getMaxOrderForAlcohol(),3);
	}

	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(bevShop.getMaxNumOfFruits(),5);
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(bevShop.getMinAgeForAlcohol(),21);
	}

	@Test
	public void testGetCurrentOrder() {
		Customer R = new Customer("Rose",30);
		Customer V = new Customer("Vriska",30);
		Customer E = new Customer ("Equius",20);
		
		
		
		bevShop.startNewOrder(8,Day.SATURDAY,"Equius", 20);
		bevShop.processCoffeeOrder("Black Ground Coffee", Size.SMALL, true, false);
		
		assertTrue(bevShop.getCurrentOrder().getCustomer().equals(E));
		assertEquals(bevShop.getCurrentOrder().getOrderDay(),Day.SATURDAY);
		assertEquals(bevShop.getCurrentOrder().getBeverage(0).getBevName(),"Black Ground Coffee");
		
		
		bevShop.startNewOrder(11,Day.SUNDAY,"Rose", 30);
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);
		
		assertTrue(bevShop.getCurrentOrder().getCustomer().equals(R));
		assertEquals(bevShop.getCurrentOrder().getOrderDay(),Day.SUNDAY);
		assertEquals(bevShop.getCurrentOrder().getBeverage(0).getBevName(),"Mohito");
		
		
		bevShop.startNewOrder(8,Day.MONDAY,"Vriska", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);;
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		
		assertTrue(bevShop.getCurrentOrder().getCustomer().equals(V));
		assertEquals(bevShop.getCurrentOrder().getOrderDay(),Day.MONDAY);
		assertEquals(bevShop.getCurrentOrder().getBeverage(0).getBevName(),"Detox");
	}

	@Test
	public void testSetNumOfAlcoholDrink() {
		assertTrue(bevShop.isEligibleForMore());
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		bevShop.setNumOfAlcoholDrink(3);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 3);
		assertFalse(bevShop.isEligibleForMore());
	}


	@Test
	public void testIsEligibleForMore() {
bevShop.startNewOrder(11,Day.SUNDAY,"Rose", 30);
		
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 4, true);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processCoffeeOrder("Latte", Size.SMALL,false, false);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Wine", Size.LARGE);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Wiskey", Size.MEDIUM);
		assertFalse(bevShop.isEligibleForMore());
	}

	@Test
	public void testGetOrderAtIndex() {
		bevShop.startNewOrder(8,Day.MONDAY,"Equius", 20);
		bevShop.processCoffeeOrder("Black Ground Coffee", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		
		
		bevShop.startNewOrder(11,Day.SUNDAY,"Rose", 30);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);;
		assertEquals(bevShop.getNumOfAlcoholDrink(), 1);
		
		bevShop.startNewOrder(8,Day.SUNDAY,"Vriska", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);;
		assertEquals(bevShop.getNumOfAlcoholDrink(), 0);
		
		Customer R = new Customer("Rose",30);
		Customer V = new Customer("Vriska",30);
		assertTrue(bevShop.getCurrentOrder().getCustomer().equals(V));
		
		assertTrue(bevShop.getOrderAtIndex(1).getCustomer().equals(R));
		assertEquals(bevShop.getOrderAtIndex(1).findNumOfBeveType(Type.ALCOHOL),1);
		
	}

	@Test
	public void testIsMaxFruit() {
		assertFalse(bevShop.isMaxFruit(4));
		assertFalse(bevShop.isMaxFruit(5));
		assertTrue(bevShop.isMaxFruit(6));
	}

	@Test
	public void testTotalNumOfMonthlyOrders() {
		assertEquals(bevShop.totalNumOfMonthlyOrders(),0);
		
		bevShop.startNewOrder(8,Day.SUNDAY,"Vriska", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertEquals(bevShop.totalNumOfMonthlyOrders(),1);
		
		bevShop.startNewOrder(8,Day.MONDAY,"Jane", 20);
		assertEquals(bevShop.totalNumOfMonthlyOrders(),2);
		bevShop.startNewOrder(14,Day.SUNDAY,"June", 30);
		assertEquals(bevShop.totalNumOfMonthlyOrders(),3);
		bevShop.startNewOrder(14,Day.SUNDAY,"June", 30);
		assertEquals(bevShop.totalNumOfMonthlyOrders(),4);
	}

}
