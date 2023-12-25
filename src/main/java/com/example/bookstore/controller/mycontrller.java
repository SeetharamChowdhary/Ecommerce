package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.model.Admin;
import com.example.bookstore.model.Reatiler;
import com.example.bookstore.model.User;
import com.example.bookstore.service.AdminService;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.ReatilerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class mycontrller
{
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ReatilerService reatilerService;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	//Admin controller
	
	@GetMapping("/adminlogin")
	public ModelAndView adminlogin()
	{
		return new ModelAndView("adminlogin","message","enter crendentials");
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView chekadminlogin(HttpServletRequest request)
	{
	    String uname = request.getParameter("uname");
	     String pwd = request.getParameter("pwd");
		Admin admin = adminService.checkadminlogin(uname, pwd);
	    
	    if(admin!=null)
	    {
	      
	      return new ModelAndView("adminhome","a", admin);
	    }
	    else
	    {	
	    	return new ModelAndView("adminlogin","message", "Login Failed");
	    }
	    
	    
	}
	
	@GetMapping("/adminhome")
	public String adminhome() {
		return "adminhome";
	}
	
	@GetMapping("viewallusers")
	public ModelAndView viewusers()
	{
		List<User> list=adminService.viewUsers();
		return new ModelAndView("viewallusers","l",list);
	}
	
	
	//customer controller
	@GetMapping("/customerlogin")
	public ModelAndView customerlogin()
	{
		return new ModelAndView("customerlogin","message","enter credentials");
	}
	
	@PostMapping("/insertuser")
	public ModelAndView insertuser(HttpServletRequest request)
	{
		String cname=request.getParameter("name");
		String cemail=request.getParameter("email");
		String cpwd=request.getParameter("password");
		User u=new User();
		u.setName(cname);
		u.setEmail(cemail);
		u.setPassword(cpwd);
		String msg=customerService.insercustomer(u);
		return new ModelAndView("customerlogin","message","user inserted succesfully");
	}
	@PostMapping("/checkuser")
	public ModelAndView checkuser(HttpServletRequest request)
	{
		String name=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		User u=customerService.checkuserlogin(name,pwd);
		if(u!=null)
		{
			return new ModelAndView("customerhome","u",u);
		}
		else
		{
			return new ModelAndView("customerlogin","message","invalid credentials");
		}
	}
	@GetMapping("/customerhome")
	public ModelAndView customerhome()
	{
		return new ModelAndView("customerhome");
	}
	
	//retailer
	@GetMapping("/reatilerlogin")
	public String reatilerlogin()
	{
		return "reatilerlogin";
	}
	
	@PostMapping("/insertreatiler")
	public ModelAndView insertreatler(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		String type=request.getParameter("reatilertype");
		String loc=request.getParameter("location");
		String sname=request.getParameter("shopname");
		Reatiler r=new Reatiler();
		r.setName(name);
		r.setEmail(email);
		r.setPassword(pwd);
		r.setType(type);
		r.setLocation(loc);
		r.setShopname(sname);
		String msg=reatilerService.insertReatiler(r);
		return new ModelAndView("reatilerlogin","message","please login");
	}
	@PostMapping("/checkreatiler")
	public ModelAndView checkReatiler(HttpServletRequest request)
	{
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		Reatiler r=reatilerService.checkreatiler(email,pwd);
		if(r!=null)
		{
			return new ModelAndView("reatilerhome","r",r);
		}
		else
		{
			return new ModelAndView("reatilerlogin","message","login failed");
		}
	}
	@GetMapping("reatilerhome")
	public String reailerhome()
	{
		return "reatilerhome";
	}
	
	
}