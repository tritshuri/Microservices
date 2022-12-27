package com.ritshuri.rest.webservices.restfulwebservices.user;

import java.util.Date;



public class UserPost {
	
	private String post;
	private Integer ownerId;
	private Date   created_date;
	private int    userPostID;
	private String ownerName;
	
	public UserPost(Integer ownerId,Integer postId, String post, Date created_date) {
		super();
		this.post = post;
		this.ownerId = ownerId;
		this.created_date = created_date;
		this.userPostID = postId;
		this.ownerName = UserDaoService.findOne(ownerId).getName();
	}
	
	public String getVito() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwner(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getUserPostID() {
		return userPostID;
	}
	public void setUserPostID(int userPostID) {
		this.userPostID = userPostID;
	}

}
