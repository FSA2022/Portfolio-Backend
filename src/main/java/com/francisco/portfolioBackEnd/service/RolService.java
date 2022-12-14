package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.Rol;
import com.francisco.portfolioBackEnd.enums.RolNombre;
import com.francisco.portfolioBackEnd.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}