package com.app.service;
import java.util.List;
import java.util.Optional;
import com.app.entity.User;

public interface UserService {
	
	public User save(User user);
	
	public void delete(User user);
	
	public List<User> findAll();
	
	public Optional<User> findOne(int ID);
}
