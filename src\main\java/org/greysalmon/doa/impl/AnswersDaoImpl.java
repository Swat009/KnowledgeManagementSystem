package org.greysalmon.doa.impl;

import java.util.List;

import org.greysalmon.doa.AnswersDao;
import org.greysalmon.model.Answers;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("answersDao")
public class AnswersDaoImpl implements AnswersDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Answers a) {
		// TODO Auto-generated method stub
		
		currentSession().save(a);
		
	}

	@Override
	public void update(Answers a) {
		// TODO Auto-generated method stub
		
		currentSession().update(a);
		
		
	}

	@Override
	public Answers edit(Long id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		currentSession().delete(id);
		
	}

	@Override
	public Answers find(Long id) {
		// TODO Auto-generated method stub
		return (Answers)currentSession().get(Answers.class,id);
	}

	@Override
	public List<Answers> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findUser(Long id) {
		// TODO Auto-generated method stub
		
		Answers q=find(id);
		return q.getUser().getUserId();
	
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		Answers q=find(id);
		return (User) q.getUser();
	}

	@Override
	public long findQuestion(Long id) {
		// TODO Auto-generated method stub

		Answers q=find(id);
		return q.getUser().getUserId();
		//return 0;
	}

	@Override
	public Questions getQuestion(Long id) {
		// TODO Auto-generated method stub
		
		Answers q=find(id);
		return (Questions) q.getQ();
		//return null;
	}

	

}
