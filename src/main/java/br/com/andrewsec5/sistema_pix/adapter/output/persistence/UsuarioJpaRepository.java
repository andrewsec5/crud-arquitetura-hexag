package br.com.andrewsec5.sistema_pix.adapter.output.persistence;

import br.com.andrewsec5.sistema_pix.adapter.output.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, String> {
}
