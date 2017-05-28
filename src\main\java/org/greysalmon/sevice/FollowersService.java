package org.greysalmon.sevice;

import java.util.List;

import org.greysalmon.model.Followers;
import org.greysalmon.model.Post;

public interface FollowersService 
{
	
	public List<Followers> getFollowers(long userid);
	public List<Followers> getFollowing(long userid);
	public void addfollower(Followers f);
	public void addfollowing(Long id);
	public void removefollower(Followers f);
	public void removefollowing(Long id);
	public List<Followers> getAll();
	public Followers find(long followerid,long followedid);

}
