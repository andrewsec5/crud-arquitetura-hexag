package br.com.andrewsec5.sistema_pix.config;

import br.com.andrewsec5.sistema_pix.adapter.output.mapper.UsuarioMapper;
import br.com.andrewsec5.sistema_pix.adapter.output.persistence.UsuarioJpaRepository;
import br.com.andrewsec5.sistema_pix.adapter.output.persistence.UsuarioRepositoryImpl;
import br.com.andrewsec5.sistema_pix.core.useCase.UsuarioService;
import br.com.andrewsec5.sistema_pix.port.input.UsuarioServicePort;
import br.com.andrewsec5.sistema_pix.port.output.UsuarioRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UsuarioServicePort usuarioServicePort(UsuarioRepositoryPort usuarioRepositoryPort){
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public UsuarioRepositoryPort usuarioRepositoryPort(UsuarioJpaRepository usuarioJpaRepository, UsuarioMapper usuarioMapper){
        return new UsuarioRepositoryImpl(usuarioJpaRepository, usuarioMapper);
    }

    @Bean
    public UsuarioMapper usuarioMapper(){
        return new UsuarioMapper();
    }

}
