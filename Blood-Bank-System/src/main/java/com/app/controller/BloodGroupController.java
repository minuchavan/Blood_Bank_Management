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
import com.app.entity.BloodGroup;
import com.app.service.BloodGroupService;

@RestController
@RequestMapping("/api")
public class BloodGroupController {

	@Autowired
	private BloodGroupService bloodgroupservice;
	
//	@PostMapping("/bloodgroup")
//	public BloodGroup createbloodgroup(@RequestBody BloodGroup bloodgroup) {
//		return bloodgroupservice.save(bloodgroup);
//	}
	
	@GetMapping("/bloodgroup")
	public List<BloodGroup> getAllBloodGroup(){
		return bloodgroupservice.findAll();
	}
	
	@GetMapping("/bloodgroup/{ID}")
	public ResponseEntity<BloodGroup> getbloodgroupbyId(@PathVariable(value= "ID") int ID){
		Optional<BloodGroup> bloodgroup=bloodgroupservice.findOne(ID);
		if(!bloodgroup.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(bloodgroup.get());
	}
	
//	@DeleteMapping("/bloodgroup/{id}")
//	public ResponseEntity<BloodGroup> deleteBloodGroup(@PathVariable(value= "ID") int ID){
//		Optional<BloodGroup> bloodgroup=bloodgroupservice.findOne(ID);
//		if(bloodgroup == null) {
//			return ResponseEntity.notFound().build();
//		}
//		bloodgroupservice.delete(bloodgroup.get());
//		return ResponseEntity.ok().build();
//	}
	
//	@PutMapping("/bloodgroup/")
//	public BloodGroup updateBloodGroup(@RequestBody BloodGroup thebloodgroup) {
//		bloodgroupservice.save(thebloodgroup);
//		return thebloodgroup;
//	}
	
}
