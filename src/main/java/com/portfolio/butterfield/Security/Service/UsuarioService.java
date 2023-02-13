package com.portfolio.butterfield.Security.Service;

import com.portfolio.butterfield.Security.Entity.Usuario;
import com.portfolio.butterfield.Security.Repository.InterfaceUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    InterfaceUsuarioRepository interfaceUsuarioRepository;
    
    public Optional<Usuario> getByUsuario(String usuario){
        return interfaceUsuarioRepository.findByNombreUsuario(usuario);
    }
    
    public boolean existsByUsuario(String usuario){
        return interfaceUsuarioRepository.existsByNombreUsuario(usuario);
    }
    
    public boolean existsByEmail(String email){
        return interfaceUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        interfaceUsuarioRepository.save(usuario);
    }
    
}
