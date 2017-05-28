package org.greysalmon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post
{
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String body;
	//private long userId;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	private String username;
	@Temporal(TemporalType.TIMESTAMP)
	Date createdon;
	@Temporal(TemporalType.TIMESTAMP)
	Date editedon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	public Date getEditedon() {
		return editedon;
	}
	public void setEditedon(Date editedon) {
		this.editedon = editedon;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
