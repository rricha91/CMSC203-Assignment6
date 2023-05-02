/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: An extention class for beverages that are specifically alchoholic.
 * Due: 5/01/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
public class Alcohol extends Beverage{
	
	private boolean weekend;
	private final double WEEKEND_PRICE = 0.6;
	
	public Alcohol(String n, Size s, boolean w) {
		super(n, Type.ALCOHOL, s);
		weekend = w;
	}
	
	public boolean isWeekend() {
		return weekend;
	}

	@Override
	public String toString() {

		String str = "Name: " + getBevName() + ", Size: " + getSize() + ", Offered of Weekend: " + weekend
				+ ", Price: $" + calcPrice();
		return str;
	}
	
	@Override
	public boolean equals (Object a) {
		if(a instanceof Alcohol) {
			boolean bool = super.equals(a);
			if(bool) {
				if (weekend == ((Alcohol) a).isWeekend())
					return bool;
			}
		}
		return false;	
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		boolean bool = weekend;
		
		if(super.getSize() == Size.MEDIUM)
			price += super.SIZE_PRICE;
		else if (super.getSize() == Size.LARGE)
			price += 2 * super.SIZE_PRICE;
		
		if (bool == true)
			price += WEEKEND_PRICE;
		
		return price;
	}
	
}