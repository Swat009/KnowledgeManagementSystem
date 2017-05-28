package org.greysalmon.service.impl;

import java.util.List;

import org.greysalmon.doa.FollowersDao;
import org.greysalmon.doa.PostDao;
import org.greysalmon.model.Followers;
import org.greysalmon.model.Post;
import org.greysalmon.sevice.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("followersService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class FollowersServiceImpl implements FollowersService 
{

	
	@Autowired
	FollowersDao followersDao;
	
	
	@Override
	public List<Followers> getFollowers(long userid) {
		// TODO Auto-generated method stub
		return followersDao.getFollowers(userid);
	}

	@Override
	public List<Followers> getFollowing(long userid) {
		// TODO Auto-generated method stub
		return followersDao.getFollowers(userid);
	}

	@Override
	public void addfollower(Followers f) {
		// TODO Auto-generated method stub
		
		followersDao.addfollower(f);
		
	}

	@Override
	public void addfollowing(Long id) {
		// TODO Auto-generated method stub
		
		followersDao.addfollowing(id);
		
	}

	@Override
	public void removefollower(Followers f) {
		// TODO Auto-generated method stub
		
		followersDao.removefollower(f);
		
	}

	@Override
	public void removefollowing(Long Id) {
		// TODO Auto-generated method stub
		
		
		followersDao.removefollowing(Id);
		
	}
	
	@Override
	public Followers find(long followerid,long followedid)
	{
		return followersDao.find(followerid,followedid);
	}
	
	@Override
	public List<Followers> getAll() {
		
		return followersDao.getAll();
	}
	

}
