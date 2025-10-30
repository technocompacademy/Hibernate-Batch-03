package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tca.entities.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
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
        		// cq  --> SELECT * FROM student
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder(); 
        		
        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		
        		Root<Student> root = cq.from(Student.class);
        		
        		cq.select(root);
        		
        		Query<Student> query =session.createQuery(cq);
        		
        		List<Student> L = query.list(); // print * from student
        		
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
        		// select * from student where per >= 70 and per<=90
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder(); 
        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		Root<Student> root = cq.from(Student.class);
        		
        		Predicate p1 = cb.greaterThanOrEqualTo( root.get("per") , 70.0);
        		Predicate p2 = cb.lessThanOrEqualTo(root.get("per"), 90.0);
        		        		
        		
        		cq.select(root).where(cb.and(p1,p2));
        		
        		Query<Student> query =session.createQuery(cq);
        		
        		List<Student> L = query.list();
        		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
*/

 /*

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

*/
 /*       		
        		// Select * from student where city like 'P%';
        		//cq  --> 
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		
        		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        		Root<Student> root = cq.from(Student.class);
        		
        		cq.select(root)
        		  .where(cb.like(root.get("city"), "P%"));
        		
        		//Query<Student> query = session.createQuery(cq);
        		
        		//List<Student> L = query.list();
        		
        		
        		List<Student> L = session.createQuery(cq)
        								.list();
              		
        		for(Student S : L)
        		{
        			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPer() + " " + S.getCity());
        		}
*/
 
/*        		
        		// Select max(per) from student;
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		
        		CriteriaQuery<Double> cq =  cb.createQuery(Double.class);
        		Root<Student> root = cq.from(Student.class);
        		
        		cq.select(cb.max(root.get("per")));
        		
        		
        		Query<Double> query = session.createQuery(cq);
        		
        		Double ans = query.getSingleResult();
        		
        		System.out.println("Maximum Percentage : " +  ans);
*/        		

/*
        		// Select city, count(*) from student group by city having count(*)>=2;
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        		
        		Root<Student> root = cq.from(Student.class);
        		
        		Expression<Long> exp = cb.count(root);
        		        		
        		cq.multiselect(root.get("city"), exp );
        		cq.groupBy(root.get("city"));
        		cq.having(cb.ge(exp, 1));
        		
        		
        		Query<Object[]> query = session.createQuery(cq);
        		
        		List<Object[]> list = query.getResultList();
        		
        		for(Object[] row : list)
        		{
        			System.out.println(row[0] + " -->" + row[1]);
        		}
*/
 
 /*	
        		// Above code Using Tuple
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		CriteriaQuery<Tuple> cq = cb.createTupleQuery(); 

        		Root<Student> root = cq.from(Student.class);

        		// Define aggregate expression
        		Expression<Long> exp = cb.count(root);

        		// Select both columns with aliases
        		cq.multiselect(
        		    root.get("city").alias("city"),
        		    exp.alias("count")
        		);

        		// Group and Having clause
        		cq.groupBy(root.get("city"));
        		cq.having(cb.ge(exp, 1));

        		// Execute query
        		Query<Tuple> query = session.createQuery(cq);
        		List<Tuple> list = query.getResultList();

        		// Fetch results using aliases
        		for (Tuple tuple : list) 
        		{
        		    String city = tuple.get("city", String.class);
        		    Long count = tuple.get("count", Long.class);

        		    System.out.println(city + " --> " + count);
        		}
*/
 /*       		
        		// cu ---> UPDATE Student set per=99 where rno=108
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		CriteriaUpdate<Student>  cu = cb.createCriteriaUpdate(Student.class);
        		
        		Root<Student> root = cu.from(Student.class);
        		
        		cu.set("per", 99.0)
        		  .where(cb.equal(root.get("rno"),108));
        		
        		MutationQuery query = session.createMutationQuery(cu);
        		int rowcnt = query.executeUpdate();
        		System.out.println("No. of Rows Modified :" +  rowcnt);
*/    
  

        		// DELETE FROM student where city=HYDRABAD;
        		
        		CriteriaBuilder cb = session.getCriteriaBuilder();
        		CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);
        		
        		Root<Student> root = cd.from(Student.class);
        		
        		cd.where(cb.equal(root.get("city"), "HYDRABAD"));
        		
        		MutationQuery query = session.createMutationQuery(cd);
        		int rowcnt = query.executeUpdate();
        		System.out.println("No. of Rows Deleted :" +  rowcnt);
       		
        		
        		
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





























