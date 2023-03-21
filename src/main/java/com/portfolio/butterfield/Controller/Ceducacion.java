
package com.portfolio.butterfield.Controller;

import com.portfolio.butterfield.Dto.DtoEducacion;
import com.portfolio.butterfield.Entity.Educacion;
import com.portfolio.butterfield.Security.Controller.Mensaje;
import com.portfolio.butterfield.Service.Seducacion;
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
@RequestMapping("educacion/")
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfoliofrontendbutterfield.web.app/"})
public class Ceducacion {
    
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("lista")
    public ResponseEntity<List<Educacion>> lista(){
         List<Educacion> list = sEducacion.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable ("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
        
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese ID."), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
        if(StringUtils.isBlank(dtoEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio,"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreE(dtoEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        Educacion esducacion = new Educacion(dtoEducacion.getNombreE(), dtoEducacion.getDescripcionE());
        sEducacion.save(esducacion);
        return new ResponseEntity(new Mensaje("Educación creada con éxito"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity (new Mensaje("No existe el registro."), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombreE(dtoEducacion.getNombreE()) && sEducacion.getByNombreE(dtoEducacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoEducacion.getNombreE());
        educacion.setDescripcionE(dtoEducacion.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje(" Educacion actualizada co éxito"), HttpStatus.OK);
    } 
    
}
