package org.greysalmon.sevice;

import java.util.List;

import org.greysalmon.model.Post;

public interface PostService
{
	public void create(Post post);
	public void update(Post post);
	public Post edit(Long id);
	public void delete(Long id);
	public Post find(Long id);
	public List<Post> getAll();
	public long findUser(Long id);

}
