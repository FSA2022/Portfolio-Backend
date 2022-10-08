package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.Proyecto;
import com.francisco.portfolioBackEnd.service.ProyectoService;
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
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;
    
    
    @GetMapping("/detalle/{id}")
   
    public ResponseEntity<Proyecto> getOne(@PathVariable Long id){
        if(!proyectoService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe esa educacion"), HttpStatus.NOT_FOUND);
        Proyecto pro = proyectoService.obtenerPorId(id).get();
        return new ResponseEntity<Proyecto>(pro, HttpStatus.OK);
    }
    
   @PutMapping("/actualizar/{id}")
  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Proyecto proyecto, @PathVariable("id") Long id){
        if(!proyectoService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(proyecto.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(proyecto.getFechaPro()))
            return new ResponseEntity(new Mensaje("El numero es obligatorio"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(proyecto.getDescripcionPro()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
       if(StringUtils.isBlank(proyecto.getImagenPro()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
       if(StringUtils.isBlank(proyecto.getLinkPro()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
            
                              
       
        Proyecto proUpdate = proyectoService.obtenerPorId(id).get();
        proUpdate.setNombrePro(proyecto.getNombrePro());
        proUpdate.setFechaPro(proyecto.getFechaPro());
        proUpdate.setDescripcionPro(proyecto.getDescripcionPro());
        proUpdate.setImagenPro(proyecto.getImagenPro());
        proUpdate.setLinkPro(proyecto.getLinkPro());
        
        proyectoService.guardar(proUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    @GetMapping("/todos") 
     public ResponseEntity<List<Proyecto>>obtenerSkill(){
     List<Proyecto>proyecto = proyectoService.buscarProyecto();
     return new ResponseEntity<>(proyecto, HttpStatus.OK);
     }
     
     @PostMapping("/nuevo")
    @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Proyecto>crearSkill(@RequestBody Proyecto proyecto){
     Proyecto newSkill = proyectoService.nuevoProyecto(proyecto);
     return new ResponseEntity<>(newSkill, HttpStatus.CREATED);     
     
     }
    
     @DeleteMapping("eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<?>borrarkill(@PathVariable Long id){
     proyectoService.eliminarProyecto(id);
     return new ResponseEntity<>(HttpStatus.OK);
     }
}
