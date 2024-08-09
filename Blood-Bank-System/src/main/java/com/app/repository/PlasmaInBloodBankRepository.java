package com.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.BloodInBloodBank;
import com.app.entity.PlasmaInBloodBank;

import jakarta.transaction.Transactional;

 public interface PlasmaInBloodBankRepository extends JpaRepository<PlasmaInBloodBank, Integer>{

	 @Query(value="select * from plasmain_blood_banks where ID= :ID",nativeQuery = true)
	 PlasmaInBloodBank getplasmaInbloodbanks(int ID);
	
	 @Query(value="select * from plasmain_blood_banks where blood_bank_id= :blood_bank_id",nativeQuery = true)
	 List<PlasmaInBloodBank> findPlasmabyBloodBankId(int blood_bank_id);
	
	 @Modifying
     @Transactional
     @Query(value = "insert into plasmain_blood_banks (blood_bank_id, blood_group_id, number) VALUES (:blood_bank_id, :blood_group_id, :number)", nativeQuery = true)
     void insertPlasmaInBloodBank(@Param("blood_bank_id") int blood_bank_id, @Param("blood_group_id") int blood_group_id, @Param("number") int number);
	
	 @Modifying
	 @Transactional
	 @Query(value = "update plasmain_blood_banks set number = :number where ID= :ID", nativeQuery = true)
	 void updatePlasmaQuantity(@Param("number") int number, @Param("ID") int ID);
	
}
