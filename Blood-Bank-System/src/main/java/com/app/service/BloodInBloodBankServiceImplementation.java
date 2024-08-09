package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.BloodInBloodBank;
import com.app.repository.BloodInBloodBankRepository;

@Service
public class BloodInBloodBankServiceImplementation implements BloodInBloodBankService
{

	@Autowired
	BloodInBloodBankRepository bloodinbloodbankrepository;
	
	@Override
	public BloodInBloodBank save(BloodInBloodBank bloodinbloodbank) {
		return bloodinbloodbankrepository.save(bloodinbloodbank);
	}

	@Override
	public void delete(BloodInBloodBank bloodinbloodbank) {
		bloodinbloodbankrepository.delete(bloodinbloodbank);
		
	}

	@Override
	public List<BloodInBloodBank> findAll() {
		return bloodinbloodbankrepository.findAll();
	}

	@Override
	public Optional<BloodInBloodBank> findOne(int ID) {
		return bloodinbloodbankrepository.findById(ID);
	}

	@Override
	public List<BloodInBloodBank> findBloodbyBloodBankId(int blood_bank_id) {
		return bloodinbloodbankrepository.findBloodbyBloodBankId(blood_bank_id);
	}

	@Override
	public void insertBloodInBloodBank(int bloodBankId, int bloodType, int quantity) {
		bloodinbloodbankrepository.insertBloodInBloodBank(bloodBankId, bloodType, quantity);
		
	}

	@Override
	public void updateBloodQuantity(int number, int ID) {
		bloodinbloodbankrepository.updateBloodQuantity(number, ID);
		
	}

	

}
