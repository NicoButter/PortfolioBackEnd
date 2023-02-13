package com.portfolio.butterfield.Security.Service;

import com.portfolio.butterfield.Security.Entity.Usuario;
import com.portfolio.butterfield.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplement implements UserDetailsService{
    
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String Usuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByUsuario(Usuario).get();
        
        return UsuarioPrincipal.build(usuario);
    }
    
}
