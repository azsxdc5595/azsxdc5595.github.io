package com.example.demo.vo;

import lombok.Data;

@Data
public class employee {
	private Integer id;
	private String employeeno;
	private String name;
	private String username;
	private String password;
	private String phone;
	private Integer type;
	public employee(String employeeno, String name, String username, String password, String phone, Integer type) {
		super();
		this.employeeno = employeeno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.type = type;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}