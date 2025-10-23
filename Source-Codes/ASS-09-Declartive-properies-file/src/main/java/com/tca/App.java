package com.tca;

import java.io.FileInputStream;
import java.util.Properties;

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
        		  		
        	     		
        		FileInputStream fis = new FileInputStream("src/main/resources/tca.properties");
        		
        		Properties prop = new Properties();
        		
        		prop.load(fis);
        		
        		configuration.setProperties(prop);
        		
        		configuration.addResource("Student.hbm.xml");
        		
        		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	        		
        		Student student = new Student();
        		student.setRno(101);
        		student.setName("AAAAA");
        		student.setPer(60);
        		
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
