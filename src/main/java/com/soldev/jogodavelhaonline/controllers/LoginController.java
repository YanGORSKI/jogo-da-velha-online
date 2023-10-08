package com.soldev.jogodavelhaonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "index.html";
    }

    @PostMapping("/login")
    public String loginSubmit() {
        // Adicione aqui a lógica de autenticação do usuário
        return "redirect:/dashboard"; // Redireciona para a página de dashboard após o login bem-sucedido
    }
}