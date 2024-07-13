package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public Materia buscar(Integer id) {
        return this.materiaRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Materia materia) {
        this.materiaRepository.actualizar(materia);
    }

    @Override
    public void borrar(Integer id) {
        this.materiaRepository.eliminar(id);
    }

    @Override
    public void guardar(Materia materia) {
        this.materiaRepository.insertar(materia);
    }

    @Override
    public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
        List<Materia> lista =  this.materiaRepository.seleccionarPorIdEstudiante(id);
        List<MateriaTO> listaFinal = new ArrayList<>();
        for(Materia mate : lista){
            listaFinal.add(this.convertir(mate));
        }

        return listaFinal;
    }

    private MateriaTO convertir(Materia materia) {
        MateriaTO materiaTO = new MateriaTO();
        materiaTO.setId(materia.getId());
        materiaTO.setCreditos(materia.getCreditos());
        materiaTO.setDescripcion(materia.getDescripcion());
        materiaTO.setNombre(materia.getNombre());
        materiaTO.setSemestre(materia.getSemestre());
        return materiaTO;
    }

}
