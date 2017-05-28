package org.greysalmon.service.impl;

import java.util.List;

import org.greysalmon.doa.AnswersDao;
import org.greysalmon.doa.PostDao;
import org.greysalmon.model.Answers;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;
import org.greysalmon.sevice.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service("answersService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class AnswersServiceImpl implements AnswersService {

	
	@Autowired
	AnswersDao answersDao;
	@Override
	public void create(Answers a) {
		// TODO Auto-generated method stubo.
		
		answersDao.create(a);
		
	}

	@Override
	public void update(Answers a) {
		// TODO Auto-generated method stub
		
		answersDao.update(a);
		
	}

	@Override
	public Answers edit(Long id) {
		// TODO Auto-generated method stub
		return answersDao.edit(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		answersDao.delete(id);
		
	}

	@Override
	public Answers find(Long id) {
		// TODO Auto-generated method stub
		return answersDao.find(id);
	}

	@Override
	public List<Answers> getAll() {
		// TODO Auto-generated method stub
		return answersDao.getAll();
	}

	@Override
	public long findUser(Long id) {
		// TODO Auto-generated method stub
		return answersDao.findUser(id);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return answersDao.getUser(id);
	}

	@Override
	public long findQuestion(Long id) {
		// TODO Auto-generated method stub
		return answersDao.findQuestion(id);
	}

	@Override
	public Questions getQuestion(Long id) {
		// TODO Auto-generated method stub
		return answersDao.getQuestion(id);
	}

}
