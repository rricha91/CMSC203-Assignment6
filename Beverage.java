import static org.junit.Assert.assertArrayEquals;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: A class to represent the various drinks ordered.
 * Due: 5/01/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
public abstract class Beverage {

	private String name;
	private Type type;
	private Size size;
	protected final double BASE_PRICE = 2.0;
	protected final double SIZE_PRICE = 1;

	/**
	 * Beverage constructor
	 * 
	 * @param name
	 * @param type
	 * @param size
	 */
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	public Beverage(String name, Size size) {
		this.name = name;
		this.size = size;
	}
	public Beverage(Beverage drinks) {
		this.name = new String(drinks.name);
		this.type = drinks.type;
		this.size = drinks.size;
	}

	// METHODS

	public String getBevName() {
		return name;
	}

	public void setBevName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public double getBasePrice() {
		return BASE_PRICE;
	}

	/**
	 * this calculates and returns the beverage price.
	 * 
	 * @return
	 */
	public abstract double calcPrice();

	@Override
	public String toString() {
		return name + ", " + size;
	}
	
	@Override
	public boolean equals(Object beverage) {
		if(beverage instanceof Beverage) if (size == ((Beverage) beverage).getSize() && type == ((Beverage) beverage).getType()) { 
			char[] Ar1 = this.name.toCharArray();
			char[] Ar2 = ((Beverage) beverage).getBevName().toCharArray();
			
			if (Ar1.length == Ar2.length) {
				for (int i=0; i<Ar1.length; i++)  {
					if ((Ar1[i]==Ar2[i])==false) return false;
				}
				return true;
			}
		}
		return false;	
	}

}