package com.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.BloodBank;
import com.app.entity.User;

public interface BloodBankRepository extends JpaRepository<BloodBank, Integer>{

	@Query(value = "select * from bloodBanks where  Email_ID= :Email_ID and Password= :Password",nativeQuery = true)
	BloodBank bloodbankLogin(String Email_ID, String Password );
	
	@Query(value="select * from bloodBanks where address= :address ",nativeQuery = true)
	BloodBank getBloodBankByAddress(String address);
	
	@Query(value="select * from bloodBanks where Email_ID= :Email_ID",nativeQuery = true)
	BloodBank findOneByEmail(String Email_ID);
	
}
