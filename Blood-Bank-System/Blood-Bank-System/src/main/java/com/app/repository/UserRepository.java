package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.app.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "select * from users where  Email_ID= :Email_ID and Password= :Password",nativeQuery = true)
	User userLogin(String Email_ID, String Password );
}
