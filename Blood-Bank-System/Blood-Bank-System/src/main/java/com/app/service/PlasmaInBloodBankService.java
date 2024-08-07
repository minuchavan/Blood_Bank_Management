package com.app.service;
import java.util.List;
import java.util.Optional;
import com.app.entity.PlasmaInBloodBank;

public interface PlasmaInBloodBankService {

    public PlasmaInBloodBank save(PlasmaInBloodBank plasmainbloodbank);
	
	public void delete(PlasmaInBloodBank plasmainbloodbank);
	
	public List<PlasmaInBloodBank> findAll();
	
	public Optional<PlasmaInBloodBank> findOne(int ID);
}
