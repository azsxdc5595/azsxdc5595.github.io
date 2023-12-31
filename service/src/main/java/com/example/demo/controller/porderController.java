package com.example.demo.controller;

import java.rmi.server.UID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.impl.memberServiceImpl;
import com.example.demo.service.impl.porderServiceImpl;
import com.example.demo.entity.member;
import com.example.demo.entity.porder;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/porder")
public class porderController {
	@Autowired
	porderServiceImpl psi;
	
	@Autowired
	memberServiceImpl msi;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/query")
	public ModelAndView query()
	{
		member m=(member) session.getAttribute("M");
		List<porder> p=psi.FindAllByName(m.getName());
		int totalAmount = p.stream().mapToInt(porder->porder.getAmount() * porder.getPrice()).sum();
		session.setAttribute("porder", p);
		ModelAndView mav=new ModelAndView("/product/query");
		mav.addObject("totalAmount", totalAmount);
		return mav;
	}
	
	@PostMapping("/add")
	public ModelAndView add(String name,String productname,Integer amount,Integer price)
	{
		porder p1=new porder(name,productname,amount,price);
		psi.add(p1);
		session.removeAttribute("porder");
		member m=(member) session.getAttribute("M");
		List<porder> p=psi.FindAllByName(m.getName());
		session.setAttribute("porder", p);
		return new ModelAndView("/product/query");
	}
	
	@RequestMapping(value="/gotoUpdate",method=RequestMethod.GET)
	public ModelAndView gotoUpdate(@Param("id")Integer id,@Param("amount")Integer amount)
	{
		session.setAttribute("uid", id);
		session.setAttribute("uamount", amount);
		return new ModelAndView("/product/update");
	}
	
	@PostMapping("/update")
	public ModelAndView update(Integer amount)
	{
		Integer id=(Integer)session.getAttribute("uid");
		porder p=psi.queryId(id);
		p.setAmount(amount);
		psi.update(p);
		member m=(member) session.getAttribute("M");
		List<porder> p1=psi.FindAllByName(m.getName());
		session.setAttribute("porder2", p1);
		return new ModelAndView("/product/updateSuccess");
	}
	
	@RequestMapping(value="/gotoDelete",method=RequestMethod.GET)
	public ModelAndView gotoDelete(@Param("id")Integer id)
	{
		session.setAttribute("did", id);
		Integer id1=(Integer)session.getAttribute("uid");
		porder p=psi.queryId(id);
		session.setAttribute("DID", p);
		return new ModelAndView("/product/delete");
	}
	
	@PostMapping("/delete")
	public ModelAndView delete()
	{
		Integer id=(Integer)session.getAttribute("did");
		psi.delete(id);
		return new ModelAndView("/product/deleteSuccess");
	}
	
	@RequestMapping(value = "gotoCheckout", method = RequestMethod.GET)
	public ModelAndView gotoCheckout(@RequestParam("totalAmount") Integer totalAmount) {
		ModelAndView mav=null;
	    if(totalAmount != null && totalAmount != 0)
	    {
	    	mav = new ModelAndView("/product/checkout");
		    mav.addObject("totalAmount", totalAmount);
	    }
	    else {
	    	mav = new ModelAndView("/product/checkoutError");
	    }
	    return mav;
	}

	@RequestMapping("checkout")
	public ModelAndView checkout(Integer cash) {
	    member m = (member) session.getAttribute("M");
	    psi.deleteByname(m.getName());
	    m.setCash(cash);
	    msi.update(m);
	    session.removeAttribute("porder");
	    return new ModelAndView("/product/checkoutSuccess");
	}

}
