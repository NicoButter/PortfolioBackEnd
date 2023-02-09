package com.portfolio.butterfield.Controller;

import com.portfolio.butterfield.Entity.Persona;
import com.portfolio.butterfield.Interface.InterfaceServicePersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPersona {
    
    @Autowired InterfaceServicePersona servicioDePersona;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return servicioDePersona.getPersona();
    }
    
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        servicioDePersona.savePersona(persona);
        return "La persona fue agregada correctamente";
    }
    
    @DeleteMapping("personas/eliminar/{id}")
    public String deletePersona(@PathVariable Long id){
        servicioDePersona.deletePersona(id);
        return "La perssona fue eliminada de la base de datos correctamente";
    }
    
    @PutMapping("personas/editar/{id}")
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
}
