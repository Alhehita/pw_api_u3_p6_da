package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    //http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping()
	public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
        this.materiaService.guardar(materia);
		return ResponseEntity.status(201).body(materia);

	}

	//http://localhost:8080/API/v1.0/Matricula/materias/2
	@PutMapping(path="/{id}")
	public ResponseEntity<Materia> actualizar(@RequestBody Materia materia,@PathVariable Integer id) {
		materia.setId(id);
		this.materiaService.actualizar(materia);

		return ResponseEntity.status(238).body(materia);
	}

	//http://localhost:8080/API/v1.0/Matricula/materias/1
	@PatchMapping(path="/{id}")
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia,@PathVariable Integer id) {
		
		materia.setId(id);
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
			
		return ResponseEntity.status(239).body(materia);
	}

	//http://localhost:8080/API/v1.0/Matricula/materias/2
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		
		this.materiaService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");

	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/materias/4
	@GetMapping(path="{id}")
	public ResponseEntity<Materia> buscar(@PathVariable Integer id) {
		return ResponseEntity.status(239).body(this.materiaService.buscar(id));
	}
	
    
}
