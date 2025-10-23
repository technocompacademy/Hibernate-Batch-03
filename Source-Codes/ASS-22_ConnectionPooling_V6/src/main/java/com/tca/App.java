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
        		
        		txn = session.beginTransaction();
        	        		
        		Student student = new Student();
        		student.setRno(101);
        		student.setName("Sachin");
        		student.setPer(90);
        		
        		session.persist(student);
        		Integer rno = (Integer) session.getIdentifier(student);
        		
        		System.out.println("Record is Saved for Roll Number : " + rno);
        		
        		
        		        		
        		txn.commit();  
        		
        		
        		
        		System.out.println("Record is Saved Succesfully !!!");
        		
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





























