package com.app.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.BloodBank;
import com.app.entity.User;
import com.app.service.BloodBankService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class BloodBankController {

	@Autowired
	private BloodBankService bloodbankservice;
	
//	@PostMapping("/bloodbank")
//	public BloodBank createbloodbank(@RequestBody BloodBank bloodbank) {
//		return bloodbankservice.save(bloodbank);
//	}
	
	@GetMapping("/bloodbank")
	public List<BloodBank> getAllBloodBanks(){
		return bloodbankservice.findAll();
	}
	
	@DeleteMapping("/bloodbank/{id}")
	public ResponseEntity<BloodBank> deleteBloodBank(@PathVariable(value= "ID") int ID){
		Optional<BloodBank> bloodbank=bloodbankservice.findOne(ID);
		if(bloodbank == null) {
			return ResponseEntity.notFound().build();
		}
		bloodbankservice.delete(bloodbank.get());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/bloodbank/{ID}")
	public ResponseEntity<BloodBank> getbloodbankbyId(@PathVariable(value= "ID") int ID){
		Optional<BloodBank> bloodbank=bloodbankservice.findOne(ID);
		if(!bloodbank.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(bloodbank.get());
	}
	
	
	
	@PutMapping("/bloodbank/")
	public BloodBank updateBloodBank(@RequestBody BloodBank theBloodBank) {
		bloodbankservice.save(theBloodBank);
		return theBloodBank;
	}
	
	@PostMapping("/login-Bloodbank")
	public ResponseEntity<String> loginBloodBank(@RequestBody BloodBank bloodbanklogin,HttpServletRequest req){
		Optional<BloodBank> bloodbank = bloodbankservice.findByEmailIdAndPassword(bloodbanklogin.getEmailID(), bloodbanklogin.getPassword());
		if(!bloodbank.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credential..");
		}
		HttpSession session = req.getSession();
		session.setAttribute("user",bloodbank.get());
		return ResponseEntity.ok("Login Successfull...");
	}

	@PostMapping("/signup-BloodBank")
	public ResponseEntity<String> signupBloodBank(@RequestBody BloodBank bloodbankSignup){
		Optional<BloodBank> existingBloodBank=bloodbankservice.findByEmailIdAndPassword(bloodbankSignup.getEmailID(), bloodbankSignup.getPassword());
		if(existingBloodBank.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already in Use..");
		}
		bloodbankservice.save(bloodbankSignup);
		return ResponseEntity.status(HttpStatus.CREATED).body("signup Successfull..");
	}
}
