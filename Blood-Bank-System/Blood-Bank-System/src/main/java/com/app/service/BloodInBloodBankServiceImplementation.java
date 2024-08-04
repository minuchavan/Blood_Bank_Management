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
	BloodInBloodBankRepository bloodinbllodbankrepository;
	
	@Override
	public BloodInBloodBank save(BloodInBloodBank bloodinbloodbank) {
		return bloodinbllodbankrepository.save(bloodinbloodbank);
	}

	@Override
	public void delete(BloodInBloodBank bloodinbloodbank) {
		bloodinbllodbankrepository.delete(bloodinbloodbank);
		
	}

	@Override
	public List<BloodInBloodBank> findAll() {
		return bloodinbllodbankrepository.findAll();
	}

	@Override
	public Optional<BloodInBloodBank> findOne(int ID) {
		return bloodinbllodbankrepository.findById(ID);
	}

}
