package com.example.biblioteca.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.app.entity.User;
import com.example.biblioteca.app.repository.userCrud;

@Controller
public class userController {

	@Autowired
	private userCrud userRepository;

	// Mostrar la lista de usuarios
	@GetMapping("/mostrarUsuarios")
	public String mostrarUsuarios(Model model) {
		List<User> listarUsuarios = userRepository.findAll();
		model.addAttribute("listarUsuarios", listarUsuarios);
		return "mostrarUsers"; // Vista para mostrar usuarios
	}

	// Mostrar formulario para crear un nuevo usuario
	@GetMapping("/mostrarUsers/formUsers")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new User()); // Nuevo usuario
		return "formUsers"; // Vista del formulario
	}

	// Guardar o actualizar usuario
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute User usuario) {
		// Si el ID no es nulo, significa que estamos actualizando un usuario existente
		if (usuario.getId() != null) {
			// Aquí podrías hacer una verificación adicional si es necesario
			System.out.println("Actualizando usuario: " + usuario);
		} else {
			System.out.println("Creando nuevo usuario: " + usuario);
		}

		userRepository.save(usuario); // Guarda o actualiza el usuario en la base de datos
		return "redirect:/mostrarUsuarios"; // Redirigir a la lista de usuarios
	}

	// Mostrar formulario para editar usuario
	@GetMapping("/user/editar/{id}")
	public String modificarUser(@PathVariable("id") String id, Model model) {
	    User user = userRepository.findById(id).orElse(null); // Buscar usuario por ID
	    if (user != null) {
	        model.addAttribute("usuario", user); // Agregar usuario al modelo
	        return "formUsers"; // Vista del formulario
	    } else {
	        return "redirect:/mostrarUsuarios"; // Redirigir si no se encuentra
	    }
	}


	// Eliminar usuario
	@GetMapping("/usuario/eliminar/{id}")
	public String eliminarUser(@PathVariable("id") String id) {
		userRepository.deleteById(id); // Eliminar usuario por ID
		return "redirect:/mostrarUsuarios"; // Redirigir a la lista de usuarios
	}
}
