package com.angelduin.libreria_api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "Libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	
	@NotBlank(message = "El titlo es obligatorio")
	private String titulo;
	
	@NotBlank(message = "El género es obligatorio")
	private String genero;
	
	@Positive(message = "El precio debe ser mayor a cero")
	private BigDecimal precio;
	
	@Min(value = 0, message = "El stock no puede ser negativo")
	private int stock;
	
	public Libro() {}

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

	public Autor getAutor() { return autor;}
	public void setAutor(Autor autor) {	this.autor = autor;}
	
    
}
