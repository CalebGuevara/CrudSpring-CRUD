package com.crud.demo.service;

import java.util.List;

import com.crud.demo.model.Personas;

public interface PersonasService {
	
	public Personas save(Personas personas);
	
	public Personas update(Personas personas);
	
	public void delete(Long id);
	
	public Personas findById(Long id);
	
	public List<Personas> findAll();
}
