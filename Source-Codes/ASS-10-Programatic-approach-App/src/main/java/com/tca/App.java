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
        		
        		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3300/hfb03");
    		 	configuration.setProperty("hibernate.connection.user", "root");
    		 	configuration.setProperty("hibernate.connection.password", "root");
    		 	
    		 	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    		 	configuration.setProperty("hibernate.show_sql", "true");
    		 	configuration.setProperty("hibernate.format", "false");
    		 	configuration.setProperty("hibernate.hbm2ddl.auto", "create");
    		 	        		
        		configuration.addResource("Student.hbm.xml");
        		
        		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		txn = session.beginTransaction();
        	        		
        		Student student = new Student();
        		student.setRno(222);
        		student.setName("Sachin");
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
