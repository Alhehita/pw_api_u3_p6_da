package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")

public class Estudiante {
	
	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante",allocationSize = 1)
	@Column(name="estu_id")
	private Integer id;
	
	@Column(name="estu_nombre")
	private String nombre;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_fecha_nacimiento")
	private LocalDateTime fechaNaciomiento;
	
	@Column(name="estu_genero")
	private String genero;

	@Column(name="estu_cedula")
	private String cedula;

	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
	private List<Materia> materias;
	
	//Get y Set	

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNaciomiento() {
		return fechaNaciomiento;
	}
	public void setFechaNaciomiento(LocalDateTime fechaNaciomiento) {
		this.fechaNaciomiento = fechaNaciomiento;
	}
	public Integer getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNaciomiento="
				+ fechaNaciomiento + ", genero=" + genero + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	

}
