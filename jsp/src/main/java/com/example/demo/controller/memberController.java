package com.example.demo.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.memberMapper;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class memberController {
	@Autowired
	private memberMapper mm;
	@Autowired
	private HttpSession session;
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException {
	    response.sendRedirect("../index.html");
	}
	@RequestMapping("gotoLogin")
	public void gotoLogin(HttpServletResponse response) throws IOException {
	    response.sendRedirect("../login.html");
	}
	@RequestMapping("login")
	public String login(String username,String password)
	{
		member m=mm.query(username, password);
		if(m!=null)
		{
			session.setAttribute("M", m);
			
			return "loginSuccess";
		}
		else
		{
			return "loginError";
		}
	}
	
	@RequestMapping("addMember")
	public String addMember()
	{
		return "/member/addMember";
	}
	
	@RequestMapping("add")
	public String add(String name,String username,String password,String email,Integer type)
	{
		member m=mm.queryUser(username);
		if(m!=null)
		{
			return "/member/addMemberError";
		}
		else
		{
			String memberno1=UUID.randomUUID().toString();
			member m1=new member(memberno1,name,username,password,email,type);
			mm.add(m1);
			return "/member/addMemberSuccess";
		}
	}
	
	@RequestMapping("function")
	public String function()
	{
		return "function";
	}
	
	@RequestMapping("gotoQuery")
	public String gotoQuery()
	{
		return "/member/query";
	}
	
	@RequestMapping("gotoChangePassword")
	public String gotoChangePassword()
	{
		return "/member/changePassword";
	}
	
	@RequestMapping("changePassword")
	public String changePassword(String password,String newPassword)
	{
		member m=(member) session.getAttribute("M");
		if(m.getPassword().equals(newPassword))
		{
			return "/member/changePasswordError1";
		}
		else {
			 if (newPassword == null || newPassword.trim().isEmpty()) 
			 {
				 return "/member/changePasswordError2";
			 }
			 else {
				 m.setPassword(newPassword);
				 mm.updatePassword(m);
				 session.removeAttribute("M");
				 return "/member/changePasswordSuccess";
			}
		}
	}
	
	@RequestMapping("gotoDeleteMember")
	public String gotoDeleteMember()
	{
		return "/member/deleteMember";
	}
	
	@RequestMapping("deleteMember")
	public String deleteMember(Integer id)
	{
		member m=(member) session.getAttribute("M");
		int id1=m.getId();
		mm.delete(id1);
		session.removeAttribute("M");
		return "/member/deleteSuccess";
	}
}
