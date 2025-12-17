package br.com.andrewsec5.sistema_pix.adapter.input;

import br.com.andrewsec5.sistema_pix.core.domain.Usuario;
import br.com.andrewsec5.sistema_pix.port.input.UsuarioServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServicePort usuarioService;

    public UsuarioController(UsuarioServicePort usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody UsuarioDTO request){
        Usuario usuario = new Usuario(request.nome(), request.cpf(), request.dataNascimento());
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario consultarUsuarioPorId(@PathVariable String id){
        return usuarioService.consultarUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> listarTodosUsuarios(){
        return usuarioService.listarTodosUsuarios();
    }

    @PatchMapping("/{id}")
    public Usuario alterarNome(@RequestBody NomeDTO nome, @PathVariable String id){
        return usuarioService.alterarNome(nome.nome(), id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id){
        usuarioService.deletarUsuario(id);
    }

}
