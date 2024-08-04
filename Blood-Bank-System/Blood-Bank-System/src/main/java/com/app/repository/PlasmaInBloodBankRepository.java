package com.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.PlasmaInBloodBank;

 public interface PlasmaInBloodBankRepository extends JpaRepository<PlasmaInBloodBank, Integer>{

	@Query(value="select * from plasmainBloodBanks where ID= :ID",nativeQuery = true)
	PlasmaInBloodBank getplasmaInbloodbanks(int ID);
}
