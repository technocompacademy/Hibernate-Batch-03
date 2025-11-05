package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Address;
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
            
        		Address address = new Address();
        		address.setCity("Pune");
        		address.setState("Maharashtra");
        		address.setCountry("India");
        		
        		Student s =  new Student();
        		s.setRno(101);
        		s.setName("Sachin");
        		s.setPer(60.0);
        		s.setAddress(address);
        		
        		Student s2 = new Student();
        		s2.setRno(102);
        		s2.setName("Anuj");
        		s2.setPer(70.0);
        		s2.setAddress(address);
        		        		
        		session.persist(s);
        		session.persist(s2);
        		
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





























