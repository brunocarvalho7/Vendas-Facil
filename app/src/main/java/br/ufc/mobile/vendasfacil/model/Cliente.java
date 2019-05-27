package br.ufc.mobile.vendasfacil.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    public static String KEY = "CLIENTE";

    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isValid(){
        return nome.trim().length() > 0;
    }

    @Override
    public String toString() {
        return nome;
    }
}
