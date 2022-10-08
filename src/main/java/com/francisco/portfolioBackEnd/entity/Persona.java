package com.francisco.portfolioBackEnd.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "Nombre")
    private String nombre;    
    @NotNull
    @Column(name = "Apellido")
    private String apellido;
    @NotNull
    @Column(name = "Titulo")    
    private String titulo;
    @NotNull
    @Column(name = "Descripcion", length = 1000)    
    private String descripcion;
    @NotNull
    @Column(name = "Foto_Perfil")
    private String fotoperfil;
    @NotNull
    @Column(name = "Foto_Banner")
    private String fotobanner;
    @NotNull
    @Column(name = "Ciudad")
    private String ciudad;
    @NotNull
    @Column(name = "Provincia")
    private String provincia;
   
       
    
    /*
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;*/
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Educacion>educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Skills>skillsList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia>experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPro")
    private List<Proyecto>proyectoList;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String descripcion, String fotoperfil, String fotobanner, String ciudad, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fotoperfil = fotoperfil;
        this.fotobanner = fotobanner;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }  

    public String getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    public String getFotobanner() {
        return fotobanner;
    }

    public void setFotobanner(String fotobanner) {
        this.fotobanner = fotobanner;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
