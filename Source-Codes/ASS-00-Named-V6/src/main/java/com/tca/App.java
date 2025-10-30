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
 			// Code  : @NamedQuery(name="GET_ALL_INFO",query="FROM Student")
 			
        		Query<Student> query = session.createNamedQuery("GET_ALL_INFO", Student.class);
    			List<Student> list = query.list();
    			
    			for(Student s : list)
    			{
    				System.out.println("Roll Number : " + s.getRno());
    				System.out.println("Name        : " + s.getName());
    				System.out.println("Percentage  : " + s.getPer());
    				System.out.println("City        : " + s.getCity());
    				System.out.println("---------------------------------------");
    			}
*/        		
 
/*        		
        		//@NamedQuery(name="GET_CITYWISE", query="FROM Student where city= :abc")
    			
        		Query<Student> query = session.createNamedQuery("GET_CITYWISE",Student.class);
   			query.setParameter("abc","PUNE");
   			List<Student> list = query.list(); 
   			
   			for(Student s : list)
   			{
   				System.out.println("Roll Number : " + s.getRno());
   				System.out.println("Name        : " + s.getName());
   				System.out.println("Percentage  : " + s.getPer());
   				System.out.println("City        : " + s.getCity());
   				System.out.println("---------------------------------------");
   			}
*/
 
/*        		
    			//@NamedQuery(name="MODIFY_STUDENT_CITY", query="UPDATE Student SET city=:newcity WHERE city=:oldcity")
    			
        		MutationQuery query = session.createNamedMutationQuery("MODIFY_STUDENT_CITY");
    			query.setParameter("newcity", "PUNE");
    			query.setParameter("oldcity", "POONA");
    			int cnt = query.executeUpdate();
    			System.out.println("No. of Records Updated :" +  cnt);
*/

/*	
        		//@NamedQuery(name="REMOVE_STUDENT", query="DELETE FROM Student WHERE rno =:rollnumber")

    			
        		MutationQuery query = session.createNamedMutationQuery("REMOVE_STUDENT");
    			query.setParameter("rollnumber", 102);
    			int cnt = query.executeUpdate();
    			System.out.println("No. of Records Deleted :" +  cnt);
        		txn.commit();
*/        		
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





























