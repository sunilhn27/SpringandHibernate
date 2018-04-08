package com.java.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Size(min = 2, max = 6, message = "should be less than 6 and more than 2")
	@Column(name = "doctorname")
	private String doctorname;

	@Size(max = 5, min = 1 ,message="should be less than 2 and more than 5")
	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorname=" + doctorname + ", address=" + address + ", email=" + email + "]";
	}

	public Doctor(String doctorname, String address, String email) {
		this.doctorname = doctorname;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Doctor() {

	}
}
