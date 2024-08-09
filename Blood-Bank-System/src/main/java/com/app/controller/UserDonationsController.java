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
import com.app.entity.UserDonations;
import com.app.service.UserDonationsService;

@RestController
@RequestMapping("/api")
public class UserDonationsController {

	@Autowired
	private UserDonationsService userdonationservice;
	
	@GetMapping("userdonations/bloodbank/{blood_bank_id}")
	public ResponseEntity<List<UserDonations>> getUserDonationByBloodBankID(@PathVariable("blood_bank_id") int blood_bank_id){
		List<UserDonations> userdonations =userdonationservice.getUserDonationByBloodBankID(blood_bank_id);
		if(userdonations.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(userdonations);
		
	}
	
	  @PutMapping("/userdonations/update/{ID}")
	    public ResponseEntity<Map<String, Object>> updateUserDonationById(@PathVariable("ID") int ID, @RequestParam("number") int number) {
	        
	        Map<String, Object> response = new HashMap<>();
	        try {
	            int rowsUpdated = userdonationservice.UpdateUserDonationsByID(ID, number);

	            if (rowsUpdated > 0) {
	                response.put("message", "User donation updated successfully.");
	                response.put("status", "success");
	                return ResponseEntity.ok(response);
	            } else {
	                response.put("message", "User donation not found or not updated.");
	                response.put("status", "failure");
	                return ResponseEntity.status(404).body(response);
	            }
	        } catch (Exception e) {
	            response.put("message", "Error updating user donation: " + e.getMessage());
	            response.put("status", "error");
	            return ResponseEntity.status(500).body(response);
	        }
	}
	  
	  @GetMapping("/userdonations/user/{user_id}")
	  public ResponseEntity<List<UserDonations>> getUserDonationsByUserID(@PathVariable("user_id") int user_id){
		 List<UserDonations> userdonations =userdonationservice.getUserDonationsByUserID(user_id);
		 if(userdonations.isEmpty()) {
			 return ResponseEntity.noContent().build();
		 }
		 return ResponseEntity.ok(userdonations);
	  }
	
	@PostMapping("/insertuserdonations")
	  public ResponseEntity<Map<String, Object>> insertUserDonation(@RequestParam("Numbers") int Numbers , @RequestParam("user_id") int user_id ,@RequestParam("blood_bank_id") int blood_bank_id){
		  Map<String, Object> response=new HashMap<String, Object>();
		  try {
			  int userdonations= userdonationservice.insertUserDonation(Numbers, user_id, blood_bank_id);
			  response.put("message", "User Donation Inserted Successfully..");
			  response.put("status", "Success");
			  response.put("userDonations", userdonations);
			  return ResponseEntity.ok(response);
		  }catch (Exception e) {
			response.put("message", "Error On Inserting User Donation :"+e.getMessage());
			response.put("Status", "error");
			return ResponseEntity.status(500).body(response);
		}
	  }
	
	
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
	
	@PutMapping("/userdonations")
	public UserDonations updateUserDonations(@RequestBody UserDonations theuserdonations) {
		userdonationservice.save(theuserdonations);
		return theuserdonations;
	}
}
