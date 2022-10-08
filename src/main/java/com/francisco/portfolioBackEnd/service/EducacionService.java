package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Educacion;
import com.francisco.portfolioBackEnd.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    private final EducacionRepository educacionRepository;
    
    @Autowired
    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }
    
    
    public Educacion nuevaEducacion (Educacion educacion){
    return educacionRepository.save(educacion);
    }  
    
    public List<Educacion>buscarEducacion(){
    return educacionRepository.findAll();
    }
    
    public Educacion editarEducacion(Educacion educacion) {
        return educacionRepository.save(educacion);
    }
    
    public void eliminarEducacion(Long id){
        educacionRepository.deleteById(id);
    }
 
     public boolean existePorId(Long id){
        return educacionRepository.existsById(id);
    }
     
     
     public Optional<Educacion> obtenerPorId(Long id){
        return educacionRepository.findById(id);
    }
     public void guardar(Educacion educacion){
        educacionRepository.save(educacion);
    }

    public void borrar(Long id){
        educacionRepository.deleteById(id);
    } 
}
