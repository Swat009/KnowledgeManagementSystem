package org.greysalmon.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.greysalmon.model.Post;
import org.greysalmon.model.User;
import org.greysalmon.sevice.PostService;
import org.greysalmon.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HelloWorldController
{

	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String sayHello(ModelMap model)
	{
		model.addAttribute("message","Welcome to MVC");
		return "welcome";
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String register(Map<String,Object> map)
	{
		map.put("user",new User());
		return "user/register";
		
	}
	
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute(value="user") User user, BindingResult result ,Map<String,Object> map)
	{
		if(result.hasErrors())
			return "user/register";
		userService.create(user);
		return "redirect:/details/"+user.getUserId();
		
	}
	
	@RequestMapping(value="/details/{userId}" , method=RequestMethod.GET)
	public String details(@PathVariable("userId") Long userId,Map<String,Object> map)
	{
		User user=userService.find(userId);
		map.put("name",user.getName());
		map.put("name",user.getRollno());
		return "user/details";
		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Map<String,Object> map)
	{
		map.put("userList",userService.getAll());
		return "user/list";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "user/login";
		}
		else
		{
			return "redirect:/account";
		}
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String dologin(Map<String,Object> map,@ModelAttribute("userData") User user,HttpSession session)
	{
		if(user.getRollno()!=null && user.getPassword()!=null && session.getAttribute("user")==null){
			user=userService.login(user);
		
		if(user!=null)
		{
			System.out.println(user.getRollno());
			session.setAttribute("user",user);
			return "redirect:/account";
		}
		else
		{
			map.put("failed","Login Failed");
			return "redirect:/login";
		}
		}
		else
		return "redirect:/account";
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(Map<String,Object> map,HttpSession session)
	{
		session.removeAttribute("user");
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/account" , method=RequestMethod.GET)
	public String account(Map<String,Object> map,HttpSession session)
	{
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "user/login";
		}
		map.put("posts",postService.getAll() );
		//map.put("user",new User());
		return "user/account";
		
	}
	
	@RequestMapping(value="/createpost",method=RequestMethod.GET)
	public String createPost(Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "redirect:/login";
		}
		else
		{
			map.put("post",new Post());
			return "user/createpost";
		}
		
	}
	
	@RequestMapping(value="/createpost",method=RequestMethod.POST)
	public String storePost(Post post,Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			User u=(User) session.getAttribute("user");
			post.setUserId(u.getUserId());
			post.setUsername(u.getName());
			System.out.println(post.getTitle()+" "+u.getUserId());
			Date d=new Date();
			post.setCreatedon(d);
			post.setEditedon(d);
			postService.create(post);
			return "redirect:/account";
		}
		
	}


}
