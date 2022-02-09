package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.State;
import com.sinaon.fleetmsv2.parameters.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> getAll() {
		return stateRepository.findAll();

	}
	
	public void save(State country) {
		stateRepository.save(country);
	}
	
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}

	public State getById(Integer id) {
		return stateRepository.findById(id).orElse(null);
	}
}
