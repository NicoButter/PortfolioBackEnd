package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class DtoExperiencia {
    
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descriptionE;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descriptionE) {
        this.nombreE = nombreE;
        this.descriptionE = descriptionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
    
    
}
