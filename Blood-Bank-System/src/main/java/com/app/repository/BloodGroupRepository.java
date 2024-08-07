package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.BloodGroup;

public interface BloodGroupRepository extends JpaRepository<BloodGroup, Integer>{

	@Query(value="select * from bloodgroups where Blood_Group_Name= :Blood_Group_Name",nativeQuery = true)
	List<BloodGroup> getbloodgroupdetails(String Blood_Group_Name);
	
}
