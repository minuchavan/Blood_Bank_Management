package com.app.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.BloodGroup;
import com.app.entity.User;
import com.app.repository.BloodGroupRepository;
import com.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userrepository;
	
	
	
//	@Autowired
//    private BloodGroupRepository bloodGroupRepository;
//
//    @Override
//    @Transactional
//    public User save(User user) {
//        if (user.getBloodgroups() != null) {
//            Optional<BloodGroup> bloodGroupOptional = bloodGroupRepository.findById(user.getBloodgroups().getID());
//            if (bloodGroupOptional.isPresent()) {
//                user.setBloodgroups(bloodGroupOptional.get());
//            } else {
//                throw new IllegalArgumentException("Invalid BloodGroup ID");
//            }
//        }
//        return userrepository.save(user);
//    }


	@Override
	public void delete(User user) {
		userrepository.delete(user);
	}

	@Override
	public List<User> findAll() {
		return userrepository.findAll();
	}

	public Optional<User> findOne(int ID) {
		return userrepository.findById(ID);
	}

	@Override
	public Optional<User> findByEmailIdAndPassword(String Email_ID, String Password) {
		// TODO Auto-generated method stub
		return userrepository.findByEmailIdAndPassword(Email_ID, Password);
	}

	@Override
	@Transactional
	public int updateuser(int Id, int blood_group_id) {
	
		return userrepository.updateuser(Id, blood_group_id);
	}

	@Override
	public User save(User user) {
		return userrepository.save(user);
	}


	

}
