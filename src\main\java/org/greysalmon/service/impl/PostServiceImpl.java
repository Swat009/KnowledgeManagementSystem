package org.greysalmon.service.impl;

import java.util.List;

import org.greysalmon.doa.PostDao;
import org.greysalmon.doa.UserDao;
import org.greysalmon.model.Post;
import org.greysalmon.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class PostServiceImpl implements PostService{

	
	@Autowired
	PostDao postDao;
	
	@Override
	public void create(Post post) {
		// TODO Auto-generated method stub
		postDao.create(post);
		
	}

	@Override
	public void update(Post post) {
		// TODO Auto-generated method stub
		postDao.create(post);
		
	}

	@Override
	public Post edit(Long id) {
		// TODO Auto-generated method stub
		return postDao.edit(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		postDao.delete(id);
		
	}

	@Override
	public Post find(Long id) {
		// TODO Auto-generated method stub
		return postDao.find(id);
	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return postDao.getAll();
	}

	@Override
	public long findUser(Long id) {
		// TODO Auto-generated method stub
		return postDao.findUser(id);
	}

}
