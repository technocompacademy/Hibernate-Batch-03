package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        	/*	
        		txn = session.beginTransaction();
        	    
        		Student s1 = (Student)session.get(Student.class, 101);
        		
        		Student s2 = (Student)session.get(Student.class, 101);
        		
        		System.out.println(s1);
        		System.out.println(s2);
        		
        		System.out.println("Name : " + s1.getName());
        		System.out.println("Name : " + s2.getName());
        		        		
        		txn.commit();  
        	*/
        	
       /*
        		// Case - Each Session object has its own cache mememory
        		// Therfore same student object received using 2 database Interactions.
        		// Cache of session1 and Cache of session2 will have same student data but with different references.
        		
        		
        		Session session1 = sf.openSession();
        		Session session2 = sf.openSession();
        		
        		Student s1 = (Student)session1.get(Student.class, 101);
        		Student s2 = (Student)session2.get(Student.class, 101);
        		
        		System.out.println(s1);
        		System.out.println(s2);
        	*/	
      
      /*  		
        		// Sir Suppose hibernate has cached some objets And I want remove it from cache.
        		// Solution : evict()
        		
        		txn = session.beginTransaction();
        		
        		Student std = new Student();
        		std.setRno(101);
        		std.setName("Sachin");
        		std.setPer(90);
        	
        		session.persist(std);
        		
        		System.out.println("REF : "+std);
        		
        		//Student s2 = session.get(Student.class, 101);
        		//System.out.println(std);
        		//System.out.println(s2);
        		
        		session.evict(std);
        		
        		txn.commit();
        */
        		// merge()
        		
        		session = sf.openSession();
    			txn = session.beginTransaction();
    			
    			Student S = session.get(Student.class , 101); 
    			
    			System.out.println(S);
    			
    			session.evict(S);
    			//session.merge(S);  // DB interaction happen once again for Student 101
    			
    			session.update(S);
    			System.out.println(S);
        		
        		txn.commit();
        		System.out.println("Work is done !!!");
        		
        }
        catch(Exception e)
        {	
        		txn.rollback();
        		e.printStackTrace();
        }
        finally
        {
        		session.close();
        		sf.close();   // jdbc con.close()
        }
        
        
                   
    }
}





























