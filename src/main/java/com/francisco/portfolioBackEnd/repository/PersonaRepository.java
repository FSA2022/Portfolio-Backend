package com.francisco.portfolioBackEnd.repository;

import com.francisco.portfolioBackEnd.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}

