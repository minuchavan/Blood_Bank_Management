package com.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.UserDonations;

import jakarta.transaction.Transactional;

public interface UserDonationsRepository extends JpaRepository<UserDonations, Integer>{

	@Modifying
	@Transactional
	@Query(value="insert into userdonations (Numbers,user_id,blood_bank_id) values (:Numbers, :user_id, :blood_bank_id)",nativeQuery = true)
	int insertUserDonation(@Param("Numbers") int Numbers, @Param("user_id") int user_id , @Param("blood_bank_id") int blood_bank_id);
	
	@Query(value = "select * from userdonations where user_id= :user_id",nativeQuery = true)
	List<UserDonations> getUserDonationsByUserID(int user_id);
	
	@Modifying
	@Transactional
	@Query(value="update userdonations set Numbers= :Numbers where ID= :ID",nativeQuery = true)
	 int UpdateUserDonationsByID(int ID,int Numbers);
	
	@Query(value = "select * from userdonations where  blood_bank_id= :blood_bank_id",nativeQuery = true)
	List<UserDonations> getUserDonationByBloodBankID(int blood_bank_id);
}
