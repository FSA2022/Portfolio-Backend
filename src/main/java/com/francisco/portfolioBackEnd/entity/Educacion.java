package com.francisco.portfolioBackEnd.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tituloEdu; 
    private String institucionEdu;     
    private String fecha_inicioEdu; 
    private String fecha_finEdu;     
    private String imagenEdu;
    

    public Educacion() {
    }

    public Educacion(Long id, String tituloEdu, String institucionEdu, String fecha_inicioEdu, String fecha_finEdu, String imagenEdu ) {
        this.id = id;
        this.tituloEdu = tituloEdu;
        this.institucionEdu = institucionEdu;
        this.fecha_inicioEdu = fecha_inicioEdu;
        this.fecha_finEdu = fecha_finEdu;
       this.imagenEdu = imagenEdu;
        
    }

    

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getInstitucionEdu() {
        return institucionEdu;
    }

    public void setInstitucionEdu(String institucionEdu) {
        this.institucionEdu = institucionEdu;
    }

    public String getFecha_inicioEdu() {
        return fecha_inicioEdu;
    }

    public void setFecha_inicioEdu(String fecha_inicioEdu) {
        this.fecha_inicioEdu = fecha_inicioEdu;
    }

    public String getFecha_finEdu() {
        return fecha_finEdu;
    }

    public void setFecha_finEdu(String fecha_finEdu) {
        this.fecha_finEdu = fecha_finEdu;
    }

  public String getImagenEdu() {
        return imagenEdu;
    }

    public void setImagenEdu(String imagenEdu) {
        this.imagenEdu = imagenEdu;
    }
}
