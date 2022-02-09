package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.Client;
import com.sinaon.fleetmsv2.parameters.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.findAll();

	}
	
	public void save(Client country) {
		clientRepository.save(country);
	}
	
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}

	public Client getById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
}
