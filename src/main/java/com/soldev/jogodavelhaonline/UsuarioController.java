package com.soldev.jogodavelhaonline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @GetMapping("/login")
    public String loginPage() {
        // Lógica para login
        return "index.html";
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastro.html"; // Esta é a página de cadastro que você criará mais tarde.
    }
}
