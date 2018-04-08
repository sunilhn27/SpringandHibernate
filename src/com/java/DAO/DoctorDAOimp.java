package com.java.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.Entity.Doctor;

@Repository
@Service("doctordao")
public class DoctorDAOimp implements DoctorDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Transactional
	@Override
	public List<Doctor> getdoctors() {
		Session session = sessionfactory.getCurrentSession();
		Query<Doctor> thequery = session.createQuery("from Doctor", Doctor.class);
		List<Doctor> doctor = thequery.getResultList();
		return doctor;
	}

	@Transactional
	@Override
	public void save(Doctor thedoc) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(thedoc);
	}

	@Transactional
	@Override
	public Doctor update(int id) {
		Session session = sessionfactory.getCurrentSession();
		Doctor thedoc = session.get(Doctor.class, id);
		return thedoc;
	}

	@Transactional
	@Override
	public void del(int id) {
		Session session = sessionfactory.getCurrentSession();
		Doctor thedoc = session.get(Doctor.class, id);
		session.delete(thedoc);
	}

}
