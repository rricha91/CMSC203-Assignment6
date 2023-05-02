import java.util.*;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: A class to track the drinks ordered by various customers.
 * Due: 5/01/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderNumber;
	private int time;
	private Day day;
	private Customer customer;
	private ArrayList<Beverage> beverageList;
	
	public Order(int t, Day d, Customer c) {
		Random random = new Random();
		orderNumber = 0;
		orderNumber = random.nextInt(90000 - 10000);
		
		time = t;
		day = d;
		customer = c;
		beverageList = new ArrayList<>();
	}
	
	public void setOrderNo(int i) {
		orderNumber=i;
	}
	
	public int getOrderNo() {
		return orderNumber;
	}
	
	public int getOrderTime() {
		return time;
	}
	
	public Day getOrderDay() {
		return day;
	}
	
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public ArrayList <Beverage> getBeverages(){
		return beverageList;
	}

	@Override
	public int compareTo(Order o) {
		if (orderNumber == o.getOrderNo())
			return 0;
		else if (orderNumber < o.getOrderNo())
			return -1;
		else
			return 1;
	}

	@Override
	public boolean isWeekend() {
		
		boolean bool = false;
		if (day == Day.SATURDAY)
			bool = true;
		if (day == Day.SUNDAY)
			bool = true;
		
		return bool;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee cofeeOrder = new Coffee(bevName, size, extraShot, extraSyrup);
		beverageList.add(cofeeOrder);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean bool = isWeekend();
		Alcohol alcoholOrder = new Alcohol(bevName, size, bool);
		beverageList.add(alcoholOrder);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addPRotien) {
		Smoothie smoothieOrder = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverageList.add(smoothieOrder);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage beverage : beverageList) {
			total += beverage.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int numOfBeve = 0;
		for (Beverage beverage : beverageList) {
			if(beverage.getType() == type)
				numOfBeve++;
		}
		return numOfBeve;
	}
	
	@Override
	public String toString() {
		String str = "Order number: " + orderNumber + ", " + time + " ," +  day + ", " + customer;
		for (Beverage beverage : beverageList)
			str += "\n" + beverage;
		str += ", total: " +calcOrderTotal();
		return str;
	}
	
	public int getTotalItems() {
		return beverageList.size();
	}

}