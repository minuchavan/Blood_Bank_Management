package com.app.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.BloodInBloodBank;

import jakarta.transaction.Transactional;

public interface BloodInBloodBankRepository extends JpaRepository<BloodInBloodBank, Integer> {

	@Query(value="select * from blood_in_blood_banks where blood_bank_id= :blood_bank_id",nativeQuery = true)
	List<BloodInBloodBank> findBloodbyBloodBankId(int blood_bank_id);
	
	
	@Modifying
    @Transactional
    @Query(value = "insert into blood_in_blood_banks (blood_bank_id, blood_groupID, number) VALUES (:blood_bank_id, :blood_groupID, :number)", nativeQuery = true)
    void insertBloodInBloodBank(@Param("blood_bank_id") int bloodBankId, @Param("blood_groupID") int bloodType, @Param("number") int quantity);
	
	
}
