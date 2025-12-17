package br.com.andrewsec5.sistema_pix.core.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario {

    private String id;
    private String nome;
    private final LocalDate dataNascimento;
    private final String cpf;
    private boolean ativo;

    private final byte tamanhoNome = 20;

    public Usuario(String nome, LocalDate dataNascimento, String cpf, boolean ativo){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = true;
    }

    public Usuario(String id, String nome, LocalDate dataNascimento, String cpf, boolean ativo){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public Usuario(String nome, String cpf, LocalDate dataNascimento){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

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
