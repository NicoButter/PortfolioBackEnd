package com.portfolio.butterfield.Repository;

import com.portfolio.butterfield.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRepositoryPersona extends JpaRepository<Persona, Long> {
   
}
