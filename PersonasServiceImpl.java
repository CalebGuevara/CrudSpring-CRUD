package com.crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.demo.dao.PersonasDAO;
import com.crud.demo.model.Personas;

@Service
public class PersonasServiceImpl implements PersonasService {
	
	@Autowired
	private PersonasDAO dao; 
	
	@Override
	@Transactional(readOnly = false)
	public Personas save(Personas personas) {
		// TODO Auto-generated method stub
		return dao.save(personas);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Personas findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personas> findAll() {
		// TODO Auto-generated method stub
		return (List<Personas>) dao.findAll();
	}

	@Override
	public Personas update(Personas personas) {
		// TODO Auto-generated method stub
		return dao.save(personas);
	}

}
