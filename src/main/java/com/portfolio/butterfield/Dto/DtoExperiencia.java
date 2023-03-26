package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class DtoExperiencia {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
}
