package com.example.demo.service.impl;

import java.util.List;

import org.hibernate.query.sqm.tree.AbstractSqmRestrictedDmlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.porder;
import com.example.demo.entity.product;
import com.example.demo.repository.porderRepository;
import com.example.demo.service.porderService;

@Service
public class porderServiceImpl implements porderService{
	@Autowired
	porderRepository pr;
	
	@Override
	public void add(porder p) {
		pr.save(p);
		
	}

	@Override
	public porder queryId(int id) {
		// TODO Auto-generated method stub
		return pr.getOne(id);
	}

	@Override
	public void update(porder p) {
		pr.save(p);
		
	}

	@Override
	public void delete(int id) {
		porder p=pr.getById(id);
		pr.delete(p);
	}

	@Override
	public List<porder> FindAllByName(String name) {
		// TODO Auto-generated method stub
		return pr.findByName(name);
	}

	@Override
	public void deleteByname(String name) {
		List<porder> p=(List<porder>) pr.findByName(name);
		for(porder porder:p)
		{
			pr.delete(porder);
		}	
	}

}
