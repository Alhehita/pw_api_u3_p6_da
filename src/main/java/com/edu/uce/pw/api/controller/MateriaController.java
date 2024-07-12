package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	// http://localhost:8080/API/v1.0/Matricula/materias/4
	@GetMapping(path = "{id}",produces="application/xml")
	public ResponseEntity<Materia> buscar(@PathVariable Integer id) {
		// return ResponseEntity.status(239).body(this.materiaService.buscar(id));

		HttpHeaders cabeceras = new HttpHeaders();

		// las cabeceras manejan un esquema de clave valor
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Materia encontrada");
		return new ResponseEntity<>(this.materiaService.buscar(id), cabeceras, 236);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
		//return ResponseEntity.status(201).body(materia);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde al ingreso de un recurso");
		cabeceras.add("mensaje_201", "Materia ingresada correctamente");

		return new ResponseEntity<>(materia, cabeceras, 201);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/2
	@PutMapping(path = "/{id}",produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Materia> actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		this.materiaService.actualizar(materia);

		// return ResponseEntity.status(238).body(materia);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion completa de un recurso");
		cabeceras.add("mensaje_238", "Materia actualizada correctamente");

		return new ResponseEntity<>(materia, cabeceras, 238);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/1
	@PatchMapping(path = "/{id}",produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {

		materia.setId(id);
		Materia materia2 = this.materiaService.buscar(materia.getId());

		if (materia.getNombre() != null) {
			materia2.setNombre(materia.getNombre());
		}
		if (materia.getCreditos() != null) {
			materia2.setCreditos(materia.getCreditos());
		}
		if (materia.getCreditos() != null) {
			materia2.setDescripcion(materia.getDescripcion());
		}
		this.materiaService.actualizar(materia2);

		// return ResponseEntity.status(239).body(materia);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion parcial de un recurso");
		cabeceras.add("mensaje_239", "Materia actualizada correctamente");

		return new ResponseEntity<>(materia, cabeceras, 239);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/2
	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		this.materiaService.borrar(id);
		// return ResponseEntity.status(240).body("Borrado");

		HttpHeaders cabeceras = new HttpHeaders();

		cabeceras.add("mensaje_240", "Corresponde a la eliminacion de un recurso");
		cabeceras.add("mensaje_240", "Materia eliminada correctamente");

		return new ResponseEntity<>("Recurso eliminado", cabeceras, 240);

	}

}
