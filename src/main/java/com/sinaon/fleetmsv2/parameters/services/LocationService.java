package com.sinaon.fleetmsv2.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaon.fleetmsv2.parameters.models.Location;
import com.sinaon.fleetmsv2.parameters.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> getAll() {
		return locationRepository.findAll();

	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}

	public Location getById(Integer id) {
		return locationRepository.findById(id).orElse(null);
	}
}
