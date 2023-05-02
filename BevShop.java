import java.util.*;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The class for the beverage shop customers will order through.
 * Due: 5/01/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
public class BevShop implements BevShopInterface{
	
	private int alcOrder;
	private int MIN_AGE_FOR_ALCOHOL = 21;  
	private int MAX_ORDER_FOR_ALCOHOL= 3;   
	private int MIN_TIME= 8;				
	private int MAX_TIME= 23;				
	private int MAX_FRUIT = 5;	
	private int index;
	private ArrayList<Order> orderList;
	
	public BevShop() {
		orderList = new ArrayList<>();
	}
	
	public int getNumOfAlcoholDrink() {
		return alcOrder;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public Order getCurrentOrder() {
		return orderList.get(index);
	}
	
	public void setNumOfAlcoholDrink(int a) {
		alcOrder = a;
	}
	
	
	@Override
	public boolean isValidTime(int time) {
		if(time > MAX_TIME || time < MIN_TIME) return false;
		else return true;			
	}
	
	@Override
	public boolean isEligibleForMore() {
		if (alcOrder < MAX_ORDER_FOR_ALCOHOL) return true;
		else return false;
	}
	@Override
	public boolean isValidAge(int age) {
		if(age < MIN_AGE_FOR_ALCOHOL) return false;
		else return true;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {		
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orderList.add(order);
		alcOrder = 0;
		index = orderList.indexOf(order);
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orderList.get(index).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orderList.get(index).addNewBeverage(bevName, size);
		alcOrder++;
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtien) {
		orderList.get(index).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		int ind = 0;
		while (ind < orderList.size()) {
			if (orderList.get(ind).getOrderNo() == orderNo)
				return ind;
            ind++;
		}
		return -1;
	}

	@Override
	/**
	 * print sorted orders and monthly salary
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("All Orders:"); 
		for(Order o : orderList) str.append(o.toString() + "\n");
		
		str.append("\nSales for Last Month: " + totalMonthlySale()); 
		
		String s = str.toString();
		return s;
	}
	
	@Override
	public double totalOrderPrice(int orderNo) {
		double total = 0.0;
		for (Order order : orderList) {
			if (order.getOrderNo() == orderNo) {
				for(Beverage beverage : order.getBeverages()) {
					total += beverage.calcPrice();
				}
			}
		}
		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for (Order order : orderList) {
			for (Beverage beverage : order.getBeverages()) {
				total += beverage.calcPrice();
			}
	}
		return total;
	}

	@Override
	public void sortOrders() {

		//using selection sort algorithm 
		int pos;
		Order tempOrder; 
		
		//outer loop determines start position
		for(int i = 0; i < orderList.size(); i++) {
			
			pos = i; 
			//inner loop finds lowest value between start position and eng of array
			for(int j = i + 1; j < orderList.size(); j++) 
				if(orderList.get(j).getOrderNo() < orderList.get(i).getOrderNo())
					pos = j; 
			
			tempOrder = orderList.get(pos);
			orderList.set(pos, orderList.get(i));
			orderList.set(i, tempOrder);
		}
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}
	
	public boolean isMaxFruit(int fruit) {
		if (fruit > MAX_FRUIT) return true;
		else return false;
}
	
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
}