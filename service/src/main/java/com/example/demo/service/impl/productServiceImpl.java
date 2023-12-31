package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repository.productRepository;
import com.example.demo.service.productService;
@Service
public class productServiceImpl implements productService{
	@Autowired
	productRepository pr;
	@Override
	public void add(product p) {
		if(p!=null)
		{
			pr.save(p);
		}
		else {
			throw new IllegalArgumentException("Entity must not be null");
		}
	}

	@Override
	public List<product> selectAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public product selectId(int id) {
		// TODO Auto-generated method stub
		return pr.getById(id);
	}

	@Override
	public void update(product p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		product p=selectId(id);
		pr.delete(p);
	}

}
