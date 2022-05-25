package com.inti.SpringBootTD2Tests.controller;

import com.inti.SpringBootTD2Tests.model.Salarie;
import com.inti.SpringBootTD2Tests.repository.SalarieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SalarieController {

	@Autowired
	SalarieRepository salarieRepository;
	
	@GetMapping("/save")
	public String save(@ModelAttribute("salarie") Salarie s) {
		salarieRepository.save(s);
		return "accueil";
	}
	
	@GetMapping("/salaries")
	public String getAllSalaries(Model m) {
		m.addAttribute("listeSalarie", salarieRepository.findAll());
		return "listeSalarie";
	}
	@GetMapping("/update")
	public String update(Salarie s) {
		salarieRepository.save(s);
		return "accueil";
	}
	
	@GetMapping("/delete")
	public String delete(Salarie s) {
		salarieRepository.delete(s);
		return "accueil";
	}
}
