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

import com.srecko.projekat.domain.Korisnik;
import com.srecko.projekat.repository.KorisniciRepository;

@Controller
public class KorisniciController 
{
	@Autowired
	KorisniciRepository korisnikRepo;
	
	@RequestMapping(value="korisnici", method=RequestMethod.GET)
	public String homeGet(ModelMap model)
	{
		List<Korisnik> listaKorisnika = new ArrayList<>();
		listaKorisnika.addAll((List<Korisnik>)korisnikRepo.findAll());
		model.addAttribute("listaKorisnika", listaKorisnika);
		return "korisnici";
	}
	@PostMapping("/account")
	public String dodajKorisnika(@ModelAttribute Korisnik dodajKorisnika, ModelMap model)
	{
		korisnikRepo.save(dodajKorisnika);
		return "redirect:/dashboard";
	}
	@GetMapping("/account")
	public String login() 
	{
		return "account";
	}

}
