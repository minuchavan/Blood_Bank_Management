package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bloodgroups")
public class BloodGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name="Blood_Group_Name")
	private String BloodGroupName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bloodgroups")
	private List<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bloodgroups")
	private List<BloodInBloodBank> bloodinbloodbanks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bloodgroups")
	private List<PlasmaInBloodBank> plasmainbloodbanks;
	
	
	public BloodGroup() {
		super();
	}

	public BloodGroup(int iD, String bloodGroupName) {
		super();
		ID = iD;
		BloodGroupName = bloodGroupName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBloodGroupName() {
		return BloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		BloodGroupName = bloodGroupName;
	}
	
	
	
	
	
	

}
