package com.portfolio.butterfield.Security.Service;

import com.portfolio.butterfield.Security.Entity.Rol;
import com.portfolio.butterfield.Security.Enums.RolNombre;
import com.portfolio.butterfield.Security.Repository.InterfaceRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    InterfaceRolRepository interfaceRolRepository;
    
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
        return interfaceRolRepository.findByRolNombre(rolNombre);
    }
   
    public void save(Rol rol){
        interfaceRolRepository.save(rol);
    }
}
