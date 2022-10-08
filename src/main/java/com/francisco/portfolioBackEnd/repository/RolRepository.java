package com.francisco.portfolioBackEnd.repository;

import com.francisco.portfolioBackEnd.entity.Rol;
import com.francisco.portfolioBackEnd.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
