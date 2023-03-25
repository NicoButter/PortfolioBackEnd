package com.portfolio.butterfield.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descripcionE;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descripcionE = descripcionE;
    }
    
}
