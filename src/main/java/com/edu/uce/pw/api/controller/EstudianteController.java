package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3 NIVEL 1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {

		// return ResponseEntity.status(239).body(this.estudianteService.buscar(id));

		HttpHeaders cabeceras = new HttpHeaders();

		// las cabeceras manejan un esquema de clave valor
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar

	// http://localhost:8080/API/v1.0/Matricula/estudiantes NIVEL 1
	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {

		this.estudianteService.guardar(estudiante);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde al ingreso de un recurso");
		cabeceras.add("mensaje_201", "Estudiante ingresado correctamente");

		return new ResponseEntity<>(estudiante, cabeceras, 201);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3 NIVEL1

	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
		// return ResponseEntity.status(238).body(estudiante);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion completa de un recurso");
		cabeceras.add("mensaje_238", "Estudiante actualizado correctamente");

		return new ResponseEntity<>(estudiante, cabeceras, 238);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);

		Estudiante estudiante2 = this.estudianteService.buscar(estudiante.getId());

		if (estudiante.getNombre() != null) {
			estudiante2.setNombre(estudiante.getNombre());
		}
		if (estudiante.getApellido() != null) {
			estudiante2.setApellido(estudiante.getApellido());
		}
		if (estudiante.getFechaNaciomiento() != null) {
			estudiante2.setFechaNaciomiento(estudiante.getFechaNaciomiento());
		}
		this.estudianteService.actualizar(estudiante2);

		// return ResponseEntity.status(239).body(estudiante);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion parcial de un recurso");
		cabeceras.add("mensaje_239", "Estudiante actualizado correctamente");

		return new ResponseEntity<>(estudiante, cabeceras, 239);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/5 NIVEL 1
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		this.estudianteService.borrar(id);
		// return ResponseEntity.status(240).body("Borrado");
		HttpHeaders cabeceras = new HttpHeaders();

		cabeceras.add("mensaje_240", "Corresponde a la eliminacion de un recurso");
		cabeceras.add("mensaje_240", "Estudiante eliminado correctamente");

		return new ResponseEntity<>("Recurso eliminado", cabeceras, 239);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=Hola-Mundo

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/mixta/3?prueba=Hola-Mundo
	// NIVEL1
	@GetMapping(path = "/mixta/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("Dato: " + id);
		System.out.println("Dato: " + prueba);
		return this.estudianteService.buscar(id);
	}

}
