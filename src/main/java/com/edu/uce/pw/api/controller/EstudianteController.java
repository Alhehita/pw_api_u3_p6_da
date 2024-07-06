package com.edu.uce.pw.api.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar

	// http://localhost:8080/API/v1.0/Matricula/estudiantes NIVEL 1
	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) { // debe retornar un objeto completo

		this.estudianteService.guardar(estudiante);

		return ResponseEntity.status(201).body(estudiante);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3 NIVEL1

	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
		return ResponseEntity.status(238).body(estudiante);

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

		return ResponseEntity.status(239).body(estudiante);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/5 NIVEL 1
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3 NIVEL 1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		
		return ResponseEntity.status(239).body(this.estudianteService.buscar(id));
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=35

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/genero=M Nivel 1
	@GetMapping(path = "/genero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarGenero(genero);

		return lista;
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
