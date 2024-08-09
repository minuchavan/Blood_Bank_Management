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
import com.app.entity.BloodInBloodBank;
import com.app.service.BloodInBloodBankService;

@RestController
@RequestMapping("/api")
public class BloodInBloodBankController {

	@Autowired
	private BloodInBloodBankService bloodinbloodbankservice;
	
	@PostMapping("/bloodinbloodbank/{id}")
	public ResponseEntity<Map<String, Object>>updateBloodInBloodBank(@PathVariable("id") int ID,@RequestParam int number){
		  Map<String, Object> response = new HashMap<>();
	        try {
	             bloodinbloodbankservice.updateBloodQuantity(number, ID);
	            response.put("message", "Blood quantity updated successfully.");
	            response.put("status", "success");
	            response.put("updatedNumber", number);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            response.put("message", "Error updating blood quantity: " + e.getMessage());
	            response.put("status", "error");
	            return ResponseEntity.status(500).body(response);
	        }
		}
	
	@PostMapping("/bloodinbloodbank")
	public BloodInBloodBank createBloodInBloodBank(@RequestBody BloodInBloodBank bloodinbloodbank) {
		return bloodinbloodbankservice.save(bloodinbloodbank);
	}   
	
	@PostMapping("/insert") 
	public ResponseEntity<Map<String, Object>> insertBlood( @RequestParam int blood_bank_id, @RequestParam int blood_groupID, @RequestParam int number) { 
		  Map<String, Object> response = new HashMap<>();
		try { 
			bloodinbloodbankservice.insertBloodInBloodBank(blood_bank_id, blood_groupID, number); 
			  response.put("message", "Blood inserted successfully.");
		        response.put("status", "success");
		        return ResponseEntity.ok(response);
			
			} catch (Exception e) {
				 response.put("message", "Error inserting blood: " + e.getMessage());
			        response.put("status", "error");
			        return ResponseEntity.status(500).body(response); 
			} 
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
	public ResponseEntity<BloodInBloodBank> deleteBloodInBloodBank(@PathVariable(value= "id") int ID){
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
