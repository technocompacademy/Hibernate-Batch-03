package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

public class SMSController {

	public static void main(String[] args) 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n************** Welcome to Techno Comp Acdemy ************ \n");
		
		try
		{
			while(true)
			{
				System.out.println("Menu");
			 
	    	    		System.out.println("1. Save ");
	    	    		System.out.println("2. Fetch By Id ");
	    	    		System.out.println("3. Fetch By name ");
	    	    		System.out.println("4. Fetch By city ");
	    	    		System.out.println("5. Update ");
	    	    		System.out.println("6. Delete ");
	    	    		System.out.println("7. All Student ");
		    	    System.out.println("8. Exit ");
		    	    
		    	   
		    	    
		    	    System.out.print("What is your choice : ");
		    	    int choice  = Integer.parseInt(br.readLine());
		    	    
		    	    switch(choice)
		    	    {
		    	    		case 1: optionSaveStudent();
		    	    				break;
		    	    				
		    	    		case 2 :
		    	    				optionFetchStudentById();
		    	    				break;
		    	    		case 3 : optionFetchStudentByName();
	    	   				 	break;
	    	   				 	
		    	    		case 4 : optionFetchStudentByCity();;
		    	    				break;
		    	    				
		    	    		case 5 : optionUpdateStudent();
	    	   				 	break;
	    	   				 	
		    	    		case 6 : optionDeleteStudent();
	    	   				 	break;
		    	    		case 7 :
		    	    				optionFetchAllStudent();
		    	    				break;
		    	    		case 8 :
		    	    					HibernateUtil.closeSessionFactory();
		    	    					System.out.println("********** Shutdown System ************* !!!");
		    	    					System.exit(0);
		    	    		default:
		    	    				System.out.println("***** Invalid choice ! *****");
		    	    }
			}//while
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.closeSessionFactory();
			System.out.println("Done !!!");
		}
		
		
		
		//optionSaveStudent();
		//optionFetchStudentById();
		//optionFetchStudentByName();
		//optionFetchStudentByCity();
		//optionFetchAllStudent();
		//optionUpdateStudent();
		//optionDeleteStudent();
		
		
	}
	
	
	private static void optionSaveStudent()
	{
			
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		try
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
			System.out.println("Problm During Registering User !!");
		}
		
		
	}
	
	private static void optionFetchStudentById()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		
		try
		{
			System.out.print("Enter your roll number to Get data : ");
			int rno = sc.nextInt();
			
			Student s = service.fetchStudentById(rno);
			
			if(s==null)
			{
				System.out.println("Record not found for Roll Numebr : " + rno);
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " +  s.getCity());
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionFetchStudentByName()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Name to get Data : ");
			String name = sc.nextLine();
			
			List<Student> L = service.fetchStudentByName(name);
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found for Name : " + name);
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void optionFetchStudentByCity()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter City Name to get Data : ");
			String city = sc.nextLine();
			
			List<Student> L = service.fetchStudentByCity(city);
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found for City : " + city);
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void optionFetchAllStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		
		
		try
		{
			List<Student> L = service.fetchAllStudent();
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found !");
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionUpdateStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.modifyStudent(rno);
			
			if(status)
			{
				System.out.println("Record is updated Successfully for Roll Number : " +  rno);
			}
			else
			{
				System.out.println("Record not Found for Roll Number : " +  rno);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem during Update Student !!");
			e.printStackTrace();
			
		}
		
	}
	
	private static void optionDeleteStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.removeStudent(rno);
			
			if(status)
			{
				System.out.println("Record is Deleted Successfully for Roll Number : " +  rno);
			}
			else
			{
				System.out.println("Record not Found for Roll Number : " +  rno);
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem during Delete Student !!");
			e.printStackTrace();
			
		}
		
	}
}










