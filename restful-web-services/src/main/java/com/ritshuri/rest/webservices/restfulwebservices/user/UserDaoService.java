package com.ritshuri.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 5;
	static {
		users.add(new User(1,"Adam", LocalDate.now().minusYears(30)));
		users.add(new User(2,"TIm", LocalDate.now().minusYears(25)));
		users.add(new User(3,"Steve", LocalDate.now().minusYears(52)));
		users.add(new User(4,"Hlulani", LocalDate.now().minusYears(40)));
		users.add(new User(5,"Huey", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if (user.getId() ==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public static User findOne(int id) {
		for (User user:users) {
			if (user.getId()==id)
				return user;
		}
		return null;
	}
	
	public static User deletebyIdForLoop(int id) {
		User removedUser=null;
		for (User user:users) {
			if (user.getId()==id) {
				users.remove(id);
				removedUser = user;
				}
		}
		return removedUser;
	}
	
	public static User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		User user=null;
		while(iterator.hasNext()) {
			user = iterator.next();
			if (user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
}
