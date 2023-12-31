package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.query.sqm.tree.AbstractSqmRestrictedDmlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.member;
import com.example.demo.entity.porder;
import com.example.demo.entity.product;
import com.example.demo.service.impl.memberServiceImpl;
import com.example.demo.service.impl.porderServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class memberController {
	@Autowired
	memberServiceImpl msi;
	@Autowired
	porderServiceImpl psi;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public ModelAndView login(String username,String password)
	{
		member m=msi.queryMember(username, password);
		ModelAndView mav=null;
		if(m!=null)
		{
			session.setAttribute("M", m);
			List<porder> l=psi.FindAllByName(m.getName());
			session.setAttribute("L", l);
			mav=new ModelAndView("/loginSuccess");
		}
		else {
			mav=new ModelAndView("/loginError");
		}
		return mav;
	}
	
	@GetMapping("/addMember")
	public ModelAndView addMember()
	{
		return new ModelAndView("/addMember");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(String name,String username,String password,String email,Integer type,Integer cash)
	{
		member m=msi.queryUsername(username);
		ModelAndView mav=null;
		if(m!=null)
		{
			mav=new ModelAndView("/addMemberError");
		}
		else {
			String memberno1=UUID.randomUUID().toString();
			member m2=new member(memberno1,name,username,password,email,type,cash);
			msi.add(m2);
			mav=new ModelAndView("/addMemberSuccess");
		}
		return mav;
	}
	
	@GetMapping("/gotoQuery")
	public ModelAndView gotoQuery()
	{
		return new ModelAndView("/member/query");
	}
	
	@GetMapping("/function")
	public ModelAndView function()
	{
		return new ModelAndView("/member/function");
	}
	
	@GetMapping("/gotoChangePassword")
	public ModelAndView gotoChangePassword()
	{
		return new ModelAndView("/member/changePassword");
	}
	
	@PostMapping("/changePassword")
	public ModelAndView changePassword(String newPassword1,String newPassword2)
	{
		member m=(member) session.getAttribute("M");
		ModelAndView mav=null;
		if(m.getPassword().equals(newPassword1) || newPassword1 == null || newPassword1.trim().isEmpty() || newPassword1 != newPassword2)
		{
			mav = new ModelAndView("/member/changeError");
		}
		else {
			m.setPassword(newPassword1);
			msi.update(m);
			mav=new ModelAndView("/member/changeSuccess");
			
		}
		return mav;
	}
	
	@GetMapping("/gotoChangeEmail")
	public ModelAndView gotoChangeEmail()
	{
		return new ModelAndView("/member/changeEmail");
	}
	
	@PostMapping("/changeEmail")
	public ModelAndView Email(String newEmail)
	{
		member m=(member) session.getAttribute("M");
		ModelAndView mav=null;
		if(m.getEmail().equals(newEmail))
		{
			mav = new ModelAndView("/member/changeEmailError");
		}
		else {
			m.setEmail(newEmail);
			msi.update(m);
			mav=new ModelAndView("/member/changeSuccess");
			
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public void logout()
	{
		session.removeAttribute("M");
		session.removeAttribute("L");
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/gotoDeleteMember")
	public ModelAndView gotoDeleteMember()
	{
		return new ModelAndView("/member/deleteMember");
	}
	
	@GetMapping("/deleteMember")
	public ModelAndView deleteMember()
	{
		member m=(member) session.getAttribute("M");
		msi.delete(m.getId());
		return new ModelAndView("/member/deleteMemberSuccess");
	}
}
