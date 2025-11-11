package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Car;
import com.tca.entities.Engine;



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
        		Engine e = new Engine();
        		e.setEid(1234);
        		e.setType("Pertol");
        		e.setSize("1200 CC");
        		
        		
        		Car c = new Car();
        		c.setCno("MH14AB1234");
        		c.setCname("Swift");
        		c.setEngine(e);
        		
        		session.persist(c);
*/
 
/*        		
        		// Unique Key constraint violation
        		Engine e = session.get(Engine.class, 1234);
        		
        		Car c = new Car();
        		c.setCno("MH12CD9876");
        		c.setCname("Alto");
        		c.setEngine(e);
        		
        		session.persist(c);
*/
 /*       		
        		Car c = session.get(Car.class, "MH14AB1234");
        		        		
        		System.out.println("Car No      : " +  c.getCno());
        		System.out.println("Car Name    : " +  c.getCname());
        		System.out.println("Engine Id   : " +  c.getEngine().getEid() );
        		System.out.println("Engine Type : " +  c.getEngine().getType() );
        		System.out.println("Engine Size : " +  c.getEngine().getSize());
*/
        		
        		Engine e = session.get(Engine.class, 1234);
        		
        		System.out.println("Car No      : " +  e.getCar().getCno());
        		System.out.println("Car Name    : " +  e.getCar().getCname());
        		System.out.println("Engine Id   : " +  e.getEid() );
        		System.out.println("Engine Type : " +  e.getType() );
        		System.out.println("Engine Size : " +  e.getSize());
        		
        		txn.commit();
        		
        		System.out.println("Work is done !!!");
        		
        		
        }
        catch(Exception e)
        {	
        		try
        		{
        			txn.rollback();
        			e.printStackTrace();
        		}
        		catch(Exception e2)
        		{
        			e2.printStackTrace();
        		}
        }
        finally
        {
        		try
        		{
        			session.close();
        			sf.close(); 
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        }
        
        
       
        
                   
    }
}





























