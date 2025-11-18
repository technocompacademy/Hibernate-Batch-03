package com.tca;

import java.io.FileReader;
import java.util.Scanner;

import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class SMSController {

	public static void main(String[] args) 
	{
		
		optionSaveStudent();
		
		HibernateUtil.closeSessionFactory();
		System.out.println("DOne !!!");
	}
	
	
	private static void optionSaveStudent()
	{
			
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		
		try(Scanner sc = new Scanner(System.in);)
		{
		
			System.out.print("Enter the Name : ");
			String name = sc.nextLine();
		
			System.out.print("Enter the Percentage : ");
			double per = sc.nextDouble();  // 
	
		
			System.out.print("Enter the City : ");
			String city = sc.next();
		
			Student S = new Student();
			S.setName(name);
			S.setPer(per);
			S.setCity(city);
		
			Integer id = service.addStudent(S);
		
			if(id==null)
			{
				System.out.println("Unable to Save Student Records !!");
			}
			else
			{
				System.out.println("Record is Saved Succesfullly !!");
				System.out.println("Resgitered ID : "  + id);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problm During Regustering User !!");
		}
		
		
	}

}
