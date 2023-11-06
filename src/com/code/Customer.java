package com.code;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {

	/*Customer id(int) , first name(String), last name (String), email(String), password(String), 
	Address String, RegisterDate(LocalDate),
	planEndDate(LocalDate), Address(String), Phone No(String),plan Enum, final_amount double*/
	
	private int id;
	private String firstName,lastName,email,password,address;
	private LocalDate registrDate,planEndDate;
	private String phoneNum;
	private MessPlan plan;
	private double amunt;
	private static int counterId;
	static {
		counterId=0;
	}
	public Customer(String firstName, String lastName, String email, String password, String address,
			LocalDate registrDate, LocalDate planEndDate, String phoneNum, MessPlan plan, double amunt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registrDate = registrDate;
		this.planEndDate = planEndDate;
		this.phoneNum = phoneNum;
		this.plan = plan;
		this.amunt = amunt;
		this.id = ++counterId;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", registrDate=" + registrDate + ", planEndDate="
				+ planEndDate + ", phoneNum=" + phoneNum + ", plan=" + plan + ", amunt=" + amunt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getRegistrDate() {
		return registrDate;
	}
	public void setRegistrDate(LocalDate registrDate) {
		this.registrDate = registrDate;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public MessPlan getPlan() {
		return plan;
	}
	public void setPlan(MessPlan plan) {
		this.plan = plan;
	}
	public double getAmunt() {
		return amunt;
	}
	public void setAmunt(double amunt) {
		this.amunt = amunt;
	}
	public static int getCounterId() {
		return counterId;
	}
	public static void setCounterId(int counterId) {
		Customer.counterId = counterId;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	
	
}
