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

import com.sinaon.fleetmsv2.parameters.models.State;
import com.sinaon.fleetmsv2.parameters.services.CountryService;
import com.sinaon.fleetmsv2.parameters.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	public Model addModelAttribute(Model model) {
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("countries", countryService.getAll());
		return model;
	}

	@GetMapping("/states")
	public String getAll(Model model) {

		List<State> states = stateService.getAll();
		model.addAttribute("states", states);
		return "parameters/states";
	}

	@GetMapping("/stateAdd")
	public String add(Model model) {
		addModelAttribute(model);
		return "parameters/stateAdd";
	}

	@GetMapping("/stateEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		addModelAttribute(model);
		model.addAttribute("state", stateService.getById(id));
		return "parameters/stateEdit";
	}

	@GetMapping("/stateDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		addModelAttribute(model);
		model.addAttribute("state", stateService.getById(id));
		return "parameters/stateDetails";
	}

	@PostMapping("/states")
	public String save(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/state/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(State state) {
		stateService.save(state);
		return "redirect:/states";
	}

}
