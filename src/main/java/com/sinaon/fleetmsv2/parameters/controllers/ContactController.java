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

import com.sinaon.fleetmsv2.parameters.models.Contact;
import com.sinaon.fleetmsv2.parameters.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public String getAll(Model model) {

		List<Contact> contacts = contactService.getAll();
		model.addAttribute("contacts", contacts);
		return "parameters/contacts";
	}

	@GetMapping("/contactAdd")
	public String add() {
		return "parameters/contactAdd";
	}

	@GetMapping("/contactEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Contact contacts = contactService.getById(id);
		model.addAttribute("contacts", contacts);
		return "parameters/contactEdit";
	}

	@GetMapping("/contactDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		Contact contacts = contactService.getById(id);
		model.addAttribute("contacts", contacts);
		return "parameters/contactDetails";
	}

	@PostMapping("/contacts")
	public String save(Contact contact) {
		contactService.save(contact);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/contacts/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

}
