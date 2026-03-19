# Librería API

API REST para gestión de una librería, desarrollada con Spring Boot.

## Tecnologías

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Maven

## Requisitos previos

- JDK 21
- MySQL 8.x
- Maven 3.x

## Configuración

1. Crear base de datos en MySQL:
```sql
CREATE DATABASE libreria;
```

2. Configurar credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/libreria
spring.datasource.username=AngelDB
spring.datasource.password=#########
```

## Ejecutar
```bash
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8080`

## Endpoints

### Libros

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /libros | Obtener todos los libros |
| GET | /libros/{id} | Obtener libro por ID |
| POST | /libros | Crear libro |
| PUT | /libros/{id} | Actualizar libro |
| DELETE | /libros/{id} | Eliminar libro |

### Búsquedas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /libros/paginado | Listar con paginación |
| GET | /libros/buscar/genero?genero=X | Buscar por género |
| GET | /libros/buscar/autor?nombre=X | Buscar por autor |
| GET | /libros/buscar/precio?min=X&max=Y | Buscar por rango de precio |

## Ejemplos de uso

### Crear un libro
```json
POST /libros
{
    "titulo": "Don Quijote",
    "genero": "Novela",
    "precio": 1200.00,
    "stock": 5
}
```

### Respuesta
```json
{
    "id": 8,
    "titulo": "Don Quijote",
    "genero": "Novela",
    "precio": 1200.00,
    "stock": 5,
    "autor": null
}
```