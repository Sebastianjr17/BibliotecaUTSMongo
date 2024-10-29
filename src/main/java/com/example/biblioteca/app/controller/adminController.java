package com.example.biblioteca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.app.entity.Admin;
import com.example.biblioteca.app.repository.adminCrud;

@Controller
public class adminController {
    
    @Autowired
    private adminCrud adminRepository;
    
    @GetMapping("/mostrarAdmin")  
    public String mostrarAdmin(Model model) {
        List<Admin> listaAdmin = adminRepository.findAll();
        model.addAttribute("listaAdmin", listaAdmin);
        return "mostrarAdmin";
    }
    
    @GetMapping("/mostrarAdmin/formAdmin")
    public String mostrarFormulario(Model model) {
        model.addAttribute("admin", new Admin());
        return "formAdmin";
    }
    
    @PostMapping("/guardarAdmin")
    public String guardarAdmin(@ModelAttribute Admin admin) { // Asegúrate de usar @ModelAttribute
        adminRepository.save(admin);
        return "redirect:/mostrarAdmin";
    }
    
    @GetMapping("/admin/editar/{id}")
    public String modificarAdmin(@PathVariable("id") String id, Model model) { // Cambia Long a String
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "formAdmin";
        } else {
            return "redirect:/mostrarAdmin";
        }
    }
    
    @GetMapping("/admin/eliminar/{id}")
    public String eliminarAdmin(@PathVariable("id") String id) { // Cambia Long a String
        adminRepository.deleteById(id);
        return "redirect:/mostrarAdmin";
    }
}
