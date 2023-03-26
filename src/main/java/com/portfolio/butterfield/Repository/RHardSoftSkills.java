package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.HardSoftSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHardSoftSkills extends JpaRepository<HardSoftSkills, Integer>{
    
    Optional<HardSoftSkills> findByNombre(String nombre);
   
    public boolean existsByNombre(String nombre);
    
}
