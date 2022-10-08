package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.Persona;
import com.francisco.portfolioBackEnd.service.PersonaService;
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
@RequestMapping("/api/persona")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    PersonaService personaService ;
    
     @GetMapping("/lista")
  
    public ResponseEntity<List<Persona>> getLista(){
        List<Persona> lista = personaService.obtenerTodos();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }


    @GetMapping("/detalle/{id}")
   
    public ResponseEntity<Persona> getOne(@PathVariable Long id){
        if(!personaService.existePorId(id))
            return new ResponseEntity(new Mensaje("no se encontro registro"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.obtenerPorId(id).get();
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    
    @PostMapping("/nueva")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Persona persona) {
        if(StringUtils.isBlank(persona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getApellido()))
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatoria"), HttpStatus.BAD_REQUEST);         
        if(StringUtils.isBlank(persona.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getFotoperfil()))
            return new ResponseEntity(new Mensaje("La foto de perfil es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getFotobanner()))
            return new ResponseEntity(new Mensaje("La foto de de fondo es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getProvincia()))
            return new ResponseEntity(new Mensaje("La provincia es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getCiudad()))
            return new ResponseEntity(new Mensaje("La ciudad es obligatoria"), HttpStatus.BAD_REQUEST);      
               
       
      personaService.guardar(persona);
      return new ResponseEntity(new Mensaje("Registro guardado"), HttpStatus.CREATED);       
   }
        
    @PutMapping("/actualizar/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Persona persona, @PathVariable("id") Long id){
        if(!personaService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(persona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getApellido()))
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatoria"), HttpStatus.BAD_REQUEST);         
        if(StringUtils.isBlank(persona.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getFotoperfil()))
            return new ResponseEntity(new Mensaje("La foto de perfil es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(persona.getFotobanner()))
            return new ResponseEntity(new Mensaje("La foto de de fondo es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(persona.getCiudad()))
            return new ResponseEntity(new Mensaje("La ciudad es obligatoria"), HttpStatus.BAD_REQUEST);       
        if(StringUtils.isBlank(persona.getProvincia()))
            return new ResponseEntity(new Mensaje("La provincia es obligatoria"), HttpStatus.BAD_REQUEST);
        
       
        Persona perUpdate = personaService.obtenerPorId(id).get();
        perUpdate.setNombre(persona.getNombre());
        perUpdate.setApellido(persona.getApellido());
        perUpdate.setTitulo(persona.getTitulo());
        perUpdate.setDescripcion(persona.getDescripcion());       
        perUpdate.setFotoperfil(persona.getFotoperfil());
        perUpdate.setFotobanner(persona.getFotobanner()); 
        perUpdate.setCiudad(persona.getCiudad());
        perUpdate.setProvincia(persona.getProvincia());        
        personaService.guardar(perUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!personaService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
        personaService.borrar(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }

}

