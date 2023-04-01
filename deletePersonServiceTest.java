package com.crud.demo.serviceImplTest;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.crud.demo.dao.PersonasDAO;
import com.crud.demo.model.Personas;
import com.crud.demo.service.PersonasServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class deletePersonServiceTest {

	@Mock
	private PersonasDAO dao;

	@InjectMocks
	private PersonasServiceImpl impl;
	
	@Test
	public void deleteById_ifFound() {
		Personas p = new Personas();
		p.setNombre("Caleb");
		p.setId(1L);
		when(dao.findById(p.getId())).thenReturn(Optional.of(p));
		impl.delete(p.getId());
		
		verify(dao).deleteById(p.getId());
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_exception_when_person_doesnt_exist() {
		Personas personas = new Personas();
		personas.setId(100L);
		personas.setNombre("Pablo");
		
		given(dao.findById(anyLong())).willReturn(Optional.ofNullable(null));
		impl.delete(personas.getId());
	}
}
