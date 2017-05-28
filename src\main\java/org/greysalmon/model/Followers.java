package org.greysalmon.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Followers 
{
	@Id
	@GeneratedValue
	private long Id;
	
	private long followerId;
	
	private long followedId;
	
	
	public long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(long followerId) {
		this.followerId = followerId;
	}

	public long getFollowedId() {
		return followedId;
	}

	public void setFollowedId(long followedId) {
		this.followedId = followedId;
	}
	
	public long getId() {
		return Id;
	}
	
	
	
	
	

}
