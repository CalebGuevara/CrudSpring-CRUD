package com.crud.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.demo.model.Personas;

public interface PersonasDAO extends CrudRepository<Personas, Long>{
	
}
