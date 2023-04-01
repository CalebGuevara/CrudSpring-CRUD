package com.crud.demo.serviceImplTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.crud.demo.dao.PersonasDAO;
import com.crud.demo.model.Personas;
import com.crud.demo.service.PersonasServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class listPersonServiceTest {

	@Mock
	private PersonasDAO dao;

	@InjectMocks
	private PersonasServiceImpl impl;

	@Test
	public void shouldReturnAllPersons() {
		List<Personas> p = new ArrayList();
		p.add(new Personas());
		given(dao.findAll()).willReturn(p);
		
		List<Personas> expected = impl.findAll();
		
		assertEquals(expected, p);
		verify(dao).findAll();
	}
}
