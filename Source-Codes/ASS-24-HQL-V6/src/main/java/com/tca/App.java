package com.tca;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        		// Test Code - Displaying All records with All columns
        
        		Query<Student> query = session.createQuery("FROM Student",Student.class);  // Select * from student;
        		
        		List<Student> list= query.list(); // Query is fired Select * from student;
        	 
        		for(Student s : list)
        		{
        			System.out.println("Roll Number : " + s.getRno());
        			System.out.println("Name        : " + s.getName());
        			System.out.println("Percentage  : " + s.getPer());
        			System.out.println("City        : " + s.getCity());
        			System.out.println("-----------------------------------------");
        		}
        	
        	*/
        	
        		
        	/*
        		// Test Code - Displaying All records with SPECIFIC columns
        		
        		Query<Object[]> query = session.createQuery("SELECT rno,name,per,city FROM Student", Object[].class);  		
        		
        		List<Object[]> list= query.getResultList();
        		
        		for(Object[] ob : list)
        		{
        			
        			for(Object data : ob)
        			{
        				System.out.print(data +" ");
        			}
        			System.out.println();
        		}
        	*/	
        	
        /*		
        		Query<Object[]> query = session.createQuery("SELECT rno,name,per,per+5 FROM Student", Object[].class);  		
        		
        		List<Object[]> list= query.getResultList();
        		
        		for(Object[] ob : list)
        		{
        			
        			for(Object data : ob)
        			{
        				System.out.print(data +" ");
        			}
        			System.out.println();
        		}
        	*/	
              	
     /*   		
        	// Test Code - Aggregate Function count(), max(), min(), sum(), avg()
        		
        		Query<Long> q1 = session.createQuery("SELECT count(*) FROM Student", Long.class );        		
        		
        		Long n = q1.getSingleResult();
        		System.out.println("No. of Records : " + n);
        		
        		Query<Double> q2 = session.createQuery("SELECT max(per) FROM Student", Double.class);
        		Double maxPer = q2.getSingleResult();
        		System.out.println("Maximum Percentage : " + maxPer);
      */  		
       
      /*  		
        		// Test Code - GROUP BY
        		
        		Query<Object[]> query = session.createQuery("SELECT city, count(*) FROM Student GROUP BY city HAVING count(*)>=2", Object[].class);  		
        		
        		List<Object[]> list= query.getResultList();
        		
        		for(Object[] ob : list)
        		{
        			
        			String city = (String) ob[0];
        			Long   cnt  = (Long)   ob[1];
        			
        			System.out.println("CITY : " + city +" No of Admissions: "+ cnt);
        			
        			
        		
//        			for(Object data : ob)
//        			{
//        				System.out.print(data +" ");
//        			}
//        			
//        			System.out.println();
        		}
        		
       */
     
      /*
        // WHERE Clause
        		
        //	Query<Student> query = session.createQuery("FROM Student WHERE per>=70 AND per<=80",Student.class);
        
        	//	Query<Student> query = session.createQuery("FROM Student WHERE per BETWEEN 70 AND 80",Student.class);	
        	
        	//  Query<Student> query = session.createQuery("FROM Student WHERE city='PUNE' OR city='MUMBAI'",Student.class);
        	
        //	Query<Student> query = session.createQuery("FROM Student WHERE city LIKE 'P%' ",Student.class);
        	
        	//	Query<Student> query = session.createQuery("FROM Student WHERE per IS NOT NULL ",Student.class);
        		
        	List<Student> L = query.list();
        	
        	for(Student s : L)
    		{
    			System.out.println("Roll Number : " + s.getRno());
    			System.out.println("Name        : " + s.getName());
    			System.out.println("Percentage  : " + s.getPer());
    			System.out.println("City        : " + s.getCity());
    			System.out.println("-----------------------------------------");
    		}
        	
      */
     
     /* 
        		  	Topic : How to write a Dynamic SQL
        		  	
        		  	Solution:
        		  				1. Using Positonal paramter
        		  				2. Using Named Parameter
        		 		  				
      */
        		
 /*
        		// Dynamic SQL Using Positional Paramter
        		
        		Double d1 = 70.0;
        		Double d2 = 80.0;
        		
        		Query<Student> query = session.createQuery("FROM Student WHERE per>=?1 AND per<= ?2",Student.class);	
        		
        		query.setParameter(1, d1);
        		query.setParameter(2, d2);
        		
        		List<Student> L = query.list();
            	
            	for(Student s : L)
        		{
        			System.out.println("Roll Number : " + s.getRno());
        			System.out.println("Name        : " + s.getName());
        			System.out.println("Percentage  : " + s.getPer());
        			System.out.println("City        : " + s.getCity());
        			System.out.println("-----------------------------------------");
        		}
*/

/*
        		// Dynamic SQL Using Named Paramter
        		
        		Double d1 = 70.0;
        		Double d2 = 80.0;
        		
        		Query<Student> query = session.createQuery("FROM Student WHERE per>= :minper AND per<= :maxper",Student.class);	
        		
        		query.setParameter("minper", d1);
        		query.setParameter("maxper", d2);
        		
        		List<Student> L = query.list();
            	
            	for(Student s : L)
        		{
        			System.out.println("Roll Number : " + s.getRno());
        			System.out.println("Name        : " + s.getName());
        			System.out.println("Percentage  : " + s.getPer());
        			System.out.println("City        : " + s.getCity());
        			System.out.println("-----------------------------------------");
        		}
 */       		
     	/*	
        		// Update
        		
        		Query<?> query = session.createQuery("UPDATE Student SET per = per + :val WHERE city = :tempcity ");
        		query.setParameter("val", 5.0);
        		query.setParameter("tempcity", "MUMBAI");
        		
        		int rowCount = query.executeUpdate();
        		System.out.println("No. of Recrods Updated : " + rowCount);
        	*/	
 
/*
        		// DELETE
        		
        		Query<?> query = session.createQuery("DELETE FROM Student WHERE city = :tempcity ");
        		query.setParameter("tempcity", "MUMBAI");
        		
        		int rowCount = query.executeUpdate();
        		System.out.println("No. of Recrods Deleted : " + rowCount);
*/
        		
        /**************** PAGINATION ****************************/
        		
        		Scanner sc = new Scanner(System.in);
        		
        		Query<Student> query = session.createQuery("FROM Student", Student.class);
        		query.setMaxResults(3);  // We can fetch 3 records from Result Set
        		
        		            
        		for(int i=0;i<10; i = i+3)
        		{
        			query.setFirstResult(i);
        			
        			List<Student> L = query.list();
        			
        			for(Student s : L)
            		{
            			System.out.println("Roll Number : " + s.getRno());
            			System.out.println("Name        : " + s.getName());
            			System.out.println("Percentage  : " + s.getPer());
            			System.out.println("City        : " + s.getCity());
            			System.out.println("-----------------------------------------");
            		}
        			
        			System.out.println("Press Any key to Coninuer.....");
        			sc.next();
        		}
        		      		
        		
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





























