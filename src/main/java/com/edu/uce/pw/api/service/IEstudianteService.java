package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	public Estudiante buscar(Integer id);

	public void actualizar(Estudiante estudiante);

	public void borrar(Integer id);

	public void guardar(Estudiante estudiante);
	
	List<Estudiante> buscarGenero(String genero);

	public EstudianteTO buscarPorID(Integer id);

	public List<EstudianteTO> buscarTodos();




	 ////////////////////////////////

	 EstudianteTO buscarPorCedula(String cedula);

	 void borrarPorCedula(String cedula);

	 void actualizarPorCedula(String cedula, Estudiante estudiante);

}
