package org.greysalmon.doa.impl;

import java.util.List;

import org.greysalmon.doa.PostDao;
import org.greysalmon.doa.QuestionsDao;
import org.greysalmon.model.Answers;
import org.greysalmon.model.Post;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("questionsDao")
public class QuestionsDaoImpl implements QuestionsDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(Questions q) {
		
		currentSession().save(q);
	}

	@Override
	public void update(Questions q) {
		// TODO Auto-generated method stub
		currentSession().update(q);
		
	}

	@Override
	public Questions edit(Long id) {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		currentSession().delete(id);
		
	}

	@Override
	public Questions find(Long id) {
		// TODO Auto-generated method stub
		return (Questions)currentSession().get(Questions.class,id);
	}

	@Override
	public List<Questions> getAll() {
		// TODO Auto-generated method stub
		
		Criteria crit = currentSession().createCriteria(Questions.class).addOrder( Order.desc("editedon") );
		List<Questions> l=crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return l;
		
	}

	@Override
	public long findUser(Long id) {
		Questions q=find(id);
		return q.getUser().getUserId();
	}
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		
		Questions q=find(id);
		return (User) q.getUser();
		
	}
	@Override
	public List<Answers> getAnwers(Long qid) {
		// TODO Auto-generated method stub
		
		Questions q=find(qid);
		
		return (List<Answers>) q.getAnswers();
		//return null;
	}
	

}
