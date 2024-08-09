package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.PlasmaInBloodBank;
import com.app.repository.PlasmaInBloodBankRepository;

@Service
public class PlasmaInBloodBankServiceImplementaion implements PlasmaInBloodBankService {

	@Autowired
	PlasmaInBloodBankRepository plasmainbloodbankrepository;
	
	@Override
	public PlasmaInBloodBank save(PlasmaInBloodBank plasmainbloodbank) {
		return plasmainbloodbankrepository.save(plasmainbloodbank) ;
	}

	@Override
	public void delete(PlasmaInBloodBank plasmainbloodbank) {
		plasmainbloodbankrepository.delete(plasmainbloodbank);
		
	}

	@Override
	public List<PlasmaInBloodBank> findAll() {
		return plasmainbloodbankrepository.findAll();
	}

	@Override
	public Optional<PlasmaInBloodBank> findOne(int ID) {
		return plasmainbloodbankrepository.findById(ID);
	}

	@Override
	public List<PlasmaInBloodBank> findPlasmabyBloodBankId(int blood_bank_id) {
		
		return plasmainbloodbankrepository.findPlasmabyBloodBankId(blood_bank_id);
	}

	@Override
	public void insertPlasmaInBloodBank(int blood_bank_id, int blood_group_id, int number) {
		plasmainbloodbankrepository.insertPlasmaInBloodBank(blood_bank_id, blood_group_id, number);
		
	}

	@Override
	public void updatePlasmaQuantity(int number, int ID) {
		plasmainbloodbankrepository.updatePlasmaQuantity(number, ID);
		
	}

}
