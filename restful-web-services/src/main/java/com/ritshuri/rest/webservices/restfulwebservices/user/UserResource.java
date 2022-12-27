package com.ritshuri.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {
	//retrieveAllUsers
	//GET /users
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserPostService postService;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	//retreiveOneUser
	//GET /users/{id}
	
	@GetMapping(path="/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		User foundUser = UserDaoService.findOne(id);
		if (foundUser == null) {
			throw new UserNotFoundException("User with iD "+id+ " Was not Found");
		}
		EntityModel<User> model = EntityModel.of(foundUser);
		
		WebMvcLinkBuilder  linkToUser = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		model.add(linkToUser.withRel("Ti User hinkwato"));
		return model;
	}
	
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/users/posts")
	public List<UserPost> retrieveAllPosts() {
		return postService.findAll();
	}

	@GetMapping(path="/users/{userId}/posts/{id}")
	public UserPost retrieveOnepost(@PathVariable int userId, @PathVariable int id) {
		UserPost foundPost = UserPostService.findOne(userId, id);
		if (foundPost == null) {
			throw new PostNotFoundException("This post with ID "+id+ " for User with ID "+ userId+ " Was Not Found");
		}
		return foundPost;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = UserDaoService.deleteById(id);
		if (deletedUser == null) {
			throw new UserNotFoundException("User with iD "+id+ " Was not Found");
		}
	}
	
	
}
