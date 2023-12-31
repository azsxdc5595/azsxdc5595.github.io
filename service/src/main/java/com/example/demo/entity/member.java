package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="member")
public class member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String memberno;
	private String name;
	private String username;
	private String password;
	private String email;
	private Integer type;
	private Integer cash;
	// 新增預設建構函數
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public String getMemberno() {
		return memberno;
	}
	public void setMemberno(String Memberno) {
		this.memberno = memberno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCash() {
		return cash;
	}
	public void setCash(Integer cash) {
		this.cash = cash;
	}
	public member(String memberno,String name, String username, String password, String email, Integer type, Integer cash) {
		super();
		this.memberno = memberno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.cash = cash;
	}
	
}
