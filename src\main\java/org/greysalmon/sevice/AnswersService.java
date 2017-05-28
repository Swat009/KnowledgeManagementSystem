package org.greysalmon.sevice;

import java.util.List;

import org.greysalmon.model.Answers;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;

public interface AnswersService 
{
	public void create(Answers a);
	public void update(Answers a);
	public Answers edit(Long id);
	public void delete(Long id);
	public Answers find(Long id);
	public List<Answers> getAll();
	public long findUser(Long id);
	public User getUser(Long id);
	public long findQuestion(Long id);
	public Questions getQuestion(Long id);

}
