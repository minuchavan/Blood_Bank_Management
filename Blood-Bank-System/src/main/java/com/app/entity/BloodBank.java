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
@Table(name="blood_banks")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ID;
	@Column(name="blood_Bank_Name")
	private String BloodBankName;
	@Column(name="Email_ID",unique = true)
	private String EmailID;
	@Column(name="Password")
	private String Password;
	@Column(name="address")
	private String Address;
	@Column(name="contact")
	private String Contact;
	
	@JsonIgnore
	@OneToMany(mappedBy = "blood_banks")
	private List<BloodInBloodBank> bloodinbloodbanks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "blood_banks")
	private List<PlasmaInBloodBank> plasmainbloodbanks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "blood_banks")
	private List<UserDonations> userdonations;
	
	
	public BloodBank() {
		super();
	}

	public BloodBank(int iD, String bloodBankName, String emailID, String password,String address,String contact) {
		super();
		ID = iD;
		BloodBankName = bloodBankName;
		EmailID = emailID;
		Password = password;
		Address = address;
		Contact=contact;
	}
	
	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBloodBankName() {
		return BloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		BloodBankName = bloodBankName;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	

}
