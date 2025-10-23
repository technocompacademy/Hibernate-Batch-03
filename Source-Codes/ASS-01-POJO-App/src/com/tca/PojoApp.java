package com.tca;

import com.tca.entities.Student;

public class PojoApp {

	public static void main(String[] args) 
	{
		
		Student ob = new Student();   // 101 AAA 60
		ob.setRno(101);
		ob.setName("AAAA");
		ob.setPer(60);
		
		System.out.println("Roll Number :" + ob.getRno() );
		System.out.println("Name        :" + ob.getName() );
		System.out.println("Percentage  :" + ob.getPer()  );
	}

}
