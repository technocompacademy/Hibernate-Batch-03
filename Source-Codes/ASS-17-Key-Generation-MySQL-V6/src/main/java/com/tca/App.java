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
        Transaction txn=null;  
        
        try
        {
        		configuration = new Configuration();
        		configuration.configure(); 
        		     		
        		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	        		
        		Student student = new Student();   // ob[null, "AAA", 70.0] --> 1,"AAA", 70
        		student.setName("BBB");
        		student.setPer(80.0);
        	        		
        		Integer id = (Integer) session.save(student);
        		System.out.println("Student Saved with Roll Number :" + id);
        		
        		txn.commit();  
        		
        		
        		
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





























