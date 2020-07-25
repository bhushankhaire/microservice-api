package spring.demo.service;

import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.entity.User;
import spring.demo.model.UserDetails;
import spring.demo.repository.UserRepository;
import spring.demo.ulti.RecordNotFoundException;
import spring.demo.ulti.TechnicalException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	Logger logger;

	@Override
	public UserDetails saveUser(UserDetails ud) {

		if (ud.getUserId() != null && repository.findById(ud.getUserId()).isPresent()) {
			throw new RuntimeException("User already exists");
		}
		try {
			User user = new User(ud.getUserId(), ud.getUserName(), ud.getMobileNumber(), ud.getEmailId());
			user = repository.save(user);
			ud.setUserId(user.getUserId());
		} catch (Exception ex) {
			logger.log(Level.ERROR, " in saveUser method: ", ex);
			throw new TechnicalException("Internal Server Error");
		}
		return ud;
	}

	@Override
	public UserDetails getUserById(Integer userId) {
		Optional<User> user = repository.findById(userId);
		if (!user.isPresent()) {
			throw new RecordNotFoundException("User doesnot exists");
		}
		UserDetails ud = new UserDetails(user.get().getUserId(), user.get().getUserName(), user.get().getMobileNumber(),
				user.get().getEmailId());

		return ud;
	}

	@Override
	public UserDetails getUserByEmailId(String emailId) {
		Optional<User> user = repository.findByEmailId(emailId);
		if (!user.isPresent()) {
			throw new RecordNotFoundException("User doesnot exists");
		}
		UserDetails ud = new UserDetails(user.get().getUserId(), user.get().getUserName(), user.get().getMobileNumber(),
				user.get().getEmailId());
		return ud;
	}

}
