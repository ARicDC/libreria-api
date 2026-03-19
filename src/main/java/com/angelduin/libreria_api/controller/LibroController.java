package com.angelduin.libreria_api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angelduin.libreria_api.dto.LibroDTO;
import com.angelduin.libreria_api.entity.Libro;
import com.angelduin.libreria_api.service.LibroService;

import jakarta.validation.Valid;

@RestController
public class LibroController {
	
	private final LibroService libroService;
	
	public LibroController(LibroService libroService) {
		this.libroService = libroService;
	}
	
	@GetMapping("/libros")
	public List<LibroDTO> obtenerTodos(){
		return libroService.obtenerTodos()
				.stream()
				.map(libro -> new LibroDTO(
						libro.getId(),
						libro.getTitulo(),
						libro.getGenero(),
						libro.getPrecio(),
						libro.getStock(),
						libro.getAutor() != null ? libro.getAutor().getNombre() : null))
				.toList();
	}
	
	@GetMapping("/libros/{id}")
	public ResponseEntity<Libro> obtenerPorId(@PathVariable Integer id) {
		return libroService.obtenerPorId(id)
				.map(libro -> ResponseEntity.ok(libro))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("libros/paginado")
	public Page<Libro> obtenerTodosPaginado(Pageable pageable){
		return libroService.obtenerTodosPaginado(pageable);
	}
	
	@GetMapping("/libros/buscar/genero/paginado")
	public Page<Libro> buscarPorGenero(@RequestParam String genero, Pageable pageable){
		return libroService.obtenerPorGenero(genero, pageable);
	}
	
	@GetMapping("/libros/buscar/autor")
	public List<Libro> buscarPorNombreAutor(@RequestParam String nombre){
		return libroService.obtenerPorNombreAutor(nombre);
	}
	
	@GetMapping("/libros/buscar/precio")
	public List<Libro> buscarPorPrecio(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
		return libroService.obtenerPorRangoPrecio(min, max);
	}
	
	@PostMapping("/libros")
	public Libro crear(@Valid @RequestBody Libro libro) {
		return libroService.guardar(libro);
	}
	
	@PutMapping("/libros/{id}")
	public Libro actualizar (@PathVariable Integer id,@Valid @RequestBody Libro libro) {
		libro.setId(id);
		return libroService.guardar(libro);
	}
	
	@DeleteMapping("/libros/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		if(!libroService.existePorId(id)) {
			return ResponseEntity.notFound().build();
		}
		
		libroService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
