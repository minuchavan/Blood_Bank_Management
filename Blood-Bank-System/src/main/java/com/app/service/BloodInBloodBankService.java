package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.app.entity.BloodBank;
import com.app.entity.BloodInBloodBank;

public interface BloodInBloodBankService {


    public BloodInBloodBank save(BloodInBloodBank bloodinbloodbank);
	
	public void delete(BloodInBloodBank bloodinbloodbank);
	
	public List<BloodInBloodBank> findAll();
	
	public Optional<BloodInBloodBank> findOne(int ID);
	
	public List<BloodInBloodBank>findBloodbyBloodBankId(int blood_bank_id);
	
	public  void insertBloodInBloodBank(@Param("blood_bank_id") int blood_bank_id, @Param("blood_groupID") int blood_groupID, @Param("number") int number);

	public void updateBloodQuantity(@Param("number") int number, @Param("ID") int ID);
}
