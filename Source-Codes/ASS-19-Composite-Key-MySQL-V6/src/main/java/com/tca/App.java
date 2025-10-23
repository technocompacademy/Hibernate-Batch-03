package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.StudentCompositeKey;


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
        	    
        		/*
        		 * Test Code - Insert a Record
        		 */
   /*     		
        		StudentCompositeKey ck = new StudentCompositeKey();
        		ck.setFname("sachin");
        		ck.setLname("tendulkar");
        		
        		Student s = new Student();
        		s.setId(ck);
        		s.setCity("Pune");
        		
        		session.persist(s);
        		
        		System.out.println("Record is Saved Successfully !!!");		
   */     		     		
        		
        		
        		
        		/*
        		 *  Test Code - Fetch a Record
        		 *  Student s = (Student) sesson.get(Student.class, 101);
        		 */
        		
        		StudentCompositeKey key = new StudentCompositeKey();
        		key.setFname("sachin");
        		key.setLname("dhane");
        		
        		Student s = (Student) session.get(Student.class, key); // s -> [ ck(fname, lname), city]
        		if(s==null)
        		{
        			System.out.println("Record Not Found !!");
        		}
        		else
        		{
        			System.out.println("Record is Found !!");
        	        			       			
        			System.out.println("First Name : " + s.getId().getFname());
        			System.out.println("Last  Name : " + s.getId().getLname());
        			System.out.println("City  Name : " + s.getCity());
        			
        		}
        		
        		
        		        		
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





























