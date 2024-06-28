package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path="/estudiantes")
public class EstudianteController {
	
	@Autowired	
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		//Estudiante estudiante = new Estudiante();
		//estudiante.setNombre("Dennisse");
		//estudiante.setApellido("Andrade");
		//estudiante.setFechaNaciomiento(LocalDateTime.of(1997, 03, 17,11, 10));
		this.estudianteService.guardar(estudiante);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path="/actualizar")
	public void actualizar() {
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Alexandra");
		estudiante.setApellido("Marin");
		estudiante.setFechaNaciomiento(LocalDateTime.of(1995, 04, 24, 23, 10));
		this.estudianteService.actualizar(estudiante);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path="/borrar")
	public void borrar() {
		
		this.estudianteService.borrar(3);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@GetMapping(path="/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(2);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	@PatchMapping(path="/actualizar/parcial")
	public void actualizarParcial() {
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Marjorie");
		this.estudianteService.actualizar(estudiante);
	}

}
