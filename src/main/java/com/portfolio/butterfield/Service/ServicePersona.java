package com.portfolio.butterfield.Service;

import com.portfolio.butterfield.Entity.Persona;
import com.portfolio.butterfield.Repository.InterfaceRepositoryPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicePersona{
    
    //INYECCION DE DEPEDENCIA
    @Autowired 
    InterfaceRepositoryPersona repositorioDePersona;
    
    public List<Persona> list(){
        return repositorioDePersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return repositorioDePersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return repositorioDePersona.findByNombre(nombre);
    }
    
    public void save (Persona persona){
        repositorioDePersona.save(persona);
    }
    
    public void delete(int id){
        repositorioDePersona.deleteById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repositorioDePersona.existsByNombre(nombre);
    }
    
    public boolean existsById(int id){
        return repositorioDePersona.existsById(id);
    }
    
}

