package org.greysalmon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doc 
{
	@Id
	@GeneratedValue
	private long id;
	private String link;
	private String des;
	private String uploder;

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getUploder() {
		return uploder;
	}
	public void setUploder(String uploder) {
		this.uploder = uploder;
	}
	
}
