package com.example.biblioteca.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.biblioteca.app.entity.Admin;

public interface adminCrud extends MongoRepository<Admin, String> { // Cambia Long a String
    // Aquí puedes agregar métodos personalizados si es necesario
}
