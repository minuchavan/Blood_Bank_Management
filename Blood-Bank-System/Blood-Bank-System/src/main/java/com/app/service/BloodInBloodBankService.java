package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.BloodInBloodBank;

public interface BloodInBloodBankService {


    public BloodInBloodBank save(BloodInBloodBank bloodinbloodbank);
	
	public void delete(BloodInBloodBank bloodinbloodbank);
	
	public List<BloodInBloodBank> findAll();
	
	public Optional<BloodInBloodBank> findOne(int ID);
}
