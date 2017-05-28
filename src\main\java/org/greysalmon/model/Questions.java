package org.greysalmon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Questions
{
	@Id
	@GeneratedValue
	private long qid;
	private String title;
	private String body;
	//private long userId;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	private String username;
	
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity=Answers.class, mappedBy="q" , cascade=CascadeType.ALL)
	private List<Answers> answers;
	
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	public void setQid(long qid) {
		this.qid = qid;
	}
	@Temporal(TemporalType.TIMESTAMP)
	Date createdon;
	@Temporal(TemporalType.TIMESTAMP)
	Date editedon;
	public long getQid() {
		return qid;
	}
	public void setId(long qid) {
		this.qid = qid;
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
