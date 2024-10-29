package com.example.biblioteca.app.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef; // Para referencias a otros documentos

@Document(collection = "administradores") // Cambia a MongoDB
public class Admin {
    
    @Id
    private String id; // Cambia Long a String para usar el ID de MongoDB
    private String nombre;
    private String email;

    @DBRef // Usa DBRef si deseas mantener la relación con otras colecciones
    private List<Solicitud> solicitudes; // Asegúrate de que 'Solicitud' también sea una entidad de MongoDB

    public Admin() {
        super();
    }

    public Admin(String id, String nombre, String email) { // Cambia Long a String en el constructor
        super();
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { // Cambia Long a String en el getter
        return id;
    }

    public void setId(String id) { // Cambia Long a String en el setter
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

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
