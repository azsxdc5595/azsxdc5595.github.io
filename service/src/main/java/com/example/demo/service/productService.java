package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.product;

public interface productService{
	//create
	void add(product p);
	
	
	//read
	List<product> selectAll();
	product selectId(int id);
	
	//update
	void update(product p);
	
	
	//delete
	void delete(int id);
}
