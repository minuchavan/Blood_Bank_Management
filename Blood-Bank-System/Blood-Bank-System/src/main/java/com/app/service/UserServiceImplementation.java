package com.app.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.User;
import com.app.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userrepository;
	
	public User save(User user) {
		return userrepository.save(user);
	}

	public void delete(User user) {
		userrepository.delete(user);
	}

	public List<User> findAll() {
		return userrepository.findAll();
	}

	public Optional<User> findOne(int ID) {
		return userrepository.findById(ID);
	}

}
