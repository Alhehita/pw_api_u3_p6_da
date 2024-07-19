package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarGenero(String genero) {
		return this.estudianteRepository.seleccionarGenero(genero);
	}

	public EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estudianteTO = new EstudianteTO();
		estudianteTO.setApellido(estudiante.getApellido());
		estudianteTO.setCedula(estudiante.getCedula());
		estudianteTO.setFechaNaciomiento(estudiante.getFechaNaciomiento());
		estudianteTO.setGenero(estudiante.getGenero());
		estudianteTO.setId(estudiante.getId());
		estudianteTO.setNombre(estudiante.getNombre());
		return estudianteTO;
	}

	@Override
	public EstudianteTO buscarPorID(Integer id) {
		Estudiante estudiante = this.estudianteRepository.seleccionar(id);
		return this.convertir(estudiante);
	}

	public List<EstudianteTO> convertirLista(List<Estudiante> estudiantes) {
    List<EstudianteTO> estudiantesTO = new ArrayList<>();
    
    for (Estudiante estudiante : estudiantes) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setApellido(estudiante.getApellido());
        estudianteTO.setGenero(estudiante.getGenero());
        estudianteTO.setId(estudiante.getId());
        estudianteTO.setNombre(estudiante.getNombre());
        estudiantesTO.add(estudianteTO);
    }
    
    return estudiantesTO;
}

	@Override
	public List<EstudianteTO> buscarTodos() {
		return convertirLista(this.estudianteRepository.seleccionarTodos());
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);
		return convertir(estudiante);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		this.estudianteRepository.eliminarPorCedula(cedula);
	}



}
