package com.sinaon.fleetmsv2.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinaon.fleetmsv2.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
