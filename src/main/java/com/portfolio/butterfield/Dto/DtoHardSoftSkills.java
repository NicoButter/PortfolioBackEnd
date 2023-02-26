package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DtoHardSoftSkills {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoHardSoftSkills() {
    }

    public DtoHardSoftSkills(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
}
