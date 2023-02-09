package com.portfolio.butterfield.Interface;

import com.portfolio.butterfield.Entity.Persona;
import java.util.List;

public interface InterfaceServicePersona {

    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);    
}
