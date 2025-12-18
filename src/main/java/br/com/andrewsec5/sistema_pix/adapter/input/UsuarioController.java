package br.com.andrewsec5.sistema_pix.adapter.input;

import br.com.andrewsec5.sistema_pix.adapter.input.mapper.UsuarioMapper;
import br.com.andrewsec5.sistema_pix.adapter.output.UsuarioWithIdResponse;
import br.com.andrewsec5.sistema_pix.core.domain.Usuario;
import br.com.andrewsec5.sistema_pix.port.input.UsuarioServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServicePort usuarioService;
    private final UsuarioMapper mapper;

    public UsuarioController(UsuarioServicePort usuarioService, UsuarioMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @PostMapping
    public UsuarioWithIdResponse cadastrarUsuario(@RequestBody UsuarioDTO request){
        Usuario usuario = new Usuario(request.nome(), request.cpf(), request.dataNascimento());
        return mapper.toResponse(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public UsuarioWithIdResponse consultarUsuarioPorId(@PathVariable String id){
        return mapper.toResponse(usuarioService.consultarUsuarioPorId(id));
    }

    @GetMapping
    public List<UsuarioWithIdResponse> listarTodosUsuarios(){
        return mapper.toResponse(usuarioService.listarTodosUsuarios());
    }

    @PatchMapping("/{id}")
    public UsuarioWithIdResponse alterarNome(@RequestBody NomeDTO nome, @PathVariable String id){
        return mapper.toResponse(usuarioService.alterarNome(nome.nome(), id));
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id){
        usuarioService.deletarUsuario(id);
    }

}
