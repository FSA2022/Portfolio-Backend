package com.francisco.portfolioBackEnd.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long idPro;
    private String nombrePro;
    private String fechaPro;   
    private String descripcionPro;
    private String imagenPro;
    private String linkPro;

    public Proyecto() {
    }

    public Proyecto(Long idPro, String nombrePro, String fechaPro, String descripcionPro, String imagenPro, String linkPro) {
        this.idPro = idPro;
        this.nombrePro = nombrePro;
        this.fechaPro = fechaPro;
        this.descripcionPro = descripcionPro;
        this.imagenPro = imagenPro;
        this.linkPro = linkPro;        
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getFechaPro() {
        return fechaPro;
    }

    public void setFechaPro(String fechaPro) {
        this.fechaPro = fechaPro;
    }

        
    
    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

        
    public String getImagenPro() {
        return imagenPro;
    }

    public void setImagenPro(String imagenPro) {
        this.imagenPro = imagenPro;
    }

    public String getLinkPro() {
        return linkPro;
    }

    public void setLinkPro(String linkPro) {
        this.linkPro = linkPro;
    }
}
