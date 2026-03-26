package edu.ifsp.segurancainfo.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/administradores")
    public String adminPage() {
        return "admin_page";
    }
}
