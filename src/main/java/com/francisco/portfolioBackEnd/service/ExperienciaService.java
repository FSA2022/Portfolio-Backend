
package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Experiencia;
import com.francisco.portfolioBackEnd.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }
    
    public Experiencia nuevaExperiencia (Experiencia experiencia){
    return experienciaRepository.save(experiencia);
    }  
    
    public List<Experiencia>buscarExperiencia(){
    return experienciaRepository.findAll();
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }
    
    public void eliminarExperiencia(Long id){
        experienciaRepository.deleteById(id);
    }
     public boolean existePorId(Long id){
        return experienciaRepository.existsById(id);
    }
     
     
     public Optional<Experiencia> obtenerPorId(Long id){
        return experienciaRepository.findById(id);
    }
     public void guardar(Experiencia educacion){
        experienciaRepository.save(educacion);
    }

    public void borrar(Long id){
        experienciaRepository.deleteById(id);
    }   
}
