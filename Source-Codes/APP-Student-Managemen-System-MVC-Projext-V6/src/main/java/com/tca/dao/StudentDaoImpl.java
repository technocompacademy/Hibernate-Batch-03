package com.tca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

	@Override
	public Student findStudentById(Integer id) 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
			
		
		try(Session session = sf.openSession();)
		{
			Student s = session.get(Student.class, id);
			return s;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Student> findStudentByName(String name)  // sachin 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
				
		try(Session session  = sf.openSession();)
		{
			String hql = "FROM Student WHERE name LIKE '%"+name+"%'";                                                                          
			Query<Student> query = session.createQuery(hql, Student.class);
			
			List<Student> studentsList = query.getResultList();
			return studentsList;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Student> findStudentByCity(String city)  // sachin 
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
				
		try(Session session  = sf.openSession();)
		{
			String hql = "FROM Student WHERE city LIKE '%"+city+"%'";                                                                          
			Query<Student> query = session.createQuery(hql, Student.class);
			
			List<Student> studentsList = query.getResultList();
			return studentsList;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	@Override
	public List<Student> findAllStudent()   
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
				
		try(Session session  = sf.openSession();)
		{
			String hql = "FROM Student";                                                                          
			Query<Student> query = session.createQuery(hql, Student.class);
			
			List<Student> studentsList = query.getResultList();
			return studentsList;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateStudent(Student student)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =null;
		Transaction transaction = null;
		
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.merge(student);
			
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}
	
	
	@Override
	public boolean deleteStudent(Student student)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =null;
		Transaction transaction = null;
		
		try
		{
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.remove(student);
			
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}
}














