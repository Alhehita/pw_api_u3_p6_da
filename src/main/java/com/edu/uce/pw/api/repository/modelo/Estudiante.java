package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante",allocationSize = 1)
	@GeneratedValue(generator = "Seq_estudiante", strategy = GenerationType.SEQUENCE)
	@Column(name="estu_id")
	private Integer id;
	@Column(name="estu_nombre")
	private String nombre;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_fecha_nacimiento")
	private LocalDateTime fechaNaciomiento;
	
	//Get y Set	
	
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
	
	

}
