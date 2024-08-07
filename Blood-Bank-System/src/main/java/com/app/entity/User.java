package com.app.entity;
import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name="First_Name")
	private String FirstName;
	@Column(name="Last_Name")
	private String LastName;
	@Column(name="Email_ID")
	private String EmailId;
	@Column(name="Password")
	private String Password;
	@Column(name="Phone_Number")
	private String PhoneNumber;
	
	@ManyToOne
	@JoinColumn(name="blood_group_id",nullable = true)
	private BloodGroup bloodgroups;
	
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	private List<UserDonations> userdonations;
	
	/*
	 * @Column(name="BloodGroup_ID") private int BloodGroupID;
	 */
	@Column(name="Birth_Date")
	private Date Birth_Date;
	@Column(name="Last_Donation_Date")
	private Date LastDonationDate;
	
	
	public BloodGroup getBloodgroups() {
		return bloodgroups;
	}


	public void setBloodgroups(BloodGroup bloodgroups) {
		this.bloodgroups = bloodgroups;
	}


	public User() {
		super();
	}


	public User(int id, String firstName, String lastName, String emailId, String password, String phoneNumber,
			 Date birth_Date, Date lastDonationDate) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
		Password = password;
		PhoneNumber = phoneNumber;
		
		Birth_Date = birth_Date;
		LastDonationDate = lastDonationDate;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	

	public Date getBirth_Date() {
		return Birth_Date;
	}


	public void setBirth_Date(Date birth_Date) {
		Birth_Date = birth_Date;
	}


	public Date getLastDonationDate() {
		return LastDonationDate;
	}


	public void setLastDonationDate(Date lastDonationDate) {
		LastDonationDate = lastDonationDate;
	}


	
	
	
	
	

}
