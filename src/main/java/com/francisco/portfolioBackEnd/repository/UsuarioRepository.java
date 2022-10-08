package com.francisco.portfolioBackEnd.repository;

import com.francisco.portfolioBackEnd.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nu);
    boolean existsByNombreUsuario(String nu);
    boolean existsByEmail(String email);
}
