package com.copy.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.copy.user.Read;
import com.copy.user.User;

//import com.copy.user.User;
//@WebService(endpointInterface = "read")
public class MyDbConn implements Read {

	public String create(int id, String name, int age) throws ClassNotFoundException {
		try {

			Connection con = new MyDbConn().getConnection();
			PreparedStatement create = con.prepareStatement("INSERT INTO Auser(id,name,age) VALUES(?,?,?)");
			create.setInt(1, id);
			create.setString(2, name);
			create.setInt(3, age);
			int rowaffected = create.executeUpdate();
			if (rowaffected > 0) {
				return "Record Insertd Successfully /n id:  " + id + "\n name: " + name + "\n age:" + age;
			}

		} catch (SQLException e) {

		}
		return "Failed to Insert Record";

	}

	public String update(int id, String name, int age) throws ClassNotFoundException {

		try {
			Connection con = new MyDbConn().getConnection();
			PreparedStatement update = con.prepareStatement("UPDATE Auser set name=?,age=? where id=?");
			// PreparedStatement select =con.prepareStatement("SELECT name,age FROM Auser
			// WHERE id=?");
			update.setInt(3, id);
			update.setString(1, name);
			update.setInt(2, age);
			int rowaffected = update.executeUpdate();
			if (rowaffected > 0) {
				/*
				 * select.setInt(1, id); ResultSet rs = select.executeQuery(); if (rs.next()) {
				 * updatedUser = new
				 * User(rs.getInt("id"),rs.getString("name"),rs.getInt("age")); }
				 */
				return "Update successfuly";
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return "Failed to Update";

		// return updatedUser;
	}

	public String delete(int id) throws ClassNotFoundException {

		try {
			Connection con = new MyDbConn().getConnection();
			PreparedStatement delete = con.prepareStatement("DELETE FROM Auser WHERE id =?");
			delete.setInt(1, id);
			int rowaffected = delete.executeUpdate();
			if (rowaffected > 0) {
				return "deleted successfully" + id;
			} else {
				return "failed to delete";
			}
		} catch (SQLException e) {

			return e.getMessage();
		}

	}

	/*
	 * @Override public User[] read(String name) throws ClassNotFoundException { //
	 * TODO Auto-generated method stub return null; }
	 */

	public User[] read(String name) throws ClassNotFoundException {
		int id = 0;
		int age = 0;
		int numberOfRows = 0;
		List<User> users = new ArrayList<User>();
		try {
			Connection con = new MyDbConn().getConnection();
			PreparedStatement read = con.prepareStatement("SELECT * FROM Auser WHERE  name like ?");
			read.setInt(1, id);
			read.setString(1, "%" + name + "%");
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				++numberOfRows;
				id = rs.getInt("id");
				name = rs.getString("name");
				age = rs.getInt("age");

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setAge(age);

				users.add(user);
				System.out.println(read);

				System.out.println("Id:" + id);
				System.out.println("name:" + name);
				System.out.println("age:" + age); // User u =new User(id, name, age);
				/*
				 * rs.getInt("id"); rs.getString("name"); rs.getInt("age"); users.add(u);
				 */

			}
			if (numberOfRows == 0) {
				System.out.println("No User Found.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return users.toArray(new User[0]);

		// return "Data not Found";

	}

	/*
	 * public void close() { try { if (con != null) con.close(); } catch
	 * (SQLException e) { System.out.println("Conection closed");
	 * 
	 * }
	 */

}
