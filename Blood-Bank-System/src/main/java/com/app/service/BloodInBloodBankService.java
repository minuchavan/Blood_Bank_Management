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
	
	public  void insertBloodInBloodBank(@Param("blood_bank_id") int bloodBankId, @Param("blood_groupID") int bloodType, @Param("number") int quantity);
	
}
