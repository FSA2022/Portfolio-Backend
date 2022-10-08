package com.francisco.portfolioBackEnd.controller;

import com.francisco.portfolioBackEnd.DTO.Mensaje;
import com.francisco.portfolioBackEnd.entity.Educacion;
import com.francisco.portfolioBackEnd.service.EducacionService;
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
@RequestMapping("/api/educacion")
@CrossOrigin(origins = "https://francisco-almiron.web.app")
//@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {
     @Autowired
            
  
     EducacionService educacionService;
    /*private final EducacionService educacionService;
    
     public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }*/
     @GetMapping("/detalle/{id}")
   
    public ResponseEntity<Educacion> getOne(@PathVariable Long id){
        if(!educacionService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe esa educacion"), HttpStatus.NOT_FOUND);
        Educacion edu = educacionService.obtenerPorId(id).get();
        return new ResponseEntity<Educacion>(edu, HttpStatus.OK);
    }
    
   @PutMapping("/actualizar/{id}")
   
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Educacion educacion, @PathVariable("id") Long id){
        if(!educacionService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(educacion.getTituloEdu()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacion.getInstitucionEdu()))
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(educacion.getFecha_inicioEdu()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);         
        if(StringUtils.isBlank( educacion.getFecha_finEdu()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(educacion.getImagenEdu()))
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);        
        
        
       
        Educacion eduUpdate = educacionService.obtenerPorId(id).get();
        eduUpdate.setTituloEdu(educacion.getTituloEdu());
        eduUpdate.setInstitucionEdu(educacion.getInstitucionEdu());
        eduUpdate.setFecha_inicioEdu(educacion.getFecha_inicioEdu());
        eduUpdate.setFecha_finEdu(educacion.getFecha_finEdu());       
        eduUpdate.setImagenEdu(educacion.getImagenEdu());
        educacionService.guardar(eduUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
     /*@PutMapping("/actualizar/{id}")
    public ResponseEntity<Educacion>actualizarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion = educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);       
    }*/
     
    @GetMapping("/todos") 
  
     public ResponseEntity<List<Educacion>>obtenerEducacion(){
     List<Educacion>educaciones = educacionService.buscarEducacion();
     return new ResponseEntity<>(educaciones, HttpStatus.OK);
     }
     
     @PostMapping("/nuevo")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Educacion>crearEducacion(@RequestBody Educacion educacion){
     Educacion newEducacion = educacionService.nuevaEducacion(educacion);
     return new ResponseEntity<>(newEducacion, HttpStatus.CREATED);     
     
     }
     
     
    /* @DeleteMapping("/eliminar/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!educacionService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
        educacionService.borrar(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }*/
     
     @DeleteMapping("eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<?>borrarEducacion(@PathVariable Long id){
     educacionService.eliminarEducacion(id);
     return new ResponseEntity<>(HttpStatus.OK);
     }
     
}  
   /*  @PutMapping("/actualizar/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Educacion educacion, @PathVariable("id") Long id){
        if(!educacionService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);              
       
        Educacion eduUpdate = educacionService.obtenerPorId(id).get();
        eduUpdate.setTituloEdu(educacion.getTituloEdu());
        eduUpdate.setInstitucionEdu(educacion.getInstitucionEdu());
        eduUpdate.setFecha_inicioEdu(educacion.getFecha_inicioEdu());
        eduUpdate.setFecha_finEdu(educacion.getFecha_finEdu());       
        eduUpdate.setImagenEdu(educacion.getImagenEdu());               
        educacionService.nuevaEducacion(eduUpdate);
        return new ResponseEntity(new Mensaje("Registro actualizado"), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!educacionService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
        educacionService.borrar(id);
        return new ResponseEntity(new Mensaje("Registro eliminado"), HttpStatus.OK);
    }

}
    
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/buscarEducacion")
  
    public ResponseEntity<List<Educacion>> getbuscarEducacion(){
        List<Educacion> buscarEducacion = educacionService.buscarEducacion();
        return new ResponseEntity<List<Educacion>>(buscarEducacion, HttpStatus.OK);
    }
    
    
   @PostMapping("nuevoEducacion")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Educacion educacion){
        if(StringUtils.isBlank(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoService.existePorNombre(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        productoService.guardar(producto);
        return new ResponseEntity(new Mensaje("producto guardado"), HttpStatus.CREATED);
    }


    @PutMapping("/actualizar/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable("id") Long id){
        if(!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(producto.getNombreProducto()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoService.existePorNombre(producto.getNombreProducto()) &&
                productoService.obtenerPorNombre(producto.getNombreProducto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Producto prodUpdate = productoService.obtenerPorId(id).get();
        prodUpdate.setNombreProducto(producto.getNombreProducto());
        prodUpdate.setPrecio(producto.getPrecio());
        productoService.guardar(prodUpdate);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.CREATED);
    }


    @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
        productoService.borrar(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }*/
