package com.crud.demo.serviceImplTest;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

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
public class updatePersonServiceTest {

	@Mock
	private PersonasDAO dao;

	@InjectMocks
	private PersonasServiceImpl impl;

	@Test
	public void whenGivenId_shouldUpdatePerson_ifFound() {
		Personas per = new Personas();
		per.setId(3L);
		per.setNombre("Jane");

		Personas newper = new Personas();
		per.setNombre("Enrique");

		given(dao.findById(per.getId())).willReturn(Optional.of(per));

		impl.update(newper);
		verify(dao).save(newper);
	}
	
	@Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
        Personas user = new Personas();
        user.setId(89L);
        user.setNombre("Test Name");

        Personas newUser = new Personas();
        newUser.setId(90L);
        user.setNombre("New Test Name");

        given(dao.findById(anyLong())).willReturn(Optional.ofNullable(null));
        impl.update(newUser);
    }
}
