package org.greysalmon.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.greysalmon.model.Answers;
import org.greysalmon.model.Followers;
import org.greysalmon.model.Post;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;
import org.greysalmon.sevice.AnswersService;
import org.greysalmon.sevice.FollowersService;
import org.greysalmon.sevice.PostService;
import org.greysalmon.sevice.QuestionsService;
import org.greysalmon.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloWorldController
{

	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	FollowersService followersService;
	

	@Autowired
	QuestionsService questionsService;
	
	@Autowired
	AnswersService answersService;
	
	
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
		map.put("message","Your request has been placed.Please wait for the admin to approve your request");
		return "user/success";
		
	}
	
	@RequestMapping(value="/details/{userId}" , method=RequestMethod.GET)
	public String details(@PathVariable("userId") Long userId,Map<String,Object> map,HttpSession session)
	{
		User user=userService.find(userId);
		//map.put("name",user.getName());
		map.put("details",user);
		return "user/details";
		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Map<String,Object> map,HttpSession session)
	{
		User u=(User) session.getAttribute("user");
		if(session.getAttribute("user")==null || u.getUserId()==0)
		{
			map.put("user",new User());
			
			return "user/login";
		}
		//User u=(User) session.getAttribute("user");
		map.put("userList",userService.getAll());
		map.put("followingList",followersService.getAll());
		
		//System.out.println("Testing"+followersService.getFollowing(u.getUserId()).toString());
		return "user/list";
	}
	
	@RequestMapping(value="/following",method=RequestMethod.GET)
	public String following(Map<String,Object> map,HttpSession session)
	{
		User u=(User) session.getAttribute("user");
		if(session.getAttribute("user")==null || u.getUserId()==0)
		{
			map.put("user",new User());
			
			return "user/login";
		}
		//User u=(User) session.getAttribute("user");
		map.put("userList",userService.getAll());
		map.put("followingList",followersService.getAll());
		
		//System.out.println("Testing"+followersService.getFollowing(u.getUserId()).toString());
		return "user/following";
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
			map.put("user",session.getAttribute("user"));
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
			if(user.getVerified()==0)
			{
				map.put("failed","Your id not verified");
				return "redirect:/login";
			}
			//System.out.println(user.getRollno());
			session.setAttribute("user",user);
			return "redirect:/account";
		}
		
		else
		{
			map.put("failed","Login Failed");
			return "redirect:/login";
		}
		
		}
		else{
			map.put("failed","");
			return "redirect:/account";
		}
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
	
	
	@RequestMapping(value="/userposts",method=RequestMethod.GET)
	public String userPosts(Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "redirect:/login";
		}
		else
		{
			User u=(User) session.getAttribute("user");
			List<Post> p=u.getPosts();
			System.out.println(p.toString());
			map.put("posts",p);
			return "user/userposts";
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
			//post.setUserId(u.getUserId());
			post.setUsername(u.getName());
			post.setUser(u);
			System.out.println(post.getTitle()+" "+u.getUserId());
			Date d=new Date();
			post.setCreatedon(d);
			post.setEditedon(d);
			postService.create(post);
			return "redirect:/account";
		}
		
	}
	
	@RequestMapping(value="/askquestion",method=RequestMethod.GET)
	public String askquestion(Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "redirect:/login";
		}
		else
		{
			map.put("post",new Post());
			return "user/askquestion";
		}
		
	}
	
	
	@RequestMapping(value="/createquestion",method=RequestMethod.POST)
	public String askquestion(Questions question,Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			User u=(User) session.getAttribute("user");
			//post.setUserId(u.getUserId());
			question.setUsername(u.getName());
			question.setUser(u);
		//	System.out.println(post.getTitle()+" "+u.getUserId());
			Date d=new Date();
			question.setCreatedon(d);
			question.setEditedon(d);
			questionsService.create(question);
			return "redirect:/account";
		}
		
	}
	
	@RequestMapping(value="/allquestions",method=RequestMethod.GET)
	public String allquestions(Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			
			List<Questions> ques=questionsService.getAll();
			
			map.put("questions",ques);
			
			return "user/allquestions";
		}
		
	}
	
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin(Map<String,Object> map,HttpSession session)
	{
		User u=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null || u.getRole()!=1)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			map.put("userList",userService.getAll());
			
			return "user/admin";
		}
		
	}
	
	@RequestMapping(value="/question/{qid}",method=RequestMethod.GET)
	public String question(@PathVariable("qid") Long qid,Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "redirect:/login";
		}
		else
		{
			Questions question=questionsService.find(qid);
			map.put("answer",new Answers());
			map.put("question",question);
			session.putValue("question",question);
			return "user/question";
		}
		
	}
	
	
	@RequestMapping(value="/createanswer",method=RequestMethod.POST)
	public String createanswer(Answers answer,Map<String,Object> map,HttpSession session)
	{
		
		if(session.getAttribute("user")==null)
		{
			map.put("user",new User());
			
			return "redirect:/login";
		}
		else
		{
			//Questions question=questionsService.find(qid);
			User u=(User) session.getAttribute("user");
			Questions q=(Questions) session.getAttribute("question");
			//map.put("question",question);
			answer.setQ(q);
			answer.setUser(u);
			
			Date d=new Date();
			answer.setCreatedon(d);
			answer.setEditedon(d);
			answersService.create(answer);
			map.put("message","Your answer has been placed.");
			return "user/success";
		}
		
	}
	
	
	@RequestMapping(value="/follow",method=RequestMethod.POST)
	public String follow(@RequestParam("id") long id,Map<String,Object> map,HttpSession session)
	{
		User us=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null || us.getUserId()==0)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			//User us=(User) session.getAttribute("user");
			
			Followers u=new Followers();
			u.setFollowedId(id);
			
			u.setFollowerId(us.getUserId());
			//post.setUserId(u.getUserId());
			
			
			
			followersService.addfollower(u);
			
			map.put("message","success");
			return "user/message";
		}
	}
	

	@RequestMapping(value="/allow",method=RequestMethod.POST)
	public String allow(@RequestParam("id") long id,Map<String,Object> map,HttpSession session)
	{
		User us=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null || us.getUserId()==0)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			//User us=(User) session.getAttribute("user");
			
			User u=userService.find(id);
			int v=u.getVerified()==1?0:1;
			u.setVerified(v);
			userService.update(u);
			
			
			
			map.put("message","success");
			return "user/message";
		}
	}
	
	
	
	@RequestMapping(value="/unfollow",method=RequestMethod.POST)
	public String unfollow(@RequestParam("id") long id,Map<String,Object> map,HttpSession session)
	{
		User us=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null || us.getUserId()==0)
		{
		
			
			return "redirect:/login";
		}
		else
		{
			//User us=(User) session.getAttribute("user");
			
			
			
			
			Followers fid=followersService.find(us.getUserId(),id);
			
			//System.out.print("Followers id="+fid);
			
			followersService.removefollower(fid);
			
			map.put("message","success");
			return "user/message";
		}
	}


}
