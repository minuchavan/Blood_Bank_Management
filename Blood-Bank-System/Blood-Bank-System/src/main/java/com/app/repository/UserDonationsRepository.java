package com.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.UserDonations;

public interface UserDonationsRepository extends JpaRepository<UserDonations, Integer>{

	@Query(value = "select * from userdonations where ID= :ID",nativeQuery = true)
	UserDonations getdonorbyId(int ID);
}
