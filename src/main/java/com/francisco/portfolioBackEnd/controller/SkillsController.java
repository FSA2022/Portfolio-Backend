package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.Skills;
import com.francisco.portfolioBackEnd.service.SkillsService;
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
@RequestMapping("/api/skill")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    @Autowired
    SkillsService skillsService;
    
    
    @GetMapping("/detalle/{id}")
   
    public ResponseEntity<Skills> getOne(@PathVariable Long id){
        if(!skillsService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe esa educacion"), HttpStatus.NOT_FOUND);
        Skills sk = skillsService.obtenerPorId(id).get();
        return new ResponseEntity<Skills>(sk, HttpStatus.OK);
    }
    
   @PutMapping("/actualizar/{id}")
  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Skills skills, @PathVariable("id") Long id){
        if(!skillsService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(skills.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skills.getImagenSkill()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
        /*if(StringUtils.isBlank(skills.getPorcentajeSkill()))
            return new ResponseEntity(new Mensaje("El numero es obligatorio"), HttpStatus.BAD_REQUEST);  */
               
        
        
       
        Skills skUpdate = skillsService.obtenerPorId(id).get();
        skUpdate.setNombreSkill(skills.getNombreSkill());
        skUpdate.setImagenSkill(skills.getImagenSkill());
        skUpdate.setPorcentajeSkill(skills.getPorcentajeSkill());
        
        skillsService.guardar(skUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    @GetMapping("/todos") 
     public ResponseEntity<List<Skills>>obtenerSkill(){
     List<Skills>skills = skillsService.buscarSkills();
     return new ResponseEntity<>(skills, HttpStatus.OK);
     }
     
     @PostMapping("/nuevo")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Skills>crearSkill(@RequestBody Skills skills){
     Skills newSkill = skillsService.nuevoSkills(skills);
     return new ResponseEntity<>(newSkill, HttpStatus.CREATED);     
     
     }
    
     @DeleteMapping("eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<?>borrarkill(@PathVariable Long id){
     skillsService.eliminarSkills(id);
     return new ResponseEntity<>(HttpStatus.OK);
     }
}