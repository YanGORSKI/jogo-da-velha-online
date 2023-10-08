package com.soldev.jogodavelhaonline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldev.jogodavelhaonline.repositories.UsuarioRepository;
import com.soldev.jogodavelhaonline.models.Usuario;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario salvarUsuario(Usuario usuario) {
        // Verifique se o nome de usuário já existe
        if (findByUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("Nome de usuário já existe.");
        }

        // Criptografe a senha antes de salvar no banco de dados
        usuario.setPassword(usuario.getPassword());

        return usuarioRepository.save(usuario);
    }
}