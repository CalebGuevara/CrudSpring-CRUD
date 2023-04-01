package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Personas;
import com.crud.demo.service.PersonasService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api") // https://localhost:8080/api/personas
public class PersonasController {
	
	@Autowired
	private PersonasService servicio;
	
	@PostMapping("/personas")
	public Personas save(@RequestBody Personas personas) {
		return servicio.save(personas);
	}
	
	@GetMapping("/personas")
	public List<Personas> personas(){
		return servicio.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public Personas mostrar(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PutMapping("/personas/{id}")
	public Personas update(@RequestBody Personas personas, @PathVariable Long id){
		Personas p = servicio.findById(id);
		p.setNombre(personas.getNombre());
		p.setApellido(personas.getApellido());
		p.setCorreo(personas.getCorreo());
		
		return servicio.save(p);
	}
	
	@DeleteMapping("/personas/{id}")
	public void delete(@PathVariable Long id) {
		servicio.delete(id);
	}
}
