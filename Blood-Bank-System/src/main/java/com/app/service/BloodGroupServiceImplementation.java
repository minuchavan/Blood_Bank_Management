package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.BloodGroup;
import com.app.repository.BloodGroupRepository;

@Service
public class BloodGroupServiceImplementation implements BloodGroupService{

	@Autowired
	BloodGroupRepository bloodgrouprepository;
	
	@Override
	public BloodGroup save(BloodGroup bloodgroup) {
		return bloodgrouprepository.save(bloodgroup);
	}

	@Override
	public void delete(BloodGroup bloodgroup) {
		bloodgrouprepository.delete(bloodgroup);
	}

	@Override
	public List<BloodGroup> findAll() {
		return bloodgrouprepository.findAll();
	}

	@Override
	public Optional<BloodGroup> findOne(int ID) {
		return bloodgrouprepository.findById(ID);
	}

	public void saveOrUpdate(BloodGroup bloodGroup) {
		bloodgrouprepository.save(bloodGroup);
		
	}

}
