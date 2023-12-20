package com.example.demo.controller;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.activityMapper;
import com.example.demo.vo.activity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("activity")
public class activityController {
	@Autowired
	activityMapper am;
	@Autowired
	HttpSession session;
	
	@RequestMapping("activity")
	public String activity()
	{
		return "/employee/manager/activity/activity";
	}
	
	@RequestMapping("addActivity")
	public String addActivity()
	{
		return "/employee/manager/activity/addActivity";
	}
	
	@RequestMapping("add")
	public String add(String name,String content,String eventtime)
	{
		activity a1=new activity(name, content, eventtime);
		am.add(a1);
		return "/employee/manager/activity/addActivitySuccess";
	}
	
	@RequestMapping("query")
	public String query(HttpServletRequest request)
	{
		List<activity> a=am.queryAll();
		session.setAttribute("A", a);
		return "/employee/manager/activity/query";
	}
	
	@RequestMapping("query2")
	public String query2(HttpServletRequest request)
	{
		List<activity> a=am.queryAll();
		session.setAttribute("A", a);
		return "/activity/query";
	}
	
	@RequestMapping(value="gotoUpdate",method = RequestMethod.GET)
	public String gotoUpdate(@RequestParam("id")Integer id)
	{
		activity a=am.queryId(id);
		session.setAttribute("U", a);
		return "/employee/manager/activity/updateActivity";
	}
	
	@PostMapping("update")
	public String update(String name,String content,String eventtime)
	{
		activity a=(activity)session.getAttribute("U");
		a.setName(name);
		a.setContent(content);
		a.setEventtime(eventtime);
		am.update(a);
		session.removeAttribute("U");
		return "/employee/manager/activity/updateActivitySuccess";
	}
	
	@RequestMapping(value="gotoDelete",method = RequestMethod.GET)
	public String gotoDelete(@RequestParam("id")Integer id)
	{
		activity a=am.queryId(id);
		session.setAttribute("D", a);
		return "/employee/manager/activity/deleteActivity";
	}
	
	@PostMapping("delete")
	public String delete()
	{
		activity a=(activity) session.getAttribute("D");
		am.delete(a.getId());
		session.removeAttribute("D");
		return "/employee/manager/activity/deleteActivitySuccess";
	}
}
