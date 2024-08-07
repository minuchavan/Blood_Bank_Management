package com.app.service;
import java.util.List;
import java.util.Optional;
import com.app.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public void delete(User user);
	
	public List<User> findAll();
	
	public Optional<User> findOne(int ID);
	
	public Optional<User> findByEmailIdAndPassword(String Email_ID, String Password);
	
	public int updateuser( int Id, int blood_group_id);
	
}
