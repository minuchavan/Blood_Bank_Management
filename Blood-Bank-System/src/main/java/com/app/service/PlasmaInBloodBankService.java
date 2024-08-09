package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.app.entity.PlasmaInBloodBank;

public interface PlasmaInBloodBankService {

    public PlasmaInBloodBank save(PlasmaInBloodBank plasmainbloodbank);
	
	public void delete(PlasmaInBloodBank plasmainbloodbank);
	
	public List<PlasmaInBloodBank> findAll();
	
	public Optional<PlasmaInBloodBank> findOne(int ID);
	
	public  List<PlasmaInBloodBank> findPlasmabyBloodBankId(int blood_bank_id);
	
	public void insertPlasmaInBloodBank(@Param("blood_bank_id") int blood_bank_id, @Param("blood_group_id") int blood_group_id, @Param("number") int number);
	
	public void updatePlasmaQuantity(@Param("number") int number, @Param("ID") int ID);
	
}
