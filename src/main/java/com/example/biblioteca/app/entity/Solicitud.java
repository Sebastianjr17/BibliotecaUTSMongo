package com.example.biblioteca.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "solicitudes") // Cambia a MongoDB
public class Solicitud {
    @Id
    private String id; // Cambia Long a String para usar el ID de MongoDB

    private String nombreUsuario;

    @DBRef // Cambia @ManyToOne y @JoinColumn a @DBRef
    private Libro libroSolicitado;

    @DBRef // Cambia @ManyToOne y @JoinColumn a @DBRef
    private Admin administrador;

    private String estado; // "APROBADA", "RECHAZADA", "PENDIENTE"

    public Solicitud() {
        super();
        this.estado = "PENDIENTE";
    }

    public Solicitud(String id, String nombreUsuario, Libro libroSolicitado, Admin administrador, String estado) { // Cambia Long a String en el constructor
        super();
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.libroSolicitado = libroSolicitado;
        this.administrador = administrador;
        this.estado = estado;
    }

    public String getId() { // Cambia Long a String en el getter
        return id;
    }

    public void setId(String id) { // Cambia Long a String en el setter
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Libro getLibroSolicitado() {
        return libroSolicitado;
    }

    public void setLibroSolicitado(Libro libroSolicitado) {
        this.libroSolicitado = libroSolicitado;
    }

    public Admin getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Admin administrador) {
        this.administrador = administrador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
