package org.greysalmon.doa;

import java.util.List;

import org.greysalmon.model.Doc;
import org.greysalmon.model.Post;
import org.greysalmon.model.User;

public interface DocDao 
{
	public void create(Doc d);
	public void update(Doc d);
	public Doc edit(Long id);
	public void delete(Long id);
	public Doc find(Long id);
	public List<Doc> getAll();
	


}
