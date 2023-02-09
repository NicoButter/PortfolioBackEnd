package com.portfolio.butterfield.Service;

import com.portfolio.butterfield.Entity.Persona;
import com.portfolio.butterfield.Interface.InterfaceServicePersona;
import com.portfolio.butterfield.Repository.InterfaceRepositoryPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePersona implements InterfaceServicePersona{
    
    //INYECCION DE DEPEDENCIA
    @Autowired InterfaceRepositoryPersona repositorioDePersona;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = repositorioDePersona.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        repositorioDePersona.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        repositorioDePersona.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = repositorioDePersona.findById(id).orElse(null);
        return persona;
    } 
}
