
package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Persona;
import com.francisco.portfolioBackEnd.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    @Autowired
     PersonaRepository personaRepository;
     
     public List<Persona> obtenerTodos(){
        List<Persona> lista = personaRepository.findAll();
        return lista;
    }

    public Optional<Persona> obtenerPorId(Long id){
        return personaRepository.findById(id);
    }
    public void guardar(Persona persona){
        personaRepository.save(persona);
    }
    public Persona editarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void borrar(Long id){
        personaRepository.deleteById(id);
    }    

    public boolean existePorId(Long id){
        return personaRepository.existsById(id);
    }
}
