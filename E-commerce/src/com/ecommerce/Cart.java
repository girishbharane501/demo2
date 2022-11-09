package com.ecommerce;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cart {
	String product_1;
	String product_2;
	String product_3;
	String product_4;
	String product_5;

	public void addCart() {
		System.out.println("Buy product in product list");
		ConnectionTest connectionTest = new ConnectionTest();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select product to cart");
		String product_1 = scanner.nextLine();
		System.out.println("Select product to cart");
		String product_2 = scanner.nextLine();
		System.out.println("Select product to cart");
		String product_3 = scanner.nextLine();
		System.out.println("Select product to cart");
		String product_4 = scanner.nextLine();
		System.out.println("Select product to cart");
		String product_5 = scanner.nextLine();

		try {
			Connection connection = connectionTest.getConnection();
			PreparedStatement ps1 = connection.prepareStatement("insert into cart( product_1, product_2, product_3, product_4, product_5) values  (?,?,?,?,?) ");
			ps1.setString(1, product_1);
			ps1.setString(2, product_2);
			ps1.setString(3, product_3);
			ps1.setString(4, product_4);
			ps1.setString(5, product_5);
			int t = ps1.executeUpdate();
			System.out.println("Succesfully product cart" + t);
			connection.close();
			ps1.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
