package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.porder;
import com.example.demo.entity.product;

public interface porderService {
	//create
	void add(porder p);
	
	
	//read
	porder queryId(int id);
	List<porder> FindAllByName(String name);
	
	//update
	void update(porder p);
	
	
	//delete
	void delete(int id);
	void deleteByname(String name);
}
