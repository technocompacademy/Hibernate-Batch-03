package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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
        		// SELECT * FROM Student
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder(); 
        		
        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		Root<Student> root = cq.from(Student.class);
        		cq.select(root);
        		
        		Query<Student> query =session.createQuery(cq);
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
     */
        		
/*
        		// select * from student order by per desc 
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder(); 
        		        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		Root<Student> root = cq.from(Student.class);
        		cq.select(root).orderBy(cb.desc(root.get("per")));
        		
        		
        		Query<Student> query =session.createQuery(cq);
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
*/

/*
        		// select * from student where per>=70 and per<=90
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder(); 
        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		Root<Student> root = cq.from(Student.class);
        		
        		Predicate p1 = cb.greaterThanOrEqualTo(root.get("per") , 70.0);
        		Predicate p2 = cb.lessThanOrEqualTo(root.get("per"), 90.0);
        		
        		cq.select(root).where(cb.and(p1,p2));
        		
        		Query<Student> query =session.createQuery(cq);
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
*/
        		
        		// Specific Column - select name,city,per from student;
        		// Tuple (stud_name:AAA, city:PUNE, per:70), (BBB,BANGLORE,90)
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        		
        		Root<Student> root = cq.from(Student.class);
        		
        		cq.multiselect(root.get("name").alias("stud_name"), root.get("city").alias("city"), root.get("per").alias("per"));
        		
        		Query<Tuple> query = session.createQuery(cq);
        		
        		List<Tuple> result =query.getResultList();
        		
        		for(Tuple t : result)
        		{
        			System.out.println(t.get("stud_name") + " " + t.get("city") + " " + t.get("per") );
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





























