package org.greysalmon.service.impl;

import java.util.List;

import org.greysalmon.doa.PostDao;
import org.greysalmon.doa.QuestionsDao;
import org.greysalmon.doa.UserDao;
import org.greysalmon.model.Post;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;
import org.greysalmon.sevice.PostService;
import org.greysalmon.sevice.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("questionsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class QuestionsServiceImpl implements QuestionsService{

	
	@Autowired
	QuestionsDao questionsDao;
	
	@Override
	public void create(Questions q) {
		// TODO Auto-generated method stub
		questionsDao.create(q);
		
	}

	@Override
	public void update(Questions q) {
		// TODO Auto-generated method stub
		questionsDao.create(q);
		
	}

	@Override
	public Questions edit(Long id) {
		// TODO Auto-generated method stub
		return questionsDao.edit(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		questionsDao.delete(id);
		
	}

	@Override
	public Questions find(Long id) {
		// TODO Auto-generated method stub
		return questionsDao.find(id);
	}

	@Override
	public List<Questions> getAll() {
		// TODO Auto-generated method stub
		return questionsDao.getAll();
	}

	@Override
	public long findUser(Long id) {
		// TODO Auto-generated method stub
		return questionsDao.findUser(id);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return questionsDao.getUser(id);
	}

}
