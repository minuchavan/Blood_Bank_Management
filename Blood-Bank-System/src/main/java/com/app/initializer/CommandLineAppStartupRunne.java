package com.app.initializer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.entity.BloodGroup;
import com.app.service.BloodGroupServiceImplementation;

@Component
public class CommandLineAppStartupRunne implements CommandLineRunner {
	
	@Autowired
    BloodGroupServiceImplementation bloodGroupServiceImplementationntation;

    @Override
    public void run(String... args) throws Exception {
       List<BloodGroup> bloodGroups = List.of(
            new BloodGroup(1, "A+"),
            new BloodGroup(2, "B+"),
            new BloodGroup(3, "AB+"),
            new BloodGroup(4, "O+"),
            new BloodGroup(5, "A-"),
            new BloodGroup(6, "B-"),
            new BloodGroup(7, "AB-"),
            new BloodGroup(8, "O-"),
            new BloodGroup(9, "Rh")
        );

        for (BloodGroup bloodGroup : bloodGroups) {
            bloodGroupServiceImplementationntation.saveOrUpdate(bloodGroup);
        }

    }

}
