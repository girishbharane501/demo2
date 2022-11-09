package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Registration {
	String FirstName;
	String LastName;
	String EmailAddress;
	String MobileNo;
	String UserName;
	String pass_word;
	public void userRegistration() {
		System.out.println("Welcome to E-Commerse Shopping");
		ConnectionTest connectionTest=new ConnectionTest();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter First Name=");
		 String FirstName=scanner.next();
		 System.out.println("Enter Last Name=");
		 String LastName=scanner.next();
		 System.out.println("Enter Email Address=");
		 String EmailAddress= scanner.next();
		 System.out.println("Enter  Mobile no=");
		 String MobileNo=scanner.next();
		 System.out.println("Enter  User Name=");   
		 String UserName=scanner.next();
		 System.out.println("Enter Password=");   
		 String pass_word=scanner.next();
	
		try {
			Connection  connection=connectionTest.getConnection();
		PreparedStatement	ps=connection.prepareStatement("insert into registration(FirstName, LastName, EmailAddress, MobileNo, UserName, pass_word) values (?,?,?,?,?,?)");
		ps.setString(1, FirstName);
		ps.setString(2, LastName);
		ps.setString(3,EmailAddress);
		ps.setString(4, MobileNo);
		ps.setString(5,UserName);
		ps.setString(6, pass_word);
		int j=ps.executeUpdate();
		System.out.println("Registered Succesfully"+j);
		
		connection.close();
		ps.close();
		
		}
		  
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getRegisteredList() {
		ConnectionTest connectionTest =new ConnectionTest();
		try {
			Connection  connection=connectionTest.getConnection();
			PreparedStatement ps2=connection.prepareStatement("select * from registration ");
			  ResultSet rs2=ps2.executeQuery();
			  System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	             System.out.printf("%-20s %-40s %-60s %-20s %-17s","userId","FirstName", "LastName", "EmailAddress"," MobileNo");
	             System.out.println();
	             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				while (rs2.next()) {
					System.out.format("%-20d %-30s %-70s %-20s %-13s",rs2.getInt(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5));
					System.out.println();
				}
				connection.close();
				ps2.close();
				rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
