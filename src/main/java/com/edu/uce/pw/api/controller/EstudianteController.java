package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path="/estudiantes")
public class EstudianteController {
	
	@Autowired	
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Estudiante estudiante) {
		
		
		this.estudianteService.actualizar(estudiante);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	@DeleteMapping(path="/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		
		this.estudianteService.borrar(id);
	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/4/nuevo/prueba
	@GetMapping(path="/buscar/{id}/nuevo/{dato}")
	public Estudiante buscar(@PathVariable Integer id, String dato) {
		System.out.println("Dato: " + dato);
		return this.estudianteService.buscar(id);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	@PatchMapping(path="/actualizar/parcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		
		Estudiante estudiante2 = this.estudianteService.buscar(estudiante.getId());
		
		if(estudiante.getNombre()!= null) {
			estudiante2.setNombre(estudiante.getNombre());
		}
		if(estudiante.getApellido()!= null) {
			estudiante2.setApellido(estudiante.getApellido());
		}
		if(estudiante.getFechaNaciomiento()!= null) {
			estudiante2.setFechaNaciomiento(estudiante.getFechaNaciomiento());
		}
		this.estudianteService.actualizar(estudiante2);
		
	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=35
	@GetMapping(path="/buscarPorGenero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero, @RequestParam Integer edad) {
    System.out.println("edad: " + edad);
    List<Estudiante> lista = this.estudianteService.buscarGenero(genero);
    
    return lista;
}


	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=Hola-Mundo
	@GetMapping(path="/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("Dato: " + id);
		System.out.println("Dato: " + prueba);
		return this.estudianteService.buscar(id);
		}

}
