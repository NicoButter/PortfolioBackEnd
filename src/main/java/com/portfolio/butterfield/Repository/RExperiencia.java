package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByNombre(String nombre);
    
    //public Optional<Experiencia> findById(int id);
    
    public boolean existsByNombre(String nombre);
    
    public boolean existsById(int Id);
    
}
