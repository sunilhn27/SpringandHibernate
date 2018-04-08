package com.gontuseries.studentadmissioncontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.DAO.DoctorDAO;
import com.java.Entity.Doctor;

@ComponentScan("com.*")
@Controller
public class DoctorController {

	@Autowired
	DoctorDAO doctordao;

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("inside index");
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "index";
	}

	@RequestMapping("/doctorlist")
	public String list(Model model) {
		List<Doctor> doctor = doctordao.getdoctors();
		model.addAttribute("DOCTOR", doctor);
		String msg = "Hello";
		model.addAttribute("MSG", msg);
		System.out.println("inside list");
		System.out.println("**********" + doctor);
		return "doctorlist";
	}

	@RequestMapping("/adddoctor")
	public String add(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		System.out.println("inside AddForm");
		return "adddoctor";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid @ModelAttribute("doctor") Doctor thedoc, BindingResult rs) {
		doctordao.save(thedoc);
		if (rs.hasErrors()) {
			String msg = "invlaid details";
			model.addAttribute("msg", msg);
			return "adddoctor";
		}
		System.out.println("inside save");
		return "redirect:/doctorlist";
	}

	@RequestMapping("/doctorupdate")
	public String update(Model model, @ModelAttribute("doctorid") int id) {
		Doctor doctor = doctordao.update(id);
		model.addAttribute("doctor", doctor);
		System.out.println("inside update");
		return "adddoctor";
	}

	@RequestMapping("/doctordelete")
	public String del(@ModelAttribute("doctorid") int id) {
		doctordao.del(id);
		System.out.println("inside del");
		return "redirect:/doctorlist";
	}
}
