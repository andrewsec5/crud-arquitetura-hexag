package br.com.andrewsec5.sistema_pix.adapter.output.persistence;

import br.com.andrewsec5.sistema_pix.adapter.output.entity.UsuarioEntity;
import br.com.andrewsec5.sistema_pix.adapter.output.mapper.EntityMapper;
import br.com.andrewsec5.sistema_pix.core.domain.Usuario;
import br.com.andrewsec5.sistema_pix.port.output.UsuarioRepositoryPort;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repository;
    private final EntityMapper mapper;

    public UsuarioRepositoryImpl(UsuarioJpaRepository repository, EntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> entities = repository.findAll();
        return mapper.toDomain(entities);
    }

    @Override
    public Optional<Usuario> findById(String id) {
        Usuario domain = mapper.toDomain(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado.")));
        return Optional.of(domain);
    }

}
