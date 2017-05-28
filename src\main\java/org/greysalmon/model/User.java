package org.greysalmon.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class User 
{
	@Id
	@GeneratedValue
	private long userId;
	@Size(min=2,max=50)
	private String name;
	@Size(min=10,max=10)
	private String rollno;
	private String password;
	private int role;
	private int verified;
	private int points;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Questions.class, mappedBy="user" , cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Questions> questions;
	
	
	@OneToMany( targetEntity=Answers.class, mappedBy="user" , cascade=CascadeType.ALL)
	private List<Answers> ansers;
	
	@OneToMany( fetch = FetchType.EAGER,targetEntity=Post.class, mappedBy="user" , cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Post> posts;
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getPassword() {
		return password;
	}
	
	
	public List<Post> getPosts()
	{
		return posts;
	}
	
	
	public List<Questions> getQuestions()
	{
		return questions;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
