package com.portfolio.butterfield.Service;

import com.portfolio.butterfield.Entity.Project;
import com.portfolio.butterfield.Repository.RepositorioProject;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceProject{
    
    //INYECCION DE DEPEDENCIA
    @Autowired 
    RepositorioProject repositorioDeProject;
    
    public List<Project> list(){
        return repositorioDeProject.findAll();
    }
    
    public Optional<Project> getOne(int id){
        return repositorioDeProject.findById(id);
    }
    
    public Optional<Project> getByNombre(String nombre){
        return repositorioDeProject.findByNombre(nombre);
    }
    
    public void save (Project project){
        repositorioDeProject.save(project);
    }
    
    public void delete(int id){
        repositorioDeProject.deleteById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repositorioDeProject.existsByNombre(nombre);
    }
    
    public boolean existsById(int id){
        return repositorioDeProject.existsById(id);
    }
    
}