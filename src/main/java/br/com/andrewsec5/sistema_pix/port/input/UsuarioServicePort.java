package br.com.andrewsec5.sistema_pix.port.input;

import br.com.andrewsec5.sistema_pix.core.domain.Usuario;

import java.util.List;

public interface UsuarioServicePort {
    Usuario cadastrarUsuario(Usuario usuario);
    Usuario consultarUsuarioPorId(String id);
    List<Usuario> listarTodosUsuarios();
    Usuario alterarNome(String nome, String id);
    void deletarUsuario(String id);
}
