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

import com.sinaon.fleetmsv2.parameters.models.Client;
import com.sinaon.fleetmsv2.parameters.services.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public String getAll(Model model) {

		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);
		return "parameters/clients";
	}

	@GetMapping("clientAdd")
	public String add() {
		return "parameters/clientAdd";
	}

	@GetMapping("clientEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Client clients = clientService.getById(id);
		model.addAttribute("clients", clients);
		return "parameters/clientEdit";
	}

	@GetMapping("clientDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		Client clients = clientService.getById(id);
		model.addAttribute("clients", clients);
		return "parameters/clientDetails";
	}

	@PostMapping("/clients")
	public String save(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/clients/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		clientService.delete(id);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/clients/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}

}
