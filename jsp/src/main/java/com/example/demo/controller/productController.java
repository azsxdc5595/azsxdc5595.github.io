package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.productMapper;
import com.example.demo.vo.product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("product")
public class productController {
	@Autowired
	productMapper pm;
	@Autowired
	HttpSession session;
	
	@RequestMapping("product")
	public String product(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size)
	{
		PageHelper.startPage(page,size);
		Page<product> p=pm.queryAll();
		PageInfo<product> pageInfo=new PageInfo<>(p);
		session.setAttribute("products", pageInfo);
		return "/product/product";
	}
	
	@RequestMapping("product2")
	public String product2(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size)
	{
		PageHelper.startPage(page,size);
		Page<product> p=pm.queryAll();
		PageInfo<product> pageInfo=new PageInfo<>(p);
		session.setAttribute("products", pageInfo);
		return "/employee/manager/product/allProduct";
	}
	
	@RequestMapping("product3")
	public String product3(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size)
	{
		PageHelper.startPage(page,size);
		Page<product> p=pm.queryAll();
		PageInfo<product> pageInfo=new PageInfo<>(p);
		session.setAttribute("products", pageInfo);
		return "/employee/employee/product/product";
	}
	
	@RequestMapping("product4")
	public String product4(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size)
	{
		PageHelper.startPage(page,size);
		Page<product> p=pm.queryAll();
		PageInfo<product> pageInfo=new PageInfo<>(p);
		session.setAttribute("products", pageInfo);
		return "/product/product2";
	}
	
	@RequestMapping("addProduct")
	public String addProduct()
	{
		return "/employee/manager/product/addProduct";
	}
	
	@RequestMapping("add")
	public String addProduct(String productno,String productname,Integer price)
	{
		product p=new product(productno,productname,price);
		session.setAttribute("product", p);
		pm.add(p);
		
		return "/employee/manager/product/addProductSuccess";
	}
}
