package com.soldev.jogodavelhaonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.soldev.jogodavelhaonline.models.Usuario;
import com.soldev.jogodavelhaonline.repositories.UsuarioRepository;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "index.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Login bem-sucedido, redirecione para a página do lobby
            return "redirect:/lobby";
        } else {
            // Login falhou, adicione uma mensagem de erro ao modelo
            model.addAttribute("error", "Usuário não cadastrado ou senha incorreta");
            return "/login";
        }
    }
}