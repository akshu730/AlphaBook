package com.jdbc.day3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class SocialMedia 
{
	Scanner sc = new Scanner(System.in);
	HashMap<String,User> users;
	PreparedStatement ps = null;
	Connection conn = null;
	int count = 0;
	public void login()
	{
		System.out.println("*********WELCOME***********");
		System.out.println("Enter the email:");
		String email = sc.next();
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/media","root","root");
			try
			{
				PreparedStatement ps = conn.prepareStatement("select * from user where Email='"+email+"'");
				ResultSet rs = ps.executeQuery();
				while(rs.next()!=true)
				{
					System.out.println("Sorry you dont have account please first create it");
					Signup();
				}
			}catch(SQLException e)
			{
				System.out.println("Error in Prepared Statement");
			}
			
		}catch(SQLException e)
		{
			System.out.println("Connection problem");
		}
		do
		{
			
			System.out.println("Enter the password");
			String password = sc.next();
			try
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/media","root","root");
				
				try
				{
					PreparedStatement ps = conn.prepareStatement("select Password from user where email='"+email+"'");
					ResultSet rs = ps.executeQuery();
					rs.next();
					String pass = rs.getString(1);
					if(pass.equals(password))
					{
						int i=1;
						System.out.println("Logged in successfull");
						System.out.println();
						try
						{
							ps=conn.prepareStatement("select * from user where Email='"+email+"'");
						
						}catch(SQLException e)
						{
							System.out.println("Query problem");
						}
						try
						{
							rs = ps.executeQuery();	
							rs.next();
							
						}
						catch(SQLException aa)
						{
							aa.printStackTrace();
						}
					
						String name1 = rs.getString("FirstName");
						String name2 = rs.getString("LastName");
						System.out.println("*******WELCOME "+email+"***********");
						System.out.println("LOGIN TIME :"+LocalTime.now());
						System.out.println("-------------------------------------");
						System.out.println("FIRST NAME :"+name1);
						System.out.println("LAST NAME :"+name2);
						System.out.println("-------------------------------------");
						try
						{
							ps = conn.prepareStatement("select * from status where Email='"+email+"'");
							rs = ps.executeQuery();
						}catch(SQLException c)
						{
							c.printStackTrace();
						}
						while(rs.next())
						{
							System.out.println("OLD STATUS "+i+":"+rs.getString(2));
							System.out.println();
							System.out.println("DATE :"+rs.getString(3));
							System.out.println("----------------------------------");
							i++;
						}
						do
						{
							System.out.println("1. POST STATUS");
							System.out.println("2. LOGOUT");
							int ch = sc.nextInt();
							switch(ch)
							{
								case 1:
								{
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/media","root","root");
									ps =conn.prepareStatement("call insertpost(?,?,?,?)");
									System.out.println("Enter the status");
									String st = sc.next();
									ps.setString(1,email);
									ps.setString(2,st);
									ps.setDate(3,Date.valueOf(LocalDate.now()));
									ps.setTime(4,Time.valueOf(LocalTime.now()));
									ps.executeQuery();
								}break;
								case 2:
								{
									Driver.homePage();
								}break;
								default: System.out.println("Invalid choice");
							}
						}while(true);
						
					}
					else
					{
						count++;
					}
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}while(count<3);
	}
	
	public void Signup()
	{
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/media","root","root");
			try
			{
				ps = conn.prepareCall("call createUser(?,?,?,?,?,?,?)");
				
			}catch(SQLException e)
			{
				System.out.println("Error in Prepared Statement");
			}
			System.out.println("**********ALPHA BOOK************");
			System.out.println("Enter your firstName");
			String first_name = sc.next();
			System.out.println("Enter your LastName");
			String last_name = sc.next();
			System.out.println("Enter your gender ");
			String gender = sc.next();
			System.out.println("Enter the cno ");
			long pno = sc.nextLong();
			System.out.println("Enter dob ");
			String dob = sc.next();
			System.out.println("Enter the email ");
			String email = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, gender);
			ps.setLong(4, pno);
			ps.setString(5, dob);
			ps.setString(6, email);
			ps.setString(7, password);
			System.out.println("1.SUBMIT");
			System.out.println("2.CANCEL");
			if(sc.nextInt()==1)
			{
				ps.executeQuery();
			}
			else
			{
				System.out.println("Thank you");
				System.exit(0);
			}
			System.out.println("successfully signed up now please login");
			login();
			
		}catch(SQLException e)
		{
			System.out.println("Please enter different or unique email");
		}
	}
	
	public void Logout()
	{
		
	}
}
