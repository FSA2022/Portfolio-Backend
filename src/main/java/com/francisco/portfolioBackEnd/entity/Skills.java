
package com.francisco.portfolioBackEnd.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "skills")
public class Skills implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSkill;
    private String nombreSkill;
    private String imagenSkill;
    @NotNull
    private int porcentajeSkill;

    public Skills() {
    }

    public Skills(Long idSkill, String nombreSkill, String imagenSkill, int porcentajeSkill) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.imagenSkill = imagenSkill;
        this.porcentajeSkill = porcentajeSkill;
    }

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getImagenSkill() {
        return imagenSkill;
    }

    public void setImagenSkill(String imagenSkill) {
        this.imagenSkill = imagenSkill;    }

   

    public int getPorcentajeSkill() {
        return porcentajeSkill;
    }

    public void setPorcentajeSkill(int porcentajeSkill) {
        this.porcentajeSkill = porcentajeSkill;
    }
}
