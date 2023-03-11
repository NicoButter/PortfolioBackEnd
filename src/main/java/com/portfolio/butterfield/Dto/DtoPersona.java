package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DtoPersona {
    
    @NotBlank
    private String nombre;
   
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String img;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    
}
