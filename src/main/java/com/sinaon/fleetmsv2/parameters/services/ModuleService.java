package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.Module;
import com.sinaon.fleetmsv2.parameters.repositories.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public List<Module> getAll() {
		return moduleRepository.findAll();

	}
	
	public void save(Module module) {
		moduleRepository.save(module);
	}
	
	public void delete(Integer id) {
		moduleRepository.deleteById(id);
	}

	public Module getById(Integer id) {
		return moduleRepository.findById(id).orElse(null);
	}
}
