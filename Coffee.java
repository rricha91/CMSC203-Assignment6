
/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: An extention class made to represent beverages that are coffee.
 * Due: 5/01/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan RIchards
 */
public class Coffee extends Beverage{

	private boolean extraShot;
	private final double SHOT_PRICE = 0.5;
	private boolean extraSyrup;
	private final double SYRUP_PRICE = 0.5;
	
	public Coffee(String n, Size s, boolean sh, boolean sy) {
		super(n, Type.COFFEE , s);
		extraShot = sh;
		extraSyrup = sy;
	}
	
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public void setExtraShot(boolean s) {
		extraShot = s;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public void setExtraSyrup(boolean s) {
		extraSyrup = s;
	}
	
	public double getShotPrice() {
		return SHOT_PRICE;
	}
	
	public double getSyrupPrice() {
		return SYRUP_PRICE;
	}
	
	@Override
	public String toString() {

		String str = "Name: " + getBevName() + ", Size: " + getSize() + ", Extra Coffee Shot: " + getExtraShot()
				+ ", Extra Syrup Shot: " + getExtraSyrup() + ", Price: $" + calcPrice();
		return str;
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		boolean boolShot = extraShot;
		boolean boolSyrup = extraSyrup;
		
		if(super.getSize() == Size.MEDIUM)
			price += super.SIZE_PRICE;
		else if (super.getSize() == Size.LARGE)
			price += 2* super.SIZE_PRICE;
		
		if (boolShot == true)
			price += SHOT_PRICE;
		if (boolSyrup == true)
			price += SYRUP_PRICE;
		
		return price;
	}
	
	@Override
	public boolean equals(Object c) {
		if(c instanceof Coffee) {
			boolean bool = super.equals(c);
			if(bool) {
				if (extraShot == ((Coffee) c).getExtraShot() && extraSyrup == ((Coffee) c).getExtraSyrup())
					return bool;
			}
		}
		return false;	
	}
	
	

}