package com.microservicios.demo.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservicios.demo.model.Persona;

@Controller
public class PersonaController {

    @GetMapping("/personas")
    public String listarPersonas(Model model) {
        List<Persona> personas = Arrays.asList(
            new Persona("Daniel Rodriguez", "daniel@gmail.com", "Administrador", "Activo"),
            new Persona("Stephanie Alfaro", "ste@uc.cr", "Estudiante", "Inactivo"),
            new Persona("Camila Quesada", "cami@hotmail.com", "Profesor", "Activo")
        );

        model.addAttribute("personas", personas);
        return "personas"; 
    }
}