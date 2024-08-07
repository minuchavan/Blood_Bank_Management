
package com.app.service;
import java.util.List;
import java.util.Optional;
import com.app.entity.BloodBank;
public interface BloodBankService {
	
		public BloodBank save(BloodBank bloodbank);
		
		public void delete(BloodBank bloodbank);
		
		public List<BloodBank> findAll();
		
		public Optional<BloodBank> findOne(int ID);
		
		public Optional<BloodBank> findByEmailIdAndPassword(String Email_ID, String Password);
		
	

}
