package com.example.biblioteca.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class User {
    @Id
    private String id; // ID del usuario, MongoDB lo generará automáticamente si es nulo

    private String nombre;
    private String email;

    // Constructor por defecto
    public User() {
        super();
    }

    // Constructor que permite establecer un ID (usa solo si es necesario)
    public User(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
