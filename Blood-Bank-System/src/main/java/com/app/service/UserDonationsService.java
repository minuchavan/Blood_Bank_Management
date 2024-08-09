package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.app.entity.UserDonations;


public interface UserDonationsService {

public UserDonations save(UserDonations userdonations);
	
	public void delete(UserDonations userdonations);
	
	public List<UserDonations> findAll();
	
	public Optional<UserDonations> findOne(int ID);
	
	public int insertUserDonation(@Param("Numbers") int Numbers, @Param("user_id") int user_id , @Param("blood_bank_id") int blood_bank_id);
	
	public List<UserDonations> getUserDonationsByUserID(int user_id);
	
	public  int UpdateUserDonationsByID(int ID,int number);
	
	public List<UserDonations> getUserDonationByBloodBankID(int blood_bank_id);

	
}
