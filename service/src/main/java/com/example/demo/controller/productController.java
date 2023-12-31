package com.example.demo.controller;

import java.util.List;

import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.member;
import com.example.demo.entity.product;
import com.example.demo.service.impl.porderServiceImpl;
import com.example.demo.service.impl.productServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/product")
public class productController {
	@Autowired
	productServiceImpl psi;
	@Autowired
	porderServiceImpl porderService;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/gotoProduct")
	public ModelAndView gotoProduct()
	{
		List<product> p =psi.selectAll();
		session.setAttribute("P", p);
		member m=(member) session.getAttribute("M");
		return new ModelAndView("/product/product");
	}
	
	@RequestMapping(value="/gotoPorder",method=RequestMethod.GET)
	public ModelAndView product(@Param("productname")String productname,@Param("price")Integer price)
	{
		session.setAttribute("productname", productname);
		session.setAttribute("price", price);
		
		return new ModelAndView("/product/addPorder");
	}
	
}
