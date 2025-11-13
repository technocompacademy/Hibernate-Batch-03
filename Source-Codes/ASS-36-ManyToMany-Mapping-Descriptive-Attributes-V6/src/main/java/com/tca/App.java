package com.tca;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;


public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sf=null;
        Session session=null;
        Transaction txn=null;  // DML Queries - insert , delete, Update
        
        try
        {
        		configuration = new Configuration();
        		configuration.configure();             // hibernate.cfg.xml
        		       		
        		sf = configuration.buildSessionFactory();
        	  	
        		session = sf.openSession();	
        		txn = session.beginTransaction();
  /*      		
        		// I want to assign course-111 to Student-101 
        		
        		Student s = new Student();
        		s.setRno(101);
        		s.setName("AAA");
        		
        		Course c = new Course();
        		c.setCid(111);
        		c.setCname("Core Java");
        		     		
        		
        		StudentCourse sc = new StudentCourse();
        		sc.setId(1);
        		sc.setStudent(s);
        		sc.setCourse(c);
        		sc.setRegdate(LocalDate.now());
        		
        		session.persist(sc);
 */       		
        		 // I want to assign Course-222 to Student-101 
/*      		
        		Student s = session.get(Student.class, 101);
        		
        		Course c = new Course();
        		c.setCid(222);
        		c.setCname("Advacne Java");
        		
        		StudentCourse sc = new StudentCourse();
        		sc.setId(2);
        		sc.setStudent(s);
        		sc.setCourse(c);
        		sc.setRegdate( LocalDate.of(2025, 5, 10)  );
        		
        		session.persist(sc);
*/        	
/*        		
        		 // Student-102 has taken admisson but dont have any course yet.
        		
        		 Student S= new Student(); 
        	     S.setRno(102); 
        	     S.setName("BBB"); 
        	     session.persist(S);
*/
 
/*        		
        		// Launching course-333 Hibernate but not have admission yet
        		Course C = new Course(); 
        	    C.setCid(333); 
        	    C.setCname("Hibernate"); 
        	    session.persist(C);
*/
 /*       		
        		// Student-102 has taken admission for Course-111 Core java 
        	    
        		Student s = session.get(Student.class, 102);
        		Course c = session.get(Course.class, 111);
        		
        		StudentCourse sc = new StudentCourse();
        		sc.setId(3);
        		sc.setStudent(s);
        		sc.setCourse(c);
        		sc.setRegdate(LocalDate.now());
        		session.persist(sc);
*/

/*
        		// Student-103 has taken admission for Course-333 Hibernae 
        	      
        		  		Student S = new Student(); 
        		        S.setRno(103); 
        		        S.setName("CCC"); 
        		          
        		       StudentCourse SC= new StudentCourse(); 
        		       SC.setId(4); 
        		       SC.setStudent(S);
        		       
        		       SC.setCourse( session.get(Course.class, 333)  ); 
        		       SC.setRegdate(LocalDate.now()); 
        		       session.persist(SC); 
*/        		
        		 /******************* FETCHING LOGIC *************************/
/*        		
        		 // I want see courses joined by Student-101
        		
        		Student s = session.get(Student.class, 101);
        		
        		System.out.println("Student Roll Number : " + s.getRno());
        		System.out.println("Student Name        : " + s.getName());
        		
        		List<StudentCourse> L = s.getRegs();
        		System.out.println("****** Courses Information *********");
        		
        		for( StudentCourse sc : L)
        		{
        			Course c = sc.getCourse();
        			
        			System.out.println("Course ID         : " +  c.getCid());
        			System.out.println("Course Name       : " +  c.getCname());
        			System.out.println("Registration Date : " + sc.getRegdate());
        			System.out.println("-------------------------------------------");
        		}
 */       		

/*        		
        	    // I want to list of students who has taken admision for course-111  on which date 
        		   
        		   Course C = session.get(Course.class, 111); 
        		 
        		   System.out.println("********Course Information ************"); 
        		   System.out.println("Course ID   : " +  C.getCid()); 
        		   System.out.println("Course Name : " + C.getCname()); 
        		   
        		    System.out.println("******** Student Information **********"); 
        		   
        		        List<StudentCourse> L= C.getRegs(); 
        		         
        		   for(StudentCourse SC : L) 
        		   { 
        		          Student S = SC.getStudent(); 
        		          
        		          System.out.println("Roll Number    : " + S.getRno()); 
        		          System.out.println("Name           : " + S.getName()); 
        		          System.out.println("Registration Date :" + SC.getRegdate()); 
        		          System.out.println(); 
        		    } 
*/
        		
        		// Find Student-Course Information whose registration take place on  13th Nov, 2025 
        		
        		LocalDate d = LocalDate.of(2025, 11, 13);
        		
        		String hql = "FROM StudentCourse SC WHERE SC.regdate=:udate";
        		
        		Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
        		query.setParameter("udate", d);
        		
        		List<StudentCourse> L = query.getResultList();
        		
        		for(StudentCourse SC : L)
        		{
        			Student S = SC.getStudent();
        			Course C = SC.getCourse();
        			
        			System.out.println("Student " + S.getName() +" has registered for " + C.getCname() +" on Date:"+ SC.getRegdate());
        		}
        		
        		txn.commit();
        		
        		System.out.println("Work is done !!!");
        		
        		
        }
        catch(Exception e)
        {	
        		try
        		{
        			txn.rollback();
        			e.printStackTrace();
        		}
        		catch(Exception e2)
        		{
        			e2.printStackTrace();
        		}
        }
        finally
        {
        		try
        		{
        			session.close();
        			sf.close(); 
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        }
        
        
       
        
                   
    }
}





























