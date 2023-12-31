package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.member;
import com.example.demo.repository.memberRepository;
import com.example.demo.service.memberService;
@Service
public class memberServiceImpl implements memberService{
	@Autowired
	memberRepository mr;
	
	@Override
	public void add(member m) {
		if(m.getName()!=null && m.getName()!="")
		{
			mr.save(m);
		}
		
	}

	@Override
	public member queryMember(String username, String password) {
		
		return mr.findmember(username, password);
	}

	@Override
	public member queryId(int id) {
		
		return mr.getOne(id);
	}

	@Override
	public void update(member m) {
		mr.save(m);
		
	}

	@Override
	public void delete(int id) {
		member m=mr.getById(id);
		mr.delete(m);
		
	}

	@Override
	public member queryUsername(String username) {
		
		return mr.findByUsername(username);
	}

}
