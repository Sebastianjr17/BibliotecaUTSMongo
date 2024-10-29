package com.example.biblioteca.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.biblioteca.app.entity.User;

public interface userCrud extends MongoRepository<User, String> { // Cambia Long a String
    // Aquí puedes agregar métodos personalizados si es necesario
}
