package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.BloodGroup;


public interface BloodGroupService {

    public BloodGroup save(BloodGroup bloodgroup);
	
	public void delete(BloodGroup bloodgroup);
	
	public List<BloodGroup> findAll();
	
	public Optional<BloodGroup> findOne(int ID);
}
