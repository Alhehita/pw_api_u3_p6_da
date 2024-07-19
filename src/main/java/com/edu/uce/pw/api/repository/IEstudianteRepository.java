package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	// CRUD

	 Estudiante seleccionar(Integer id);

	 void actualizar(Estudiante estudiante);

	 void eliminar(Integer id);

	 void insertar(Estudiante estudiante);
	 
	 List<Estudiante> seleccionarGenero(String genero);

	 List<Estudiante> seleccionarTodos();


	 ////////////////////////////////

	 Estudiante seleccionarPorCedula(String cedula);

	 void eliminarPorCedula(String cedula);

	// void actualizarPorCedula(Estudiante estudiante);






}
