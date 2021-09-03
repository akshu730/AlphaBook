package com.jdbc.day3;

public class User 
{
	private String first_name;
	private String Last_name;
	private String gender;
	private long contact_number;
	private String date_of_birth;
	private String email_id;
	
	public User() {
		super();
	}

	public User(String first_name, String last_name, String gender, long contact_number, String date_of_birth,
			String email_id) {
		super();
		this.first_name = first_name;
		Last_name = last_name;
		this.gender = gender;
		this.contact_number = contact_number;
		this.date_of_birth = date_of_birth;
		this.email_id = email_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public void postStatus()
	{
		
	}
	
	public void Profile()
	{
		
	}
	
}
