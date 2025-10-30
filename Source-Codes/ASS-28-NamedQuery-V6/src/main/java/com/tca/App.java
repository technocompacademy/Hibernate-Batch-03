package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
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
        		Query<Student> query = session.createNamedQuery("GET_ALL_INFO", Student.class);
        		
        		List<Student> L = query.list();
        		
        		for(Student s : L)
        		{
        			System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() +" " + s.getCity());
        		}
   */
        		
 /*       		
        		Query<Student> query = session.createNamedQuery("GET_CITYWISE", Student.class);
        		query.setParameter("abc", "PUNE");
        		
        		List<Student> L = query.list();
        		
        		for(Student s : L)
        		{
        			System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() +" " + s.getCity());
        		}
*/        		
 
/*
        		MutationQuery query = session.createNamedMutationQuery("MODIFY_STUDENT_CITY");
        		query.setParameter("ncity","POONA");
        		query.setParameter("ocity", "PUNE");
        		
        		int rowCount = query.executeUpdate();
        		
        		System.out.println("No. of Records Modified : " +  rowCount);
*/
        		
        		MutationQuery query = session.createNamedMutationQuery("REMOVE_STUDENT");
        		query.setParameter("rollnumber", 108);
        		int rowCount = query.executeUpdate();
        		System.out.println("No. of Records Deleted : " +  rowCount);
        		
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





























