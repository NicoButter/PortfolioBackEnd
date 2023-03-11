package com.portfolio.butterfield.Controller;

import com.portfolio.butterfield.Dto.DtoPersona;
import com.portfolio.butterfield.Entity.Persona;
import com.portfolio.butterfield.Security.Controller.Mensaje;
import com.portfolio.butterfield.Service.ServicePersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerPersona {
    
    @Autowired
    ServicePersona personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, DtoPersona dtoPersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encuentra esa persona."), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtoPersona.getNombre()) && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio."), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setImg(dtoPersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Regsitro persona actualizado."), HttpStatus.OK);
    }
    
}
























/* @Autowired InterfaceServicePersona servicioDePersona;
    @Autowired SExperiencia sExperiencia;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return servicioDePersona.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        servicioDePersona.savePersona(persona);
        return "La persona fue agregada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/eliminar/{id}")
    public String deletePersona(@PathVariable Long id){
        servicioDePersona.deletePersona(id);
        return "La perssona fue eliminada de la base de datos correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        Persona persona = servicioDePersona.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        servicioDePersona.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return servicioDePersona.findPersona((long)1);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }*/