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

import com.app.entity.BloodBank;
import com.app.entity.BloodInBloodBank;
import com.app.service.BloodInBloodBankService;

@RestController
@RequestMapping("/")
public class BloodInBloodBankController {

	@Autowired
	private BloodInBloodBankService bloodinbloodbankservice;
	
	@PostMapping("/bloodinbloodbank")
	public BloodInBloodBank createBloodInBloodBank(@RequestBody BloodInBloodBank bloodinbloodbank) {
		return bloodinbloodbankservice.save(bloodinbloodbank);
	}
	
	@GetMapping("/bloodinbloodbank")
	public List<BloodInBloodBank> getAllBloodInBloodBank(){
		return bloodinbloodbankservice.findAll();
	}
	
	@GetMapping("/bloodinbloodbankbyid/{blood_bank_id}")
	public List<BloodInBloodBank> getBloodFromBloodbankbybloodBankId(@PathVariable(value="blood_bank_id") int ID){
		
		return bloodinbloodbankservice.findBloodbyBloodBankId(ID);
		
	}
	
	
	@DeleteMapping("/bloodinbloodbank/{id}")
	public ResponseEntity<BloodInBloodBank> deleteBloodInBloodBank(@PathVariable(value= "ID") int ID){
		Optional<BloodInBloodBank> bloodinbloodbank=bloodinbloodbankservice.findOne(ID);
		if(bloodinbloodbank == null) {
			return ResponseEntity.notFound().build();
		}
		bloodinbloodbankservice.delete(bloodinbloodbank.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/bloodinbloodbank")
	public BloodInBloodBank updateBloodInBloodBank(@RequestBody BloodInBloodBank thebloodinbloodbank) {
		bloodinbloodbankservice.save(thebloodinbloodbank);
		return thebloodinbloodbank;
	}
	
	
	
}
