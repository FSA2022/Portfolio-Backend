package com.francisco.portfolioBackEnd.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "experiencia")
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;
    private String empresaExp; 
    private String puestoExp;     
    private String fecha_inicioExp; 
    private String fecha_finExp;    
    private String descripcionExp;
    private String imagenExp;
    
    public Experiencia() {
    }

    public Experiencia(Long idExp, String empresaExp, String puestoExp, String fecha_inicioExp, String fecha_finExp, String descripcionExp, String imagenExp) {
        this.idExp = idExp;
        this.empresaExp = empresaExp;
        this.puestoExp = puestoExp;
        this.fecha_inicioExp = fecha_inicioExp;
        this.fecha_finExp = fecha_finExp;
        this.descripcionExp = descripcionExp;
        this.imagenExp = imagenExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getEmpresaExp() {
        return empresaExp;
    }

    public void setEmpresaExp(String empresaExp) {
        this.empresaExp = empresaExp;
    }

    public String getPuestoExp() {
        return puestoExp;
    }

    public void setPuestoExp(String puestoExp) {
        this.puestoExp = puestoExp;
    }

    public String getFecha_inicioExp() {
        return fecha_inicioExp;
    }

    public void setFecha_inicioExp(String fecha_inicioExp) {
        this.fecha_inicioExp = fecha_inicioExp;
    }

    public String getFecha_finExp() {
        return fecha_finExp;
    }

    public void setFecha_finExp(String fecha_finExp) {
        this.fecha_finExp = fecha_finExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    
    
    public String getImagenExp() {
        return imagenExp;
    }

    public void setImagenExp(String imagenExp) {
        this.imagenExp = imagenExp;
    }
}
