package br.com.andrewsec5.sistema_pix.port.output;

import br.com.andrewsec5.sistema_pix.core.domain.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Optional<Usuario> findById(String id);
}
