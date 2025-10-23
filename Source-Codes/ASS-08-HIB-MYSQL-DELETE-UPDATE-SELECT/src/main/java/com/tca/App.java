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
        		configuration.configure(); 
        		
        		    		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	
        		
        		Student s = new Student();
        		s.setRno(202);
        		s.setName("BBBB");
        		s.setPer(15);
        		session.saveOrUpdate(s);
        		       				
        		
        		
        	/*
        		Student s = (Student) session.load(Student.class, 101);
        		
        		session.delete(s);
        	*/	
        		
        		
        		
       /*  TEST CODE for SELECT 
        		
        		Student s = (Student) session.load(Student.class, 101);  // S = 101 SD 99
        		
        		System.out.println("Rollnumber : " + s.getRno());
        		System.out.println("Name       : " +  s.getName());
        		System.out.println("Percentage : " + s.getPer() );
        		
       */ 	  		
        		
        	/*
        	 * sdas l adals
        	 * 
        	 * 
        	 */
        		
        		
        		
        		
        		
        		
        		
        	
  /*				TEST CODE for Updat SQL
   		
        		//s.setName("Sachin Dhane");
        		//s.setPer(50);
        		//session.update(s);  
        		
 */       		        		
        		txn.commit();  // Whatever DB Operaotion performed should be get persisted permenantly
        		
        		System.out.println("Record is upda Succesfully !!!");
        		
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
