package com.portfolio.butterfield.Service;

import com.portfolio.butterfield.Entity.HardSoftSkills;
import com.portfolio.butterfield.Repository.RHardSoftSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHardSoftSkills {
    
    @Autowired
    RHardSoftSkills rhys;
    
    public List<HardSoftSkills> list (){
        return rhys.findAll();      
    }
    
    public Optional<HardSoftSkills> getOne(int id){
        return rhys.findById(id);
    }
    
    public Optional<HardSoftSkills>getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }
    
    public void save(HardSoftSkills skills){
        rhys.save(skills);
    }
    
    public void delete(int id){
        rhys.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
    
}
