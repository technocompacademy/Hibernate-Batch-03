package com.tca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentUtil 
{
	public static boolean save(Student s)  throws SQLException, ClassNotFoundException
	{
		Connection con=null;
		PreparedStatement ps = null;
		
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL    = "jdbc:mysql://localhost:3300/hfb03";
		final String DB_USER   = "root";
		final String DB_PWD    = "root";
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
						
			ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			
			ps.setInt(1, s.getRno());
			ps.setString(2, s.getName());
			ps.setDouble(3,s.getPer());
					
			int val = ps.executeUpdate();  // val=0
						
			if(val==1)
			{
				return true;
			}
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static List<Student> fetchAllStudents() throws ClassNotFoundException, SQLException
	{
		List<Student> L = new ArrayList<>(); // [101]
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL    = "jdbc:mysql://localhost:3300/hfb03";
		final String DB_USER   = "root";
		final String DB_PWD    = "root";
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				// Preparing Student Object from Record
				int rno = rs.getInt(1);
				String name =rs.getString(2);
				double per = rs.getDouble(3);
				
				Student s = new Student();   
				s.setRno(rno);
				s.setName(name);
				s.setPer(per);
				
				L.add(s);  // Adding Student Object Into the List L
			}
			
		}
		finally
		{
			con.close();
		}
		
		return L;
		
	}
	
}






