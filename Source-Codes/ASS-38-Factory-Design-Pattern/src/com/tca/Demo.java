package com.tca;

import com.tca.factory.CarFactory;
import com.tca.pojo.Car;

public class Demo {

	public static void main(String[] args) 
	{
		
		Car c = CarFactory.getCar();
		c.running();
		c.stop();
		
/*		
		// Loosly Coupled Code
		
		Car c = null;
		
		c = new Tata();
		c.running();
		c.stop();
		
		c = new Mahindra();
		c.running();
		c.stop();
*/		
		
		
/*		
 		// Tightly Coupled Code
 		
		Tata t = new Tata();
		t.running();
		t.stop();
		
		Mahindra m = new Mahindra();
		m.running();
		m.stop();
*/
	}

}
