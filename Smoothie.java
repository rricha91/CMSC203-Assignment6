public class Smoothie extends Beverage{
	/*
	 * Class: CMSC203 
	 * Instructor: Grigoriy Grinberg
	 * Description: An extention class to represent beverages that are smoothies.
	 * Due: 5/01/2023
	 * Platform/compiler: Eclipse IDE
	 * I pledge that I have completed the programming 
	 * assignment independently. I have not copied the code 
	 * from a student or any source. I have not given my code 
	 * to any student.
	   Print your Name here: Ryan RIchards
	 */
	private int fruit;
	protected final double FRUIT_PRICE = 0.5;
	private boolean protein;
	protected final double PROTEIN_PRICE = 1.5;
	
	public Smoothie (String n, Size s, int f, boolean p) {
		super(n, Type.SMOOTHIE, s);
		fruit = f;
		protein = p;
	}
	
	public int getNumOfFruits() {
		return fruit;
	}
	
	public boolean getAddProtien() {
		return protein;
	}
	
	@Override
	public String toString() {
		String str = "Name: " + getBevName() + ", Size: " + getSize() + ", Extra Protein: " + getAddProtien()
		+ ", Number of Fruits: " + getNumOfFruits() + ", Price: $" + calcPrice();
		return str;
	}
	
	@Override
	public boolean equals(Object s) {
		if(s instanceof Smoothie) {
			boolean bool = super.equals(s);
			if(bool) {
				if (fruit == ((Smoothie) s).getNumOfFruits() && protein == ((Smoothie) s).getAddProtien())
					return bool;
			}
		}
		return false;	
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		//double price = 0.0;
		
		if(super.getSize() == Size.MEDIUM)
			price += super.SIZE_PRICE;
		else if (super.getSize() == Size.LARGE)
			price += 2 * super.SIZE_PRICE;
		
		double fruitTotal = FRUIT_PRICE * getNumOfFruits();
		price += fruitTotal;
		boolean bool = protein;
		if (bool == true)
			price += PROTEIN_PRICE;
		
		return price;
	}

}