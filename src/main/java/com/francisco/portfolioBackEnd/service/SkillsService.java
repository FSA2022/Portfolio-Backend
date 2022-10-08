package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Skills;
import com.francisco.portfolioBackEnd.repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    private final SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }
    
    public Skills nuevoSkills (Skills skills){
    return skillsRepository.save(skills);
    }  
    
    public List<Skills>buscarSkills(){
    return skillsRepository.findAll();
    }
    
    public Skills editarSkills(Skills skills) {
        return skillsRepository.save(skills);
    }
    
    public void eliminarSkills(Long id){
        skillsRepository.deleteById(id);
    }
    public boolean existePorId(Long id){
        return skillsRepository.existsById(id);
    }
    
     public Optional<Skills> obtenerPorId(Long id){
        return skillsRepository.findById(id);
    }
     public void guardar(Skills skills){
        skillsRepository.save(skills);
    }

    public void borrar(Long id){
        skillsRepository.deleteById(id);
    }  
}
