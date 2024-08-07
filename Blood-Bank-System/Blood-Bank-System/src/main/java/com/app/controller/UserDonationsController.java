package com.app.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.UserDonations;
import com.app.service.UserDonationsService;

@RestController
@RequestMapping("/")
public class UserDonationsController {

	@Autowired
	private UserDonationsService userdonationservice;
	
	@PostMapping("/userdonations")
	public UserDonations createUserDonations(@RequestBody UserDonations userdonations) {
		return userdonationservice.save(userdonations);
	}
	
	@GetMapping("/userdonations")
	public List<UserDonations> getAllUserDonations(){
		return userdonationservice.findAll();
	}
	
	@DeleteMapping("/userdonations/{id}")
	public ResponseEntity<UserDonations> deleteUserDonations(@PathVariable(value= "ID") int ID){
		Optional<UserDonations> userdonations=userdonationservice.findOne(ID);
		if(userdonations == null) {
			return ResponseEntity.notFound().build();
		}
		userdonationservice.delete(userdonations.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/userdonations/")
	public UserDonations updateUserDonations(@RequestBody UserDonations theuserdonations) {
		userdonationservice.save(theuserdonations);
		return theuserdonations;
	}
}
