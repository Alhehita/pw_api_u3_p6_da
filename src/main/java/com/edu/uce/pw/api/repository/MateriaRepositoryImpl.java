package com.edu.uce.pw.api.repository;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Materia seleccionar(Integer id) {
        return this.entityManager.find(Materia.class, id);
     }

    @Override
    public void actualizar(Materia materia) {
        this.entityManager.merge(materia);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(id);
    }

    @Override
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);    
    }

    
}