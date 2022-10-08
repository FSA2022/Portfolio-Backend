package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.ImagenNavbar;
import com.francisco.portfolioBackEnd.service.ImagenNavbarService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/imagennavbar")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ImagenNavbarController {
    @Autowired
    
    ImagenNavbarService imagenNavbarService;
    
    @GetMapping("/lista")
  
    public ResponseEntity<List<ImagenNavbar>> getLista(){
        List<ImagenNavbar> lista = imagenNavbarService.obtenerTodos();
        return new ResponseEntity<List<ImagenNavbar>>(lista, HttpStatus.OK);
    }


    @GetMapping("/detalle/{id}")
    public ResponseEntity<ImagenNavbar> getOne(@PathVariable Long id){
        if(!imagenNavbarService.existePorId(id))
            return new ResponseEntity(new Mensaje("no se encontro registro"), HttpStatus.NOT_FOUND);
        ImagenNavbar imagenNavbar = imagenNavbarService.obtenerPorId(id).get();
        return new ResponseEntity<ImagenNavbar>(imagenNavbar, HttpStatus.OK);
    }
    
    
    @PostMapping("/nueva")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody ImagenNavbar imagenNavbar) {
        if(StringUtils.isBlank(imagenNavbar.getImagen()))
            return new ResponseEntity(new Mensaje("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(imagenNavbar.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);        
        
       
      imagenNavbarService.guardar(imagenNavbar);
      return new ResponseEntity(new Mensaje("Registro guardado"), HttpStatus.CREATED);       
   }
        
    @PutMapping("/actualizar/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    
    public ResponseEntity<?> update(@RequestBody ImagenNavbar imagenNavbar, @PathVariable("id") Long id){
        if(StringUtils.isBlank(imagenNavbar.getImagen()))
            return new ResponseEntity(new Mensaje("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(imagenNavbar.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);        
        
        
        ImagenNavbar imagenUpdate = imagenNavbarService.obtenerPorId(id).get();
        imagenUpdate.setImagen(imagenNavbar.getImagen());
        imagenUpdate.setTitulo(imagenNavbar.getTitulo());
               
        imagenNavbarService.guardar(imagenUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    //@PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!imagenNavbarService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
        imagenNavbarService.borrar(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }
}
