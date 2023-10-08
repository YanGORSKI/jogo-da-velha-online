package com.soldev.jogodavelhaonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soldev.jogodavelhaonline.models.Usuario;
import com.soldev.jogodavelhaonline.services.UsuarioService;

@Controller
public class CadastroController {

    private final UsuarioService usuarioService;

    @Autowired
    public CadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastroUsuario.html";
    }

    @PostMapping("/gravar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.salvarUsuario(usuario);
            redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso.");
            return "redirect:/login";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", e.getMessage());
            return "redirect:/cadastro";
        }
    }
}