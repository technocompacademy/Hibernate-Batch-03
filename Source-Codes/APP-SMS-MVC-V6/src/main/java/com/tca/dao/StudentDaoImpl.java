package com.tca.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.Student;
import com.tca.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao 
{

	@Override
	public Integer saveStudent(Student student) 
	{
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction=null;
		
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			//Integer id = (Integer) session.save(student);
			
			session.persist(student);
			Integer id = (Integer) session.getIdentifier(student);
			
			transaction.commit();
			return id;
		}
		catch(Exception e)
		{
			transaction.rollback();
			return null;
		}
		finally
		{
			session.close();
		}
		
	}

}
