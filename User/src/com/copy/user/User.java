package com.copy.user;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1924293866619659802L;
	private String name;
	private Integer age;
	private Integer id;

	

	public User() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/*
	 * public static void main(String [] args) throws ClassNotFoundException { User
	 * rs = new User(); //String name="Apsar "; rs.read(1, name ); } private void
	 * read(int id, String name2) { 
	 * System.out.println(id+name+age); }
	 */
}
