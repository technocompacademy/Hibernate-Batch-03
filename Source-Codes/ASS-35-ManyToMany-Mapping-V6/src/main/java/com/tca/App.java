package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Course;
import com.tca.entities.Student;


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
        		Course c1 = new Course();
        		c1.setCid(111);
        		c1.setCname("Core Java");
        		
        		Course c2 = new Course();
        		c2.setCid(222);
        		c2.setCname("Advance Java");
        		
        		Student s =  new Student();
        		s.setRno(101);
        		s.setName("AAA");
        		s.setCourses( Arrays.asList(c1,c2));
        		
        		session.persist(s);
*/
   
/*        		
        		Course c =  session.get(Course.class, 111);
        		
        		Student s = new Student();
        		s.setRno(102);
        		s.setName("BBB");
        		s.setCourses(Arrays.asList(c));
        		
        		session.persist(s);
*/

/*        		
        		Course c = new Course();
        		c.setCid(333);
        		c.setCname("Hibernate");
        		session.persist(c);
*/        	
 
/*      
        		Course c = session.get(Course.class, 333);
        		
        		Student s = new Student();
        		s.setRno(103);
        		s.setName("CCC");
        		s.setCourses(Arrays.asList(c));
        		session.persist(s);
*/
 
/*        		
        		Student s = session.get(Student.class, 101);
        		System.out.println("Roll Number : " +  s.getRno());
        		System.out.println("Name        : " +  s.getName());
        		
        		List<Course> L = s.getCourses();
        		
        		System.out.println("Courses Information : ");
        		
        		for(Course c :  L)
        		{
        			System.out.println("Course ID   : " +  c.getCid());
        			System.out.println("Course Name : " + c.getCname());
        			System.out.println();
        		}
*/        
        		
        		   Course c= session.get(Course.class, 111); 
        	              	        
        	       System.out.println("Course ID   :" + c.getCid()); 
        	       System.out.println("Course Name :" + c.getCname()); 
        	        
        	       System.out.println("-----------------------------------"); 
        	       System.out.println("Student Information "); 
        	       
        	       List<Student> students = c.getStudents(); 
        	        
        	       for(Student s :  students) 
        	       { 
        	        System.out.println("Roll Number : " + s.getRno()); 
        	        System.out.println("Name        : " + s.getName()); 
        	        System.out.println(); 
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





























