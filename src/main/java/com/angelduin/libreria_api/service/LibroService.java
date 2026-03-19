package com.angelduin.libreria_api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.angelduin.libreria_api.repository.LibroRepository;
import com.angelduin.libreria_api.entity.Libro;

@Service
public class LibroService {
	
	private final LibroRepository libroRepository;
	
	public LibroService(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
	
	public List<Libro> obtenerTodos(){
		return libroRepository.findAll();
	}
	
	public Page<Libro> obtenerTodosPaginado(Pageable pageable){
		return libroRepository.findAll(pageable);
	}
	
	public Optional<Libro> obtenerPorId(Integer id){
		return libroRepository.findById(id);
	}
	
	public Page<Libro> obtenerPorGenero(String genero, Pageable pageable){
		return libroRepository.findByGenero(genero, pageable);
	}
	
	public List<Libro> obtenerPorNombreAutor(String nombre){
		return libroRepository.findByAutorNombreContaining(nombre);
	}
	
	public List<Libro> obtenerPorRangoPrecio(BigDecimal min, BigDecimal max){
		return libroRepository.findByPrecioBetween(min, max);
	}
	
	public Libro guardar(Libro libro) {
		return libroRepository.save(libro);
	}
	
	public boolean existePorId(Integer id) {
		return libroRepository.existsById(id);
	}
	
	public void eliminar(Integer id) {
		libroRepository.deleteById(id);
	}
	
	
	
}
