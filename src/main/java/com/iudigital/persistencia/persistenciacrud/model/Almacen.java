package com.iudigital.persistencia.persistenciacrud.model;

import javax.persistence.*;

@Entity
@Table(name="almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String direccion;
    private String gerente;


    //Contructores
    public Almacen() {
    }

    public Almacen(Long id, String nombre, String direccion, String gerente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.gerente = gerente;
    }

    public Almacen(String nombre, String direccion, String gerente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.gerente = gerente;
    }

    //get and set


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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    //

    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", gerente='" + gerente + '\'' +
                '}';
    }
}
