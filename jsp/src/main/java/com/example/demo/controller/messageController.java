package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.messageMapper;
import com.example.demo.mybatis.PageHelperConfig;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public String message(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
	    member m = (member) session.getAttribute("M");

	    // 使用 PageHelper 进行分页
	    PageHelper.startPage(page, size);
	    Page<message> paginatedMessages = mm.queryByMemberno(m.getMemberno());
	    PageInfo<message> pageInfo = new PageInfo<>(paginatedMessages);

	    session.setAttribute("message", pageInfo);

	    return "/message/query";
	}

	
	@RequestMapping("message2")
	public String message2(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
	    // 使用 PageHelper 进行分页
	    PageHelper.startPage(page, size);
	    Page<message> allMessages = mm.queryAll();
	    PageInfo<message> pageInfo = new PageInfo<>(allMessages);

	    session.setAttribute("message2", pageInfo);

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
