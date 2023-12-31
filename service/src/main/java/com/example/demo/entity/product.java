package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="product")
public class product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String productno;
	private String productname;
	private Integer price;
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(String productno, String productname, Integer price) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
