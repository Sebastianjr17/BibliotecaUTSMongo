package com.example.biblioteca.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros") // Cambia a MongoDB
public class Libro {
    @Id
    private String id; // Cambia Long a String para usar el ID de MongoDB
    private String titulo;
    private String autor;

    public Libro() {
        super();
    }

    public Libro(String id, String titulo, String autor) { // Cambia Long a String en el constructor
        super();
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getId() { // Cambia Long a String en el getter
        return id;
    }

    public void setId(String id) { // Cambia Long a String en el setter
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
