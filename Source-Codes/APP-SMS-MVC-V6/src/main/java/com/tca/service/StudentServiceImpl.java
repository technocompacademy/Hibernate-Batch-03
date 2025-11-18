package com.tca.service;

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

}
