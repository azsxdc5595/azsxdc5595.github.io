package com.example.demo.service;

import com.example.demo.entity.member;

public interface memberService {
	//create
	void add(member m);
	
	
	//read
	member queryMember(String username,String password);
	member queryId(int id);
	member queryUsername(String username);
	
	//update
	void update(member m);
	
	
	//delete
	void delete(int id);
}
