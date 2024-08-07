package com.app.controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.BloodGroup;
import com.app.entity.User;
import com.app.service.BloodGroupService;
import com.app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice ;
	
	
	
//	/* save user */
//	@PostMapping("/user")
//	public User createUser(@RequestBody User user ) {
//		return userservice.save(user);
	
	
//}
//	@GetMapping("/user")
//	public List<User> getAllUsers(){
//		return userservice.findAll();
//	}
	
	@DeleteMapping("/user/{ID}")
	public ResponseEntity<User> deleteUser(@PathVariable(value= "ID") int ID){
		Optional<User> user=userservice.findOne(ID);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		userservice.delete(user.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User theUser) {
		userservice.save(theUser);
		return theUser;
	}
	
	@PutMapping("/userbybloodgroup")
	public ResponseEntity<String>  updateUserByBloodGroupID(@RequestParam int Id, @RequestParam int blood_group_id ) {
		userservice.updateuser(Id, blood_group_id);
		
		return ResponseEntity.ok("update successfully..");
		
	}
	
	
	
//	 @Autowired
//	    private BloodGroupService bloodGroupService; // Assuming you have a BloodGroupService
//
//	    @PutMapping("/user/{ID}")
//	    public ResponseEntity<User> updateUser(@PathVariable int ID, @RequestBody User user) {
//	        Optional<BloodGroup> bloodGroupOptional = bloodGroupService.findOne(user.getBloodgroups().getID());
//	        if (bloodGroupOptional.isPresent()) {
//	            user.setBloodgroups(bloodGroupOptional.get());
//	            User updatedUser = userservice.save(user);
//	            return ResponseEntity.ok(updatedUser);
//	        } else {
//	            return ResponseEntity.badRequest().build();
//	        }
//	    }
	
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User userlogin,HttpServletRequest req){
		Optional<User> user = userservice.findByEmailIdAndPassword(userlogin.getEmailId(), userlogin.getPassword());
		if(!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credential..");
		}
		HttpSession session = req.getSession();
		session.setAttribute("user",user.get());
		return ResponseEntity.ok("Login Successfull...");
	}

	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> signupUser(@RequestBody User userSignup){
		Optional<User> existingUser=userservice.findByEmailIdAndPassword(userSignup.getEmailId(), userSignup.getPassword());
		if(existingUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("message", "Email Already in Use.."));
		}
		 Map<String, Object> response = new HashMap<>();
		 User savedUser = userservice.save(userSignup);
		  response.put("message", "Signup Successful..");
		  response.put("ID ", savedUser.getId());
		 userservice.save(userSignup);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	
	
}
