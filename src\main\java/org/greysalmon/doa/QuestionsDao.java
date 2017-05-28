package org.greysalmon.doa;

import java.util.List;

import org.greysalmon.model.Answers;
import org.greysalmon.model.Post;
import org.greysalmon.model.Questions;
import org.greysalmon.model.User;

public interface QuestionsDao
{
	public void create(Questions q);
	public void update(Questions q);
	public Questions edit(Long id);
	public void delete(Long id);
	public Questions find(Long id);
	public List<Questions> getAll();
	public long findUser(Long id);
	public User getUser(Long id);
	public List<Answers> getAnwers(Long qid);

}
