package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sf=null;
        Session session=null;
        Transaction txn=null;  
        
        Configuration configuration2=null;
        SessionFactory sf2=null;
        Session session2=null;
        Transaction txn2=null;
        
        try
        {
        		configuration = new Configuration();
        		configuration.configure("mysql.cfg.xml"); // load & parse XML Files
        		
        		configuration2 = new Configuration();
        		configuration2.configure("pg.cfg.xml");
        		
        		
        		sf = configuration.buildSessionFactory();
        		sf2 = configuration2.buildSessionFactory();
        		
        	        		
        		session = sf.openSession();	
        		session2 =  sf2.openSession();
        		
        		txn = session.beginTransaction();
        		txn2 = session2.beginTransaction();
        	        		
        		Student student = new Student();
        		student.setRno(101);
        		student.setName("Sachin");
        		student.setPer(80.0);
        		
        		//Integer rno = (Integer) session.save(student);
        		           		
        		//session.persist(student);
        		        		
        		session.persist(student);
        		session2.persist(student);
        		
        		Teacher t =  new Teacher();
        		t.setTno(999);
        		t.setTname("XYZ");
        		t.setSalary(20000.0);
        		
        		session.save(t);
        		session2.save(t);
        		
        		
        		
        		
        		txn.commit();  // Whatever DB Operaotion performed should be get persisted permenantly
        		txn2.commit();
        		
        //		System.out.println("Record is Saved Succesfully for Rollnuber : " + rno);
        		
        		System.out.println("Record is Saved Succesfully for Rollnuber");
        }
        catch(Exception e)
        {	
        		txn.rollback();
        		txn2.rollback();
        		e.printStackTrace();
        }
        finally
        {
        		session.close();
        		session2.close();
        		sf.close();   // jdbc con.close()
        		sf2.close();
        }
        
        
                   
    }
}
