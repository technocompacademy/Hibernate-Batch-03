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
        		configuration.configure(); // load & parse XML Files
        		        			
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	        		
        		Student student = new Student();  // rno=null name=null per=null
        		
        		
        		
        		session.save(student);
        		        		
        		txn.commit();  // Whatever DB Operaotion performed should be get persisted permenantly
        		
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
