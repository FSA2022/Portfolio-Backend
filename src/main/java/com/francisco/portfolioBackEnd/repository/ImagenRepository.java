
package com.francisco.portfolioBackEnd.repository;

import com.francisco.portfolioBackEnd.entity.ImagenNavbar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenNavbar, Long>{
}
