package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.tca.entities.Student;
import com.tca.util.StudentUtil;


public class AddStudent {

	public static void main(String[] args) 
	{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		try
		{
			System.out.print("Enter the Roll Number :");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name :");
			String name = br.readLine();
			
			System.out.print("Enter the Percentage :");
			double per = Double.parseDouble(br.readLine());
			
			
			Student ob = new Student();
			ob.setRno(rno);
			ob.setName(name);
			ob.setPer(per);
			
					
			if( StudentUtil.save(ob) )
			{
				System.out.println("Record is Saved Succesfully for Roll number :" + rno);
			}
			else
			{
				System.out.println("Failed to Save Record for Roll Number : " + rno);
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Failed to Save Record" );
			//e.printStackTrace();
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("Failed to Load Driver !!!");
			//ce.printStackTrace();
		}
		catch(IOException ie)
		{
			System.out.println("Failed to detect Input Detect input Device !!!");
			//ie.printStackTrace();
		}
		finally
		{
			// 6. close the connection.
			
			try 
			{
				System.out.println("***********Resources Closed******************");
				br.close();
			} 
			catch (Exception e) 
			{
				System.out.println("Failed to Close Connection !!!");
				//e.printStackTrace();
			}
		}

	}

}
