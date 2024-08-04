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
@Table(name="plasmainBloodBanks")
public class PlasmaInBloodBank {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name="number")
	private int Number;
	
	@ManyToOne
	@JoinColumn(name="blood_bank_id",nullable = false)
	private BloodBank bloodbanks;
	
	@ManyToOne
	@JoinColumn(name="blood_group_id",nullable = false)
	private BloodGroup bloodgroups;
	
	
	public PlasmaInBloodBank() {
		super();
	}

	public PlasmaInBloodBank(int id, int number) {
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
