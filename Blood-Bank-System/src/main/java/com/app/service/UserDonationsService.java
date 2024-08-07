package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.UserDonations;


public interface UserDonationsService {

public UserDonations save(UserDonations userdonations);
	
	public void delete(UserDonations userdonations);
	
	public List<UserDonations> findAll();
	
	public Optional<UserDonations> findOne(int ID);
}
