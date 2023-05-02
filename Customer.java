public class Customer {
	
	private String name;
	private int age;
	
	/*
	 * Class: CMSC203 
	 * Instructor: Grigoriy Grinberg
	 * Description: A class to hold each customer's name and age.
	 * Due: 5/01/2023
	 * Platform/compiler: Eclipse IDE
	 * I pledge that I have completed the programming 
	 * assignment independently. I have not copied the code 
	 * from a student or any source. I have not given my code 
	 * to any student.
	   Print your Name here: Ryan RIchards
	 */
	public Customer(String n, int a) {
		name = n;
		age = a;
	}
	
	public Customer(Customer c) {
		name = new String(c.getName());
		age = c.getAge();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
	
	@Override
	public String toString() {
		String str = "Name: " + name + ", Age: " + age;
		return str;
	}
	
	@Override
	public boolean equals(Object c) {
		if(c instanceof Customer) {
			if (age==((Customer) c).getAge()) {
				char[] ah1 = name.toCharArray();
				char[] ah2 = ((Customer) c).getName().toCharArray();
				
				if (ah1.length == ah2.length) {
					for (int i=0; i<ah1.length; i++) if ((ah1[i]==ah2[i])==false) return false;
					
					return true;
				}
			}
		}
		return false;	
	}
}