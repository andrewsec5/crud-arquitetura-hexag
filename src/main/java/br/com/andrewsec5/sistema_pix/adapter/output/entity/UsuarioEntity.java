package br.com.andrewsec5.sistema_pix.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    private String id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private boolean ativo;

    public UsuarioEntity(String id, String nome, LocalDate dataNascimento, String cpf, boolean ativo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.id = id;
        this.ativo = ativo;
    }
    public UsuarioEntity(){}

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

}
