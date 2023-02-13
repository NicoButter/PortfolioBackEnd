package com.portfolio.butterfield.Security.Repository;

import com.portfolio.butterfield.Security.Entity.Rol;
import com.portfolio.butterfield.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
