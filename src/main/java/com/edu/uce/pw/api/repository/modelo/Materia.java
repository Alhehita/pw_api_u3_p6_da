package com.edu.uce.pw.api.repository.modelo;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "materia")
public class Materia {

    @Id
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia",allocationSize = 1)
	@Column(name="mate_id")
	private Integer id;

	@Column(name="mate_nombre")
	private String nombre;

	@Column(name="mate_creditos")
	private Integer creditos;

	@Column(name="mate_semestre")
    private String semestre;

	@Column(name="mate_descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "mate_id_estudiante")
    private Estudiante estudiante;


    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }


    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
	
	
	
    
}
