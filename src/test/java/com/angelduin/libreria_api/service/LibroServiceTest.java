package com.angelduin.libreria_api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.angelduin.libreria_api.entity.Libro;
import com.angelduin.libreria_api.repository.LibroRepository;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTest {
	
	@Mock
	private LibroRepository libroRepository;
	
	@InjectMocks
	private LibroService libroService;
	
	private Libro libro;
	
	@BeforeEach
	void setUp() {
		libro = new Libro();
		libro.setId(1);
		libro.setTitulo("Ficciones");
		libro.setGenero("Cuentos");
		libro.setPrecio(new BigDecimal(970.00));
		libro.setStock(13);
	}
	
	@Test
	void obtenerTodos_devuelveListaDeLibros() {
		//Arrange
		when(libroRepository.findAll()).thenReturn(List.of(libro));
		
		List<Libro> resultado = libroService.obtenerTodos();
		
		assertEquals(1, resultado.size());
		assertEquals("Ficciones", resultado.get(0).getTitulo());
	}
	
	@Test
	void obtenerPorId_cuandoExiste_devuelveLibro() {
		
		when(libroRepository.findById(1)).thenReturn(Optional.of(libro));
		
		Optional<Libro> resultado = libroService.obtenerPorId(1);
		
		assertTrue(resultado.isPresent());
		assertEquals("Ficciones", resultado.get().getTitulo());
	}
	
	@Test
	void obtenerPorId_cuandoNoExiste_devuelveVacio() {
		
		when(libroRepository.findById(99)).thenReturn(Optional.empty());
		
		Optional<Libro> resultado = libroService.obtenerPorId(99);
		
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	void guardar_cuandoOperacionExitosa_devuelveLibro() {
		
		when(libroRepository.save(libro)).thenReturn(libro);
		
		Libro resultado = libroService.guardar(libro);
		
		assertEquals(1,resultado.getId());
		assertEquals("Ficciones",resultado.getTitulo());
		
	}
	
	@Test
	void existePorId_cuandoExiste_devuelveTrue() {
		
		when(libroRepository.existsById(1)).thenReturn(true);
		
		Boolean resultado = libroService.existePorId(1);
		
		assertTrue(resultado.booleanValue());
	}
	
	@Test
	void existePorId_cuandoNoExiste_devuelveFalse() {
		
		when(libroRepository.existsById(99)).thenReturn(false);
		
		Boolean resultado = libroService.existePorId(99);
		
		assertFalse(resultado.booleanValue());
	}
	
	@Test
	void eliminarPorId_cuandoOperacionExitosa() {
		
		libroService.eliminar(1);
		
		verify(libroRepository).deleteById(1);
		
	}

	
	
	
	
	
}
































