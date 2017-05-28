package org.greysalmon.doa.impl;

import java.util.List;

import org.greysalmon.doa.PostDao;
import org.greysalmon.model.Post;
import org.greysalmon.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postDao")
public class PostDaoImpl implements PostDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(Post post) {
		
		currentSession().save(post);
	}

	@Override
	public void update(Post post) {
		// TODO Auto-generated method stub
		currentSession().update(post);
		
	}

	@Override
	public Post edit(Long id) {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		currentSession().delete(id);
		
	}

	@Override
	public Post find(Long id) {
		// TODO Auto-generated method stub
		return (Post)currentSession().get(Post.class,id);
	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		
		Criteria crit = currentSession().createCriteria(Post.class).addOrder( Order.desc("editedon") );
		List<Post> l=crit.list();
		return l;
		
	}

	@Override
	public long findUser(Long id) {
		Post post=find(id);
		return post.getUser().getUserId();
	}
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		
		Post post=find(id);
		return (User) post.getUser();
		
	}
	

}
