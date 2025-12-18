package br.com.andrewsec5.sistema_pix.adapter.input.mapper;

import br.com.andrewsec5.sistema_pix.adapter.output.UsuarioWithIdResponse;
import br.com.andrewsec5.sistema_pix.core.domain.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public UsuarioWithIdResponse toResponse(Usuario domain){
        return new UsuarioWithIdResponse(domain.getId(), domain.getNome(), domain.getCpf(), domain.getDataNascimento());
    }

    public List<UsuarioWithIdResponse> toResponse(List<Usuario> domains){
        return domains.stream()
                .map(this::toResponse)
                .toList();
    }

}
