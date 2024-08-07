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
@Table(name="blood_in_blood_banks")
public class BloodInBloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name="number")
	private int Number;
	
	@ManyToOne
	@JoinColumn(name="blood_bank_id",nullable = true)
	private BloodBank blood_banks;
	
	@ManyToOne
	@JoinColumn(name="blood_groupID",nullable = true)
	private BloodGroup bloodgroups;
	
	
	
	
	public BloodInBloodBank() {
		super();
	}

	public BloodInBloodBank(int id, int number) {
		super();
		ID=id;
		Number = number;
	}

	

	
	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	
	

}
