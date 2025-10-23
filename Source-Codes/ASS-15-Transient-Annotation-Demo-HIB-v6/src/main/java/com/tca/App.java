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
        		
        		// configuration.addAnnotatedClass(Student.class); // used to provide Entity class
        														  // When mapping info is absent in
        		                                                  // hibernate.cfg.xml
        		
        		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	 /*       		
        		Student student = new Student();
        		student.setRno(102);
        		student.setName("ZZZ");
        		student.setPer(60.0);
        		student.setAge(22);
        		
        		session.persist(student);
        		Integer rno = (Integer) session.getIdentifier(student);
        		
        		System.out.println("Record is Saved for Roll Number : " + rno);
        		
        		//Integer rno = (Integer) session.save(student);
        		//System.out.println("Record is Saved for Roll Number : " + rno);
        	*/
        		
        		Student student = session.get(Student.class, 102); // rno:102, name:zzz per:60 age:null
        		System.out.println(student);
        		
        		
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





























