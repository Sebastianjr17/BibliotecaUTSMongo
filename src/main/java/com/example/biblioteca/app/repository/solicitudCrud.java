package com.example.biblioteca.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.biblioteca.app.entity.Solicitud;

public interface solicitudCrud extends MongoRepository<Solicitud, String> { // Cambia Long a String
    // Aquí puedes agregar métodos personalizados si es necesario
}
