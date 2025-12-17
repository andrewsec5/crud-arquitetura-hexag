package br.com.andrewsec5.sistema_pix.core.useCase;

import br.com.andrewsec5.sistema_pix.core.domain.Usuario;
import br.com.andrewsec5.sistema_pix.port.input.UsuarioServicePort;
import br.com.andrewsec5.sistema_pix.port.output.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepository;

    public UsuarioService(UsuarioRepositoryPort usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario domain){
        return usuarioRepository.save(domain);
    }

    public Usuario consultarUsuarioPorId(String id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado."));
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario alterarNome(String nome, String id){
        Usuario domain = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado."));
        domain.setNome(nome);
        return usuarioRepository.save(domain);
    }

    public void deletarUsuario(String id){
        Usuario domain = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado."));
        domain.setAtivo(false);
        usuarioRepository.save(domain);
    }

}
