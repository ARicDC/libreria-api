package com.angelduin.libreria_api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.angelduin.libreria_api.entity.Libro;


public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	Page<Libro> findByGenero(String genero, Pageable pageable);
	List<Libro> findByAutorNombreContaining(String nombreAutor);
	List<Libro> findByPrecioBetween(BigDecimal min, BigDecimal max);
}
