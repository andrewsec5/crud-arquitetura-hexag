package br.com.andrewsec5.sistema_pix.adapter.input;

import java.time.LocalDate;

public record UsuarioDTO(
        String nome,
        String cpf,
        LocalDate dataNascimento
) {
}
