package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userdonations")
public class UserDonations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name="Numbers")
	private int Numbers;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User users;
	
	@ManyToOne
	@JoinColumn(name="blood_bank_id",nullable = false)
	private BloodBank bloodbanks;
	
	public UserDonations() {
		super();
	}

	public UserDonations(int iD,  int numbers) {
		super();
		ID = iD;
		//UserId = userId;
		//BloodBankID = bloodBankID;
		Numbers = numbers;
	}

	
	
	public int getNumbers() {
		return Numbers;
	}

	public void setNumbers(int numbers) {
		Numbers = numbers;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	
	

}
