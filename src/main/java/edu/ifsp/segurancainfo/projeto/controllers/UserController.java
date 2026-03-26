package edu.ifsp.segurancainfo.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/usuarios")
    public String userPage() {
        return "user_page";
    }
}
