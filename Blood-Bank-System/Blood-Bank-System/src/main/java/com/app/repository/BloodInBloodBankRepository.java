package com.app.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.BloodInBloodBank;

public interface BloodInBloodBankRepository extends JpaRepository<BloodInBloodBank, Integer> {

	@Query(value="select * from bloodInBloodBanks where ID= :ID",nativeQuery = true)
	List<BloodInBloodBank> getbloodInbloodbanks(int ID);
}
