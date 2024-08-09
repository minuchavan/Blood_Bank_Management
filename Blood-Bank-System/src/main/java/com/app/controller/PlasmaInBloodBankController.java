package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.PlasmaInBloodBank;
import com.app.service.PlasmaInBloodBankService;

@RestController
@RequestMapping("/api")
public class PlasmaInBloodBankController {


	@Autowired
	private PlasmaInBloodBankService plasmainbloodbankservice;
	
	@PostMapping("/plasmainbloodbank/{id}")
	public ResponseEntity<Map<String, Object>>updatePlasmaInBloodBank(@PathVariable("id") int ID,@RequestParam int number){
		  Map<String, Object> response = new HashMap<>();
	        try {
	             plasmainbloodbankservice.updatePlasmaQuantity(number, ID);
	            response.put("message", "Plasma quantity updated successfully.");
	            response.put("status", "success");
	            response.put("updatedNumber", number);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            response.put("message", "Error updating Plasma quantity: " + e.getMessage());
	            response.put("status", "error");
	            return ResponseEntity.status(500).body(response);
	        }
		}
	
	@PostMapping("/insertplasma") 
	public ResponseEntity<Map<String, Object>> insertPlasma( @RequestParam int blood_bank_id, @RequestParam int blood_group_id, @RequestParam int number) { 
		  Map<String, Object> response = new HashMap<>();
		try { 
			plasmainbloodbankservice.insertPlasmaInBloodBank(blood_bank_id, blood_group_id, number); 
			  response.put("message", "Plasma inserted successfully.");
		        response.put("status", "success");
		        return ResponseEntity.ok(response);
			
			} catch (Exception e) {
				 response.put("message", "Error inserting Plasma: " + e.getMessage());
			        response.put("status", "error");
			        return ResponseEntity.status(500).body(response); 
			} 
		}
	
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
