package com.example.biblioteca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.app.entity.Libro;
import com.example.biblioteca.app.entity.Solicitud;
import com.example.biblioteca.app.repository.solicitudCrud;
import com.example.biblioteca.app.repository.libroCrud;

@Controller
public class solicitudController {

	@Autowired
	private solicitudCrud solicitudRepository;

	@Autowired
	private libroCrud libroRepository;

	@GetMapping("/mostrarSolicitudes")
	public String mostrarSolicitudes(Model model) {
		List<Solicitud> listaSolicitudes = solicitudRepository.findAll();
		model.addAttribute("listaSolicitudes", listaSolicitudes);

		List<Libro> listaLibro = libroRepository.findAll();
		model.addAttribute("listaLibro", listaLibro);

		return "mostrarSolicitud";
	}

	@GetMapping("/mostrarSolicitudUser")
	public String mostrarSolicitudUser(Model model) {
		List<Solicitud> listarSolicitudUser = solicitudRepository.findAll();
		model.addAttribute("listarSolicitudUser", listarSolicitudUser);

		List<Libro> listaLibro = libroRepository.findAll();
		model.addAttribute("listaLibro", listaLibro);

		return "userSolicitud";
	}

	@GetMapping("/mostrarSolicitudes/formSolicitud")
	public String mostrarFormulario(Model model) {
		model.addAttribute("solicitud", new Solicitud());
		model.addAttribute("libros", libroRepository.findAll());
		return "formSolicitud";
	}

	@PostMapping("/guardarSolicitud")
	public String guardarSolicitud(@ModelAttribute Solicitud solicitud) { // Usa @ModelAttribute
		solicitudRepository.save(solicitud);
		return "redirect:/mostrarSolicitudUser";
	}

	@PostMapping("/solicitud/aprobar")
	public String aprobarSolicitud(@RequestParam String id) { // Cambia Long a String
		Solicitud solicitud = solicitudRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de solicitud no válido: " + id));
		solicitud.setEstado("Aprobada");
		solicitudRepository.save(solicitud);
		return "redirect:/mostrarSolicitudes";
	}

	@PostMapping("/solicitud/denegar")
	public String denegarSolicitud(@RequestParam String id) { // Cambia Long a String
		Solicitud solicitud = solicitudRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de solicitud no válido: " + id));
		solicitud.setEstado("Rechazada");
		solicitudRepository.save(solicitud);
		return "redirect:/mostrarSolicitudes";
	}
}
