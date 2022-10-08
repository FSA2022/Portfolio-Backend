package com.francisco.portfolioBackEnd.repository;

import com.francisco.portfolioBackEnd.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
