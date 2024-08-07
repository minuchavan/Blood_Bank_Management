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
import com.app.entity.PlasmaInBloodBank;
import com.app.service.PlasmaInBloodBankService;

@RestController
@RequestMapping("/")
public class PlasmaInBloodBankController {


	@Autowired
	private PlasmaInBloodBankService plasmainbloodbankservice;
	
	@PostMapping("/plasmainbloodbank")
	public PlasmaInBloodBank createPlasmaInBloodBank(@RequestBody PlasmaInBloodBank plasmainbloodbank) {
		return plasmainbloodbankservice.save(plasmainbloodbank);
	}
	
	@GetMapping("/plasmainbloodbank")
	public List<PlasmaInBloodBank> getAllPlasmaInBloodBank(){
		return plasmainbloodbankservice.findAll();
	}
	
	@DeleteMapping("/plasmainbloodbank/{id}")
	public ResponseEntity<PlasmaInBloodBank> deletePlasmaInBloodBank(@PathVariable(value= "ID") int ID){
		Optional<PlasmaInBloodBank> plasmainbloodbank=plasmainbloodbankservice.findOne(ID);
		if(plasmainbloodbank == null) {
			return ResponseEntity.notFound().build();
		}
		plasmainbloodbankservice.delete(plasmainbloodbank.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/plasmainbloodbank/")
	public PlasmaInBloodBank updatePlasmaInBloodBank(@RequestBody PlasmaInBloodBank theplasmainbloodbank) {
		plasmainbloodbankservice.save(theplasmainbloodbank);
		return theplasmainbloodbank;
	}
}
