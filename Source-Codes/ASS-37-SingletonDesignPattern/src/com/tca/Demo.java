package com.tca;

/*
 * 	Singleton Design Pattern :
 	--> Restrict a class to create "only one object" of a class. 
 */

class A 
{
	private static A ob = null; // ob--> ref(100)
	
	private A()
	{
		System.out.println("I am in Construcotor.....");
	}
	
	public static A getInstance()
	{
		if(ob==null)
		{
			ob = new A();
		}
		return ob;
	}
}

public class Demo 
{

	public static void main(String[] args) 
	{
		A ob1 =  A.getInstance();  // ob1-->  100
		A ob2 =  A.getInstance();  // ob2 --> 100
				
		//A  ob1 =  new A();
		//A  ob2 =  new A();
		
		System.out.println(ob1);
		System.out.println(ob2);
		
	}

}
