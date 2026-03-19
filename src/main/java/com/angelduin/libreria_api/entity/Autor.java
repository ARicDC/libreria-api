package com.angelduin.libreria_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String nacionalidad;
	private LocalDate fechaNacimiento;
	
	public Autor() {}

	public int getId() {return id;}
	public void setId(int id) {	this.id = id;}

	public String getNombre() {	return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getNacionalidad() {return nacionalidad;}
	public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}

	public LocalDate getFechaNacimiento() {	return fechaNacimiento;	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {	this.fechaNacimiento = fechaNacimiento;	}
	
	
}
