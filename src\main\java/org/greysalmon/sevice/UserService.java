package org.greysalmon.sevice;


import java.util.List;

import org.greysalmon.model.Post;
import org.greysalmon.model.User;
public interface UserService
{
	
	public void create(User user);
	public void update(User user);
	public User edit(Long userId);
	public void delete(Long userId);
	public User find(Long userId);
	public List<User> getAll();
	public User login(User user);
	public List<Post> getPosts(Long userId);
	

}
