package com.tca.service;

import java.util.List;
import java.util.Scanner;

import com.tca.dao.StudentDao;
import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService
{
	
	@Override
	public Integer addStudent(Student S) 
	{
		StudentDao studentDao = StudentDaoFactory.getStudentDaoInstance();
		
		//String tname = S.getName().toLowerCase(); // "Sachin DHane" --> "sachin dhane"
		//String tcity = S.getCity().toLowerCase();// PuNe --> "pune"
		
		//S.setName(tname);
		//S.setCity(tcity);
		
		S.setName(S.getName().toLowerCase());
		S.setCity(S.getCity().toLowerCase());
		
		Integer id =  studentDao.saveStudent(S);
		
		return id;
		
	}

	@Override
	public Student fetchStudentById(Integer id) 
	{
		
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		
		Student s =  dao.findStudentById(id);
		
		return s;
		
	}

	@Override
	public List<Student> fetchStudentByName(String name) 
	{
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = dao.findStudentByName(name.toLowerCase());
		return studentList;
		
	
		/*
		 	
		 	return StudentDaoFactory.getStudentDaoInstance().findStudentByName(name.toLowerCase())
		 
		 */
		
	}
	
	
	@Override
	public List<Student> fetchStudentByCity(String city) 
	{
	
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = dao.findStudentByCity(city.toLowerCase());
		return studentList;
	}
	
	@Override
	public List<Student> fetchAllStudent() 
	{
	
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = dao.findAllStudent();
		return studentList;
	}
	
	@Override
	public boolean modifyStudent(Integer id)
	{
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		
		Student s = dao.findStudentById(id);  // rno :3 name:sachin V dhane per:60 city:pune
		
		if(s == null)
		{
			return false;
		}
		else
		{	
			Scanner sc = new Scanner(System.in);
			
			String updatedName="";
			
			while(true)
			{
				System.out.print("[ Old Name : " + s.getName() +"] Enter New Name : ");
				updatedName = sc.nextLine().toLowerCase();
			
				if(updatedName.isBlank()) 
				{
					System.out.println("*** Name should not be blank ! ");
					continue;
				}
				else
					break;
			}
			
			System.out.print("[ Old City  : " + s.getCity() + "] Enter New City :");
			String updatedCity = sc.nextLine().toLowerCase();
			
			System.out.print("[ Percentage: "+ s.getPer() + "] Enter New Percentage : ");
			double updatedPer = sc.nextDouble();
			
			s.setName(updatedName);
			s.setCity(updatedCity);
			s.setPer(updatedPer);
			
			boolean status = dao.updateStudent(s);
					
			return status;
		}
	}
	
	
	@Override
	public boolean removeStudent(Integer id)
	{
		StudentDao dao = StudentDaoFactory.getStudentDaoInstance();
		
		Student s = dao.findStudentById(id);  // rno :3 name:sachin V dhane per:60 city:pune
		
		if(s == null)
		{
			return false;
		}
		else
		{	
			boolean status = dao.deleteStudent(s);
			return status;
		}
	}
}









