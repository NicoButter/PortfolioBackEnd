package com.portfolio.butterfield.Controller;

import com.portfolio.butterfield.Dto.DtoProject;
import com.portfolio.butterfield.Entity.Project;
import com.portfolio.butterfield.Security.Controller.Mensaje;
import com.portfolio.butterfield.Service.ServiceProject;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfoliofrontendbutterfield.firebaseapp.com"})
public class CProject {
    
    @Autowired
    ServiceProject projectService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = projectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id){
        if(!projectService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoProject){
        if(StringUtils.isBlank(dtoProject.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(projectService.existsByNombre(dtoProject.getNombre()))
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"),HttpStatus.BAD_REQUEST);
        Project project = new Project(dtoProject.getNombre(), dtoProject.getDescripcion(), dtoProject.getImg());
        projectService.save(project);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada con éxito."), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!projectService.existsById(id)){
            return new ResponseEntity(new Mensaje("Error al intentar eliminar el proyecto solicitado, reintente."), HttpStatus.NOT_FOUND);
        }
        projectService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado con éxito."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProject dtoProject){
        if(!projectService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encuentra el proyecto."), HttpStatus.NOT_FOUND);
        }
        if(projectService.existsByNombre(dtoProject.getNombre()) && projectService.getByNombre(dtoProject.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProject.getNombre())){
            return new ResponseEntity(new Mensaje("El campo 'NOMBRE' no puede estar vacio."), HttpStatus.BAD_REQUEST);
        }
        
        Project project = projectService.getOne(id).get();
        
        project.setNombre(dtoProject.getNombre());
        project.setDescripcion(dtoProject.getDescripcion());
        project.setImg(dtoProject.getImg());
        
        projectService.save(project);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado con éxito."), HttpStatus.OK);
    }
    
}
