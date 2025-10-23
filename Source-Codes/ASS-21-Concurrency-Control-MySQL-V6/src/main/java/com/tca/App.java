package com.tca;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Account;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration=null;
        SessionFactory sf=null;
        Session session=null;
        Transaction txn=null;  
        
        Integer senderAccNo   = 101;
        Integer receiverAccNo = 102;
        Float   amount        = 500.0f;
        
        
        try
        {
        		configuration = new Configuration();
        		configuration.configure(); 
        	       		
        		sf = configuration.buildSessionFactory();
        	        		
        		session = sf.openSession();	
        		
        		// Validating Senders and Receivers accounts
        		
        		Account senderOb = session.get(Account.class, senderAccNo, LockMode.PESSIMISTIC_WRITE); 
        		// 7000
        		
        		if(senderOb == null)
        		{
        			System.out.println("Invalid Sender's Account Number :" + senderAccNo);
        			return;
        		}
        		
        		
        		if(senderOb.getBalance()-amount < 500)
        		{
        			System.out.println("Insufficient Balance !!!");
        			return;
        		}
        		
        		
        		Account receiverOb = session.get(Account.class,receiverAccNo, LockMode.PESSIMISTIC_WRITE);
        		
        		if(receiverOb == null)
        		{
        			System.out.println("Invalid Receivers's Account Number :" + receiverAccNo);
        			return;
        		}
       		
        		
        		
        		txn = session.beginTransaction();
        		
        		System.out.println("Press Any key... ");
        		System.in.read();
        		
        	    
        		//Debit
        		senderOb.setBalance( senderOb.getBalance() - amount);
        		//session.update(senderOb);
        		
        		//credit
        		receiverOb.setBalance(receiverOb.getBalance()+amount);
        		//session.update(receiverOb);
        		        		
        		txn.commit();  
        		
        		System.out.println("Amount is Transfered Succesfully !!!");
        		System.out.println("Press Any key to exit... ");
        		System.in.read();
        		
        }
        catch(Exception e)
        {	
        		txn.rollback();
        		e.printStackTrace();
        		System.out.println("Failed to Transfer Amount Succesfully !!!");
        }
        finally
        {
        		session.close();
        		sf.close();  
        }
                    
    }
}





























