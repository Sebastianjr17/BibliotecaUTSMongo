package com.example.biblioteca.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.biblioteca.app.entity.Libro;

public interface libroCrud extends MongoRepository<Libro, String> { // Cambia Long a String
    // Aquí puedes agregar métodos personalizados si es necesario
}
