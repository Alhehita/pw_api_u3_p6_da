package com.edu.uce.pw.api.repository;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {

       public Materia seleccionar(Integer id);

	public void actualizar(Materia materia);

	public void eliminar(Integer id);

	public void insertar(Materia materia);
	
    
}
