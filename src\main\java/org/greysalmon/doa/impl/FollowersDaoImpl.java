package org.greysalmon.doa.impl;
import java.util.List;

import org.greysalmon.doa.FollowersDao;
import org.greysalmon.model.Followers;
import org.greysalmon.model.Post;
import org.greysalmon.model.User;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("followersDao")
public class FollowersDaoImpl implements FollowersDao{
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Followers> getFollowers(long userid) {
		// TODO Auto-generated method stub
		
		
		/*Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from org.greysalmon.model.Followers as c where c.followedId=? ";
		List<Followers> f = null;
		try
		{
			Query query=session.createQuery(hql);
			query.setParameter(0,userid);
			f=(List<Followers>)query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	public List<Followers> getFollowing(long userid) {
		// TODO Auto-generated method stub
		
		/*Session session=sessionFactory.openSession();
		session.setCacheMode(CacheMode.REFRESH);
		Transaction tx=session.beginTransaction();
	
		String hql="from org.greysalmon.model.Followers ";
		List<Followers> f = null;
		try
		{
			System.err.println("Test");
			Query query=session.createQuery(hql);
		   
			f=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			System.err.println("Test again");
			
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		*/
		//System.out.println("Follower test="+f.toString());
		return null;
	
	}

	@Override
	public void addfollower(Followers f) 
	{
				
		currentSession().save(f);
		
	}

	@Override
	public void addfollowing(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removefollower(Followers f) {
		// TODO Auto-generated method stub
		currentSession().delete(f);
		
	}
	
	@Override
	public Followers find(long followerid,long followedid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from org.greysalmon.model.Followers as c where c.followerId=? and c.followedId=? ";
		Followers follow=null;
		try
		{
			Query query=session.createQuery(hql);
			query.setParameter(0,followerid);
			query.setParameter(1,followedid);
			follow=(Followers) query.uniqueResult();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			System.err.println("Error");
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
			
		return follow;
	}
	
	@Override
	public List<Followers> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(Followers.class).list();
	}


	@Override
	public void removefollowing(Long id) {
		// TODO Auto-generated method stub
		
	}

}
