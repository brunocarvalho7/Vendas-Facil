package br.ufc.mobile.vendasfacil.model;

import java.io.Serializable;

public class Categoria implements Serializable {

    private Integer id;
    private String descricao;

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isValid(){
        return descricao.trim().length() > 0;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
