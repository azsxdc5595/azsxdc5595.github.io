package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.messageMapper;
import com.example.demo.vo.member;
import com.example.demo.vo.message;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("message")
public class messageController {
	@Autowired
	messageMapper mm;
	@Autowired
	HttpSession session;
	
	@RequestMapping("message")
	public String message()
	{
		List<message> m=mm.queryAll();
		session.setAttribute("messages", m);
		for(message message:m)
		{
			
		}
		return "/message/message";
	}
	
	@RequestMapping("message2")
	public String message2()
	{
		List<message> m=mm.queryAll();
		session.setAttribute("messages", m);
		for(message message:m)
		{
			
		}
		return "/employee/manager/message";
	}
	
	@RequestMapping("addMessage")
	public String addMessage()
	{
		return "/message/addMessage";
	}
	
	@PostMapping("add")
	public String add(String title,String content)
	{
		member m=(member) session.getAttribute("M");
		message m1=new message(m.getMemberno(),title,content);
		session.setAttribute("message",m1);
		return "/message/finish";
	}
	
	@RequestMapping("finish")
	public String finish()
	{
		message m=(message) session.getAttribute("message");
		mm.add(m);
		return "/function";
	}
	
	@RequestMapping("query")
	public String query(HttpServletRequest request)
	{
		member m=(member) session.getAttribute("M");
		List<message> m1=mm.queryByMemberno(m.getMemberno());
		session.setAttribute("Q", m1);
		for(message message:m1)
		{
			
		}
		return "/message/query";
	}
	
	@RequestMapping(value = "gotoUpdate", method = RequestMethod.GET)
	public String gotoUpdate(@RequestParam("id")Integer id,@RequestParam("title")String title,@RequestParam("content")String content)
	{
		member m1=(member) session.getAttribute("M");
		message m=mm.getMessageById(id);
		session.setAttribute("MU", m);
		return "/message/update";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("title")String title,@RequestParam("content")String content)
	{
		message m=(message) session.getAttribute("MU");
		m.setTitle(title);
		m.setContent(content);
		mm.update(m);
		session.setAttribute("MU2", m);
		session.removeAttribute("MU2");
		return "/message/updateSuccess";
	}
	
	@GetMapping("gotoDelete")
	public String gotoDelete(@RequestParam("id")Integer id)
	{
		message m=mm.getMessageById(id);
		session.setAttribute("MD", m);
		return "/message/delete";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id")Integer id)
	{
		message m=(message) session.getAttribute("Md");
		mm.delete(id);
		session.removeAttribute("MD");
		return "/message/deleteSuccess";
	}
}
