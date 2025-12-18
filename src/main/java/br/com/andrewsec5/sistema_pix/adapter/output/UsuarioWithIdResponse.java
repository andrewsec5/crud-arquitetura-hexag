package br.com.andrewsec5.sistema_pix.adapter.output;

import java.time.LocalDate;

public record UsuarioWithIdResponse(
        String id,
        String nome,
        String cpf,
        LocalDate dataNascimento
) {
}
