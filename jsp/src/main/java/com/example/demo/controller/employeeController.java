package com.example.demo.controller;

import java.util.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.employeeMapper;
import com.example.demo.vo.employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("employee")
public class employeeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	employeeMapper em;
	
	@RequestMapping("Employee")
	public String gotoLogin()
	{
		return "/employee/employee";
	}
	
	@RequestMapping("login")
	public String login(String username,String password)
	{
		employee e=em.queryUser(username, password);
		if(e!=null)
		{
			session.setAttribute("E", e);
			if(e.getType()>=1)
			{
				return "/employee/manager/manager";
			}
			else
			{
				return "employee/employee/employee";
			}
		}
		else
		{
			return "/employee/error";
		}
	}
	
	@RequestMapping("addEmployee")
	public String gotoAddEmployee()
	{
		return "/employee/addEmployee";
	}
	
	@RequestMapping("add")
	public String add(String name,String username,String password,String phone,Integer type)
	{
		employee e=em.queryUsername(username);
		if(e!=null)
		{
			return "employee/addEmployeeError";
		}
		else
		{
			String employeeno1 = UUID.randomUUID().toString();
			employee e1=new employee(employeeno1,name,username,password,phone,type);
			em.add(e1);
			return "employee/addEmployeeSuccess";
		}
	}
	
	@RequestMapping("system")
	public String gotoSystem()
	{
		return "employee/manager/system";
	}
	
	@RequestMapping("system2")
	public String gotoSystem2()
	{
		return "employee/employee/system";
	}
	
	@RequestMapping("managerEmployees")
	public String gotoManagerEmployees()
	{
		return "employee/manager/employee/managerEmployees";
	}
	
	@RequestMapping("query")
	public String gotoQuery()
	{
		session.getAttribute("E");
		return "employee/manager/employee/query";
	}
	
	@RequestMapping(value = "changePassword",method = {RequestMethod.GET, RequestMethod.POST})
	public String gotoChangePassword(@RequestParam("employeeName") String employeeName,
            @RequestParam("employeePassword") String employeePassword)
	{
		employee e = em.getEmployeeByName(employeeName);
		session.setAttribute("C", e);
		return "/employee/manager/employee/changePassword";
	}
	
	@RequestMapping(value="changeSuccess")
	public String changeSuccess(@RequestParam("employeePassword") String employeePassword)
	{
		employee e =(employee) session.getAttribute("C");
		employee e1=(employee) session.getAttribute("E");
		
		if(e1.getPassword().equals(employeePassword) || employeePassword == null || employeePassword.trim().isEmpty())
		{
			return "/employee/manager/employee/changeError";
		}
		else {
			e.setPassword(employeePassword);
			em.updatePassword(e);
			
			session.removeAttribute("C");
			session.removeAttribute("E");
			
			return "/employee/manager/employee/changeSuccess";
		}
		
		
	}
	
	@RequestMapping(value = "changePhone",method = {RequestMethod.GET, RequestMethod.POST})
	public String gotoChangePhone(@RequestParam("employeeName") String employeeName,
            @RequestParam("employeePhone") String employeePhone)
	{
		employee e = em.getEmployeeByName(employeeName);
		session.setAttribute("CP", e);
		return "/employee/manager/employee/changePhone";
	}
	
	@RequestMapping(value="changePhoneSuccess")
	public String changePhoneSuccess(@RequestParam("employeePhone") String employeePhone)
	{
		employee e =(employee) session.getAttribute("CP");
		
		e.setPhone(employeePhone);
		em.updatePhone(e);
		
		session.removeAttribute("CP");
		session.removeAttribute("E");
		
		return "/employee/manager/employee/changeSuccess";
	}
	
	@RequestMapping(value = "changePassword2",method = {RequestMethod.GET, RequestMethod.POST})
	public String gotoChangePassword2(@RequestParam("employeeName") String employeeName,
            @RequestParam("employeePassword") String employeePassword)
	{
		employee e = em.getEmployeeByName(employeeName);
		session.setAttribute("C", e);
		return "/employee/employee/changePassword";
	}
	
	@RequestMapping(value="changeSuccess2")
	public String changeSuccess2(@RequestParam("employeePassword") String employeePassword)
	{
		employee e =(employee) session.getAttribute("C");
		employee e1=(employee)session.getAttribute("E");
		if(e1.getPassword().equals(employeePassword) || employeePassword == null || employeePassword.trim().isEmpty())
		{
			return "/employee/employee/changeError";
		}
		else {
			e.setPassword(employeePassword);
			em.updatePassword(e);
			
			session.removeAttribute("C");
			session.removeAttribute("E");
			
			return "/employee/employee/changeSuccess";
		}
		
		
	}
	
	@RequestMapping(value = "changePhone2",method = {RequestMethod.GET, RequestMethod.POST})
	public String gotoChangePhone2(@RequestParam("employeeName") String employeeName,
            @RequestParam("employeePhone") String employeePhone)
	{
		employee e = em.getEmployeeByName(employeeName);
		session.setAttribute("CP", e);
		return "/employee/employee/changePhone";
	}
	
	@RequestMapping(value="changePhoneSuccess2")
	public String changePhoneSuccess2(@RequestParam("employeePhone") String employeePhone)
	{
		employee e =(employee) session.getAttribute("CP");
		
		e.setPhone(employeePhone);
		em.updatePhone(e);
		
		session.removeAttribute("CP");
		session.removeAttribute("E");
		
		return "/employee/employee/changeSuccess";
	}
	
	@RequestMapping("queryAll")
	public String gotoQueryAll(HttpServletRequest request)
	{
		List<employee> e=em.queryAll();
		session.setAttribute("employees", e);
		for(employee employee:e)
		{
			
		}
		return "/employee/manager/employee/queryAll";
	}
	
	@RequestMapping(value="changePosition",method=RequestMethod.GET)
	public String changePosition(@RequestParam("employeeName")String employeeName,@RequestParam("employeeType")Integer employeeType)
	{
		employee e = em.getEmployeeByName(employeeName);
		session.setAttribute("Position", e);
		return "/employee/manager/employee/changePosition";
	}
	
	@RequestMapping(value="changePositionSuccess")
	public String changePositionSuccess(@RequestParam("employeeName")String employeeName,Integer newType)
	{
		employee e=(employee)session.getAttribute("Position");
		e.setType(newType);
		em.updateType(e);
		session.removeAttribute("Position");
		
		return "/employee/manager/employee/changeSuccess";
	}
	
	@RequestMapping("managerEmployee")
	public String gotoManagerEmployee()
	{
		return "/employee/employee/query";
	}
	
	@RequestMapping("product")
	public String gotoProduct()
	{
		return "/employee/manager/product/product";
	}
	
	@RequestMapping("logout")
	public String logout()
	{
		session.removeAttribute("E");
		return "/employee/logout";
	}
}
