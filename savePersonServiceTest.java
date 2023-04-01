package com.crud.demo.serviceImplTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.crud.demo.dao.PersonasDAO;
import com.crud.demo.model.Personas;
import com.crud.demo.service.PersonasServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class savePersonServiceTest {
	
	@Mock
	private PersonasDAO dao;
	
	@InjectMocks
	private PersonasServiceImpl impl;
	
	@Test
	public void whenSave_shouldReturnPerson() {
		Personas p = new Personas();
		p.setNombre("Marco");
		p.setApellido("Herrera");
		p.setCorreo("m.herrera@hotmail.com");
		
		when(dao.save(ArgumentMatchers.any(Personas.class))).thenReturn(p);
		Personas nuevo = impl.save(p);
		assertThat(nuevo.getNombre()).isSameAs(p.getNombre());
		verify(dao).save(p);
	}
}
