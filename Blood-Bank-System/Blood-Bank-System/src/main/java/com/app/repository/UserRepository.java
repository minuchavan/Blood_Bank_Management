package com.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "select * from users where  Email_ID= :Email_ID and Password= :Password",nativeQuery = true)
	Optional<User> findByEmailIdAndPassword(String Email_ID, String Password);
	
	
    @Query(value="update users with blood_group_id = : blood_group_id where userID= : Id",nativeQuery=true)
	int updateuser( int Id, int blood_group_id);
	
	
}
