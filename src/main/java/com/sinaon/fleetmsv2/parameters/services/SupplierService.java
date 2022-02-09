package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.Supplier;
import com.sinaon.fleetmsv2.parameters.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getAll() {
		return supplierRepository.findAll();

	}
	
	public void save(Supplier country) {
		supplierRepository.save(country);
	}
	
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}

	public Supplier getById(Integer id) {
		return supplierRepository.findById(id).orElse(null);
	}
}
