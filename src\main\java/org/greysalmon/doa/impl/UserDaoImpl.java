package org.greysalmon.doa.impl;
import java.util.List;

import org.greysalmon.doa.UserDao;
import org.greysalmon.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
		currentSession().save(user);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		currentSession().update(user);
		
	}

	@Override
	public User edit(Long userId) {
		// TODO Auto-generated method stub
		return find(userId);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		
		currentSession().delete(userId);
		
	}

	@Override
	public User find(Long userId) {
		// TODO Auto-generated method stub
		return (User)currentSession().get(User.class,userId);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(User.class).list();
	}
	@Override
	public User login(User user)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from org.greysalmon.model.User as c where c.rollno=? and c.password=? ";
		
		try
		{
			Query query=session.createQuery(hql);
			query.setParameter(0,user.getRollno());
			query.setParameter(1,user.getPassword());
			user=(User) query.uniqueResult();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
			
		return user;
	}

}
