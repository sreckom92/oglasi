package com.srecko.projekat.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srecko.projekat.domain.Proizvod;
import com.srecko.projekat.repository.ProizvodRepository;

@Controller
public class DashboardController 
{
	@Autowired
	ProizvodRepository proizvodRepo;
	
	@RequestMapping(value="dashboard", method=RequestMethod.GET)
	public String homeGet(ModelMap model)
	{
		List<Proizvod> listaProizvoda = new ArrayList<>();
		listaProizvoda.addAll((List<Proizvod>)proizvodRepo.findAll());
		model.addAttribute("listaProizvoda", listaProizvoda);
		return "dashboard";
	}
	@PostMapping("/dashboard")
	public String dodajKorisnika(@ModelAttribute Proizvod dodajProizvod, ModelMap model)
	{
		proizvodRepo.save(dodajProizvod);
		return "redirect:/dashboard";
	}
	@GetMapping("")
	public String getDashboard()
	{
		return "/dashboard";
	}
}
