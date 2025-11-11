package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Department;
import com.tca.entities.Employee;



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
        		 // Insert department with 2 Employees 
        	        		
        		Department d = new Department();
        		d.setDid(111);
        		d.setDname("CS");
        		
        		Employee e1 =new Employee();
        		e1.setEid(101);
        		e1.setEname("AAA");
        		e1.setEsalary(10000.0);
        		e1.setDept(d);
        		
        		Employee e2 =new Employee();
        		e2.setEid(103);
        		e2.setEname("CCC");
        		e2.setEsalary(1200.0);
        		e2.setDept(d);
        		
        		//List<Employee> L = new ArrayList<>();
        		//L.add(e1);
        		//L.add(e2);
        		        		
        		List<Employee> L = Arrays.asList(e1,e2);
        		d.setEmps(L);
           		
        		session.persist(d);
*/
 
/*     		
        		// Adding only emp : 102 BBB 8000
        		
        		Employee e = new Employee();
        		e.setEid(102);
        		e.setEname("BBB");
        		e.setEsalary(8000.0);
        		session.persist(e);
        		
*/
  
/*        		
        		// Adding only department
        		Department d = new Department();
        		d.setDid(222);
        		d.setDname("Arts");
        		
        		session.persist(d);
*/

/*        		
        		Employee e = session.get(Employee.class, 102);
        		Department d = session.get(Department.class, 222);
        		e.setDept(d);
        		session.update(e);
*/    
 
/*	
        		Department d = new Department();
        		d.setDid(333);
        		d.setDname("IT");
        		
        		Employee e = new Employee();
        		e.setEid(104);
        		e.setEname("DDD");
        		e.setEsalary(5000.0);
        		e.setDept(d);
        		session.persist(e);
*/
   
/*        		
        		Department d = session.get(Department.class, 111); // d[111,cs, ref]
        		
        		System.out.println("Department Information :");
        		System.out.println("Depatement Id   : " + d.getDid());
        		System.out.println("Department Name : " +  d.getDname());
        		System.out.println("------Employe information-----------------");
        		
        		List<Employee> L =  d.getEmps();
        		
        		for(Employee e : L)
        		{
        			System.out.println("Emp Id    : " + e.getEid());
        			System.out.println("Emp Name  : " + e.getEname());
        			System.out.println("Emp Salry : " + e.getEsalary());
        			System.out.println("-------------------------------------------");
        		}
*/        	

/*
        		Employee e = session.get(Employee.class, 102); // e [102, BBB, 8000,null] 
        		
        		System.out.println("Emp Id    : " + e.getEid());
    			System.out.println("Emp Name  : " + e.getEname());
    			System.out.println("Emp Salry : " + e.getEsalary());
    			
    			Department d = e.getDept();
    			System.out.println("Depatement Id   : " + d.getDid());
        		System.out.println("Department Name : " +  d.getDname());
*/
        		
/*
        		Employee e = session.get(Employee.class, 102);
        		Department d = session.get(Department.class, 111);
        		e.setDept(d);
        		session.update(e);
*/
        		
        		Department d = session.get(Department.class, 111);
        		session.delete(d);
        		
        		
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





























