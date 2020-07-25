package spring.demo.service;

import spring.demo.model.UserDetails;

public interface UserService {

	public UserDetails saveUser(UserDetails userDetails);

	public UserDetails getUserById(Integer userId);

	public UserDetails getUserByEmailId(String emailId);

}
