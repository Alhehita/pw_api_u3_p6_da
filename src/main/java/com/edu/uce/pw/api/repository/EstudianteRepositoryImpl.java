package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {

		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> seleccionarGenero(String genero) {
		TypedQuery<Estudiante> query = entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero",
				Estudiante.class);
		query.setParameter("genero", genero);
		return query.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
	TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);

		return query.getResultList();
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula= :cedula",Estudiante.class);
		query.setParameter("cedula", cedula);

		return query.getSingleResult();
	}

	@Override
	public void eliminarPorCedula(String cedula) {

		this.entityManager.remove(this.seleccionarPorCedula(cedula));
	}

	// @Override
	// public void actualizarPorCedula(Estudiante estudiante) {

	// 	this.entityManager.merge(this.seleccionarPorCedula(null));
	// }

}
