package com.app.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.BloodBank;
import com.app.repository.BloodBankRepository;

@Service
public class BloodBankServiceImplementation implements BloodBankService {

	@Autowired
	BloodBankRepository bloodbankrepository;
	
	@Override
	public BloodBank save(BloodBank bloodbank) {
		return bloodbankrepository.save(bloodbank);
	}

	@Override
	public void delete(BloodBank bloodbank) {
		bloodbankrepository.delete(bloodbank);
	}

	@Override
	public List<BloodBank> findAll() {
		return bloodbankrepository.findAll();
	}

	@Override
	public Optional<BloodBank> findOne(int ID) {
		return bloodbankrepository.findById(ID);
	}

	@Override
	public Optional<BloodBank> findByEmailIdAndPassword(String Email_ID, String Password) {
		
		return bloodbankrepository.findByEmailIdAndPassword(Email_ID, Password);
	}

	
}
