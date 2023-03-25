package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProject extends JpaRepository<Project, Integer> {
   
    public Optional<Project> findByNombre(String nombre);
   
    public boolean existsByNombre(String nombre);
    
}
