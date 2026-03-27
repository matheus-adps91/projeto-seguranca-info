package edu.ifsp.segurancainfo.projeto.controllers;

import edu.ifsp.segurancainfo.projeto.domain.DTO.RegisterDTO;
import edu.ifsp.segurancainfo.projeto.domain.users.User;
import edu.ifsp.segurancainfo.projeto.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthenticationController
{
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/logout")
    public String logout(Model model){
        model.addAttribute("mensagem", "Logout realizado com sucesso");
        return "login";
    }

    @GetMapping("/cadastro")
    public String register(){
        return "create_user";
    }

    @GetMapping("/index")
    public String homePage(Model model){
        model.addAttribute("mensagem", "Bem-vindo à página inicial!");
        return "index";
    }

    @GetMapping("/acesso-negado")
    public String accessDenied(){
        return "forbidden_page";
    }

    @PostMapping("/cadastro")
    public String register(@ModelAttribute RegisterDTO data, Model model){
        if(this.repository.findByLogin(data.login()).isPresent()) {
            model.addAttribute("mensagem", "Usuário já existe");
            return "create_user";
        }
        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.repository.save(newUser);
        model.addAttribute("mensagem", "Usuário criado com sucesso");
        return "admin_page";
    }
}
