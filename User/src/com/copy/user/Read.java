package com.copy.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Read {
	@WebMethod
	String create(int id, String name, int age) throws ClassNotFoundException;

	@WebMethod
	String update(int id, String name, int age) throws ClassNotFoundException;

	@WebMethod
	String delete(int id) throws ClassNotFoundException;

	@WebMethod
	public User[] read(String name) throws ClassNotFoundException;
	// List<User> users = new ArrayList<User>();
	// return users;}

	public static final Connection con = null;

	public default Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:postgresql://localhost:5432/School";
		String user = "postgres";
		String password = "Root";

		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection(url, user, password);
		if (con != null) {
			System.out.println("Conncted");
		} else {
			System.out.println("Not Cnnected");
		}

		return con;
	}

}
