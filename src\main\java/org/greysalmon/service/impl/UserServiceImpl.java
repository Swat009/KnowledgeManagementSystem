package org.greysalmon.service.impl;

import java.util.List;

import org.greysalmon.doa.UserDao;
import org.greysalmon.model.Post;
import org.greysalmon.model.User;
import org.greysalmon.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public void create(User user) {
		userDao.create(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		userDao.update(user);
	}

	@Override
	public User edit(Long userId) {
		// TODO Auto-generated method stub
		return userDao.edit(userId);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		userDao.delete(userId);
	}

	@Override
	public User find(Long userId) {
		// TODO Auto-generated method stub
		return userDao.find(userId);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	
	@Override
	public List<Post> getPosts(Long userId) {
		// TODO Auto-generated method stub
		
		
		return userDao.getPosts(userId);
	}

}
