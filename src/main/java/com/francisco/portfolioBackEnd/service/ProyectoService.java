package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Proyecto;
import com.francisco.portfolioBackEnd.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }
    
    public Proyecto nuevoProyecto (Proyecto proyecto){
    return proyectoRepository.save(proyecto);
    }  
    
    public List<Proyecto>buscarProyecto(){
    return proyectoRepository.findAll();
    }
    
    public Proyecto editarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
    
    public void eliminarProyecto(Long id){
        proyectoRepository.deleteById(id);
    }
    
     public boolean existePorId(Long id){
        return proyectoRepository.existsById(id);
    }
     
     
     public Optional<Proyecto> obtenerPorId(Long id){
        return proyectoRepository.findById(id);
    }
  
      public void guardar(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }

    public void borrar(Long id){
        proyectoRepository.deleteById(id);
    }
}
