package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainProduct {

	public void getMainProduct() throws SQLException {
		ConnectionTest connectionTest =new ConnectionTest();
		try {
			
			
			Connection  connection=connectionTest.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from product ");
             ResultSet rs=ps.executeQuery();
             System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
             System.out.printf("%-20s %-40s %-60s %-20s %-17s","ProductID","ProductName","ProductDiscription","ProductPrice","ProductQuantity");
             System.out.println();
             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.format("%-20s %-30s %-70s %-20d %-13d",rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5));
				System.out.println();
			}
			connection.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
