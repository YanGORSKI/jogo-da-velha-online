package com.soldev.jogodavelhaonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soldev.jogodavelhaonline.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}