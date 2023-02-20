package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByNombreE(String nombreE);
    
    //public Optional<Experiencia> findById(int id);
    
    public boolean existsByNombreE(String nombreE);
    
    public boolean existsById(int Id);
    
    
}
