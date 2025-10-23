package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tca.entities.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;

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
        		 Note 
        		    ---- 
        		     --> In Hibernate 5.x+, the SQLQuery interface is deprecated,  
        		         and the method session.createSQLQuery(...) 
        		     --> It has been replaced with NativeQuery. 
        		*/
        	/*	
        		NativeQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
        	*/
    /*    		
        		NativeQuery<Object[]> query = session.createNativeQuery("select sper,sname,scity from student",Object[].class);
        		
        		List<Object[]> L = query.list();
        		
        		for(Object[] ob : L)
        		{
        			for(Object data : ob)
        			{
        				System.out.print(data +" ");
        			}
        			System.out.println();
        			
        			//System.out.println(ob[0] + " " + ob[1]);
        		}
        		
      */  	
        
        		
        		
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





























