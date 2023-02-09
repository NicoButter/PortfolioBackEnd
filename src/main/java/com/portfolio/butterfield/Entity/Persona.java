package com.portfolio.butterfield.Entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    //@Size(min = 1, max = 30, message = "Error, el nomnbre debe contener mas de un caracter y menos de 30.")
    private String nombre;
    
    @NotNull
    //@Size(min = 1, max = 30, message = "Error, el apellido debe contener mas de un caracter y menos de 30.")
    private String apellido;
    
    //@Size(min = 1, max = 30, message = "Error, el nomnre debe contener mas de un caracter y menos de 30.")
    private String img;  
}
