package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.Experiencia;
import com.francisco.portfolioBackEnd.service.ExperienciaService;
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
@RequestMapping("/api/experiencia")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    
    @GetMapping("/detalle/{id}")
   
    public ResponseEntity<Experiencia> getOne(@PathVariable Long id){
        if(!experienciaService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe esa educacion"), HttpStatus.NOT_FOUND);
        Experiencia exp = experienciaService.obtenerPorId(id).get();
        return new ResponseEntity<Experiencia>(exp, HttpStatus.OK);
    }
    
   @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Experiencia experiencia, @PathVariable("id") Long id){
        if(!experienciaService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(experiencia.getEmpresaExp()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experiencia.getPuestoExp()))
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(experiencia.getFecha_inicioExp()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);         
        if(StringUtils.isBlank( experiencia.getFecha_finExp()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST); 
        if(StringUtils.isBlank( experiencia.getDescripcionExp()))
            return new ResponseEntity(new Mensaje("La eperiencia es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experiencia.getImagenExp()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
        
        
       
        Experiencia expUpdate = experienciaService.obtenerPorId(id).get();
        expUpdate.setEmpresaExp(experiencia.getEmpresaExp());
        expUpdate.setPuestoExp(experiencia.getPuestoExp());
        expUpdate.setFecha_inicioExp(experiencia.getFecha_inicioExp());
        expUpdate.setFecha_finExp(experiencia.getFecha_finExp());   
        expUpdate.setDescripcionExp(experiencia.getDescripcionExp());
        expUpdate.setImagenExp(experiencia.getImagenExp());
        experienciaService.guardar(expUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    @GetMapping("/todos")
    
     public ResponseEntity<List<Experiencia>>obtenerEducacion(){
     List<Experiencia>educaciones = experienciaService.buscarExperiencia();
     return new ResponseEntity<>(educaciones, HttpStatus.OK);
     }
     
     @PostMapping("/nuevo")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Experiencia>crearEducacion(@RequestBody Experiencia experiencia){
     Experiencia newEducacion = experienciaService.nuevaExperiencia(experiencia);
     return new ResponseEntity<>(newEducacion, HttpStatus.CREATED);     
     
     }
    
     @DeleteMapping("eliminar/{id}")
   @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<?>borrarEducacion(@PathVariable Long id){
     experienciaService.eliminarExperiencia(id);
     return new ResponseEntity<>(HttpStatus.OK);
     }
}
