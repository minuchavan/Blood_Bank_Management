package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.UserDonations;
import com.app.repository.UserDonationsRepository;

@Service
public class UserDonationsServiceImplementation implements UserDonationsService{

	@Autowired
	UserDonationsRepository userdonationsrepository;
	
	@Override
	public UserDonations save(UserDonations userdonations) {
		return userdonationsrepository.save(userdonations);
	}

	@Override
	public void delete(UserDonations userdonations) {
		userdonationsrepository.delete(userdonations);
		
	}

	@Override
	public List<UserDonations> findAll() {
		return userdonationsrepository.findAll();
	}

	@Override
	public Optional<UserDonations> findOne(int ID) {
		return userdonationsrepository.findById(ID);
	}

}
