package com.sinaon.fleetmsv2.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaon.fleetmsv2.parameters.models.Country;
import com.sinaon.fleetmsv2.parameters.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@ResponseBody
	@GetMapping("/countries")
	public List<Country> getAll() {
		return countryService.getAll();
	}

}
