package br.com.andrewsec5.sistema_pix.adapter.output.mapper;

import br.com.andrewsec5.sistema_pix.adapter.output.UsuarioWithIdResponse;
import br.com.andrewsec5.sistema_pix.adapter.output.entity.UsuarioEntity;
import br.com.andrewsec5.sistema_pix.core.domain.Usuario;

import java.util.List;

public class EntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getCpf(), usuario.isAtivo());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getId(), entity.getNome(), entity.getDataNascimento(), entity.getCpf(), entity.isAtivo());
    }

    public List<Usuario> toDomain(List<UsuarioEntity> entities){
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

}
