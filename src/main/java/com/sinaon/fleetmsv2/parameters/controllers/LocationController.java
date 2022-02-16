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

import com.sinaon.fleetmsv2.parameters.models.Location;
import com.sinaon.fleetmsv2.parameters.services.CountryService;
import com.sinaon.fleetmsv2.parameters.services.LocationService;
import com.sinaon.fleetmsv2.parameters.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	public Model addModelAttribute(Model model) {
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("countries", countryService.getAll());
		return model;
	}

	@GetMapping("/locations")
	public String getAll(Model model) {

		List<Location> locations = locationService.getAll();
		model.addAttribute("locations", locations);
		return "parameters/locations";
	}

	@GetMapping("/locationAdd")
	public String add(Model model) {
		addModelAttribute(model);
		return "parameters/locationAdd";
	}

	@GetMapping("/locationEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		addModelAttribute(model);
		model.addAttribute("location", locationService.getById(id));
		return "parameters/locationEdit";
	}

	@GetMapping("/locationDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		addModelAttribute(model);
		model.addAttribute("location", locationService.getById(id));
		return "parameters/locationDetails";
	}

	@PostMapping("/locations")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		locationService.delete(id);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

}
