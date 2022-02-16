package com.sinaon.fleetmsv2.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaon.fleetmsv2.parameters.models.Country;
import com.sinaon.fleetmsv2.parameters.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getAll(Model model) {

		List<Country> countries = countryService.getAll();
		model.addAttribute("countries", countries);
		return "parameters/countries";
	}
	
	//The Get Country By Id
	@GetMapping("/country/{id}")
	@ResponseBody
	public Country getCountry(@PathVariable Integer id){
		System.out.println("IM CALLED!");
	    return countryService.getById(id);
	}
 
	@GetMapping("/countryAdd")
	public String addCountry() {
		return "parameters/countryAdd";
	}

	@GetMapping("/countryEdit/{id}")
	public String editCountry(@PathVariable Integer id, Model model) {
		Country country = countryService.getById(id);
		model.addAttribute("country", country);
		return "parameters/countryEdit";
	}
	
	@GetMapping("/countryDetails/{id}")
	public String detailsCountry(@PathVariable Integer id, Model model) {
		Country country = countryService.getById(id);
		model.addAttribute("country", country);
		return "parameters/countryDetails";
	}

	@PostMapping("/countries")
	public String saveCountry(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

}
