package com.ritshuri.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import org.springframework.stereotype.Component;

@Component
public class UserPostService {
	private static List<UserPost> posts = new ArrayList<>();
	
	
	static {
			posts.add(new UserPost(1,1,"Hello Brother", new Date()));
			posts.add(new UserPost(1,2,"Hello Sister", new Date()));
			posts.add(new UserPost(1,3,"Hello Uncle", new Date()));
			posts.add(new UserPost(1,4,"Hello Father", new Date()));
			posts.add(new UserPost(1,5,"Hello Mamar", new Date()));
	}
	
	
	public List<UserPost> findAll(){
		return posts;
	}
	
	/*public UserPost save(UserPost post) {
		if (post. ==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}*/
	
	public static UserPost findOne(int userId, int id) {
		for (UserPost post:posts) {
			if (post.getOwnerId()==userId && post.getUserPostID()==id)
				return post;
		}
		return null;
	}
}
