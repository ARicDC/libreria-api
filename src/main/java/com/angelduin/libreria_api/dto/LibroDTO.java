package com.angelduin.libreria_api.dto;

import java.math.BigDecimal;

public record LibroDTO(int id,String titulo,String genero,BigDecimal precio, int stock,String nombreAutor) {
	
}
