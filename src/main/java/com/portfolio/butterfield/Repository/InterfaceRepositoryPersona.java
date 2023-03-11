package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRepositoryPersona extends JpaRepository<Persona, Integer> {
   
    public Optional<Persona> findByNombre(String nombre);
   
    public boolean existsByNombre(String nombre);
    
}
