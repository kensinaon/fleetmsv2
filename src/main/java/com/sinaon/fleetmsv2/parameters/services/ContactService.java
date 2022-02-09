package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.Contact;
import com.sinaon.fleetmsv2.parameters.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAll() {
		return contactRepository.findAll();

	}
	
	public void save(Contact country) {
		contactRepository.save(country);
	}
	
	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}

	public Contact getById(Integer id) {
		return contactRepository.findById(id).orElse(null);
	}
}
