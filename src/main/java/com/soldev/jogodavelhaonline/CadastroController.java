package com.soldev.jogodavelhaonline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastroUsuario.html";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario() {
        // Adicione aqui a lógica para criar um novo usuário no banco de dados
        return "redirect:/login"; // Redireciona de volta para a página de login após o cadastro bem-sucedido
    }
}