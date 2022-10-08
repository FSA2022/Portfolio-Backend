package com.francisco.portfolioBackEnd.service;

import com.francisco.portfolioBackEnd.entity.ImagenNavbar;
import com.francisco.portfolioBackEnd.repository.ImagenRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class ImagenNavbarService {
    @Autowired
     ImagenRepository imagenRepository;
     
      public List<ImagenNavbar> obtenerTodos(){
        List<ImagenNavbar> lista = imagenRepository.findAll();
        return lista;
    }

    public Optional<ImagenNavbar> obtenerPorId(Long id){
        return imagenRepository.findById(id);
    }
    public void guardar(ImagenNavbar imagenNavbar){
        imagenRepository.save(imagenNavbar);
    }

    public void borrar(Long id){
        imagenRepository.deleteById(id);
    }    

    public boolean existePorId(Long id){
        return imagenRepository.existsById(id);
    }
}
