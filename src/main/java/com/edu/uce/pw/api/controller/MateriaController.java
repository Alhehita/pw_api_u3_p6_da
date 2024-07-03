package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    //http://localhost:8080/API/v1.0/Matricula/materias/guardar
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
        this.materiaService.guardar(materia);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Materia materia) {
		
		
		this.materiaService.actualizar(materia);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/materias/borrar/2
	@DeleteMapping(path="/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		
		this.materiaService.borrar(id);
	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/materias/buscar/4
	@GetMapping(path="/buscar/{id}")
	public Materia buscar(@PathVariable Integer id) {
		return this.materiaService.buscar(id);
	}
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar/parcial
	@PatchMapping(path="/actualizar/parcial")
	public void actualizarParcial(@RequestBody Materia materia) {
		
		Materia materia2 = this.materiaService.buscar(materia.getId());
		
		if(materia.getNombre()!= null) {
			materia2.setNombre(materia.getNombre());
		}
		if(materia.getCreditos()!= null) {
			materia2.setCreditos(materia.getCreditos());
		}
		if(materia.getCreditos()!= null) {
			materia2.setDescripcion(materia.getDescripcion());
		}
		this.materiaService.actualizar(materia2);
		
	}
    
}
