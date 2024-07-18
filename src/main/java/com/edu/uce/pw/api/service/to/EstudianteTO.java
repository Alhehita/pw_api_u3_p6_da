package com.edu.uce.pw.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;


public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable{

    private static final long serialVersionUID = 7085562941894409723L;

    private Integer id;
	
	private String nombre;
	
	private String apellido;

	private LocalDateTime fechaNaciomiento;
	
	private String genero;

  //  private List<MateriaTO> materias;
    
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    // public List<MateriaTO> getMaterias() {
    //     return materias;
    // }

    // public void setMaterias(List<MateriaTO> materias) {
    //     this.materias = materias;
    // }
    
}
