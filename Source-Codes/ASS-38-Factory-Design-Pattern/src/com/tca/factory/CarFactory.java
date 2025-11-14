package com.tca.factory;

import com.tca.pojo.Car;
import com.tca.pojo.Mahindra;
import com.tca.pojo.Tata;

public class CarFactory 
{
	private static Car c = null;
	
	private CarFactory()
	{
		
	}
	
	public static Car getCar()
	{
		if(c ==null)
		{
			c = new Mahindra();
		}
		return c;
	}
}
