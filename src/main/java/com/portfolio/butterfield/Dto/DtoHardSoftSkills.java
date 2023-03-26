package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class DtoHardSoftSkills {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    /*@NotBlank
    private String img;*/

    public DtoHardSoftSkills() {
    }

    public DtoHardSoftSkills(String nombre, int porcentaje/*, String img*/) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        /*this.img = img;*/
    }
    
}
