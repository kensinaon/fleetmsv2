package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.CommonObject;
import com.sinaon.fleetmsv2.parameters.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<CommonObject> getAll() {
		return departmentRepository.findAll();

	}
	
	public void save(CommonObject commonObject) {
		departmentRepository.save(commonObject);
	}
	
	public void delete(Integer id) {
		departmentRepository.deleteById(id);
	}

	public CommonObject getById(Integer id) {
		return departmentRepository.findById(id).orElse(null);
	}
}
