package com.java.DAO;

import java.util.List;

import com.java.Entity.Doctor;

public interface DoctorDAO {

	public List<Doctor> getdoctors();

	public void save(Doctor thedoc);

	public Doctor update(int id);

	public void del(int id);


	
}
