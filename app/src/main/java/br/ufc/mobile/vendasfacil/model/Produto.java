package br.ufc.mobile.vendasfacil.model;

import java.io.Serializable;

import br.ufc.mobile.vendasfacil.model.enums.Unidade;

public class Produto implements Serializable {

    public static String KEY = "PRODUTO";

    private Integer id;
    private String descricao;
    private Unidade unidade;
    private String codBarras;
    private Categoria categoria;
    private Double rsCompra;
    private Double rsVenda;
    private Double estoque;

    public Produto(Integer id, String descricao, Unidade unidade, String codBarras, Categoria categoria,
                   Double rsCompra, Double rsVenda, Double estoque) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.codBarras = codBarras;
        this.categoria = categoria;
        this.rsCompra = rsCompra;
        this.rsVenda = rsVenda;
        this.estoque = estoque;
    }

    public Produto() {
        this.estoque = 0.0;
        this.rsCompra = 0.0;
        this.rsVenda = 0.0;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getRsCompra() {
        return rsCompra;
    }

    public void setRsCompra(Double rsCompra) {
        this.rsCompra = rsCompra;
    }

    public Double getRsVenda() {
        return rsVenda;
    }

    public void setRsVenda(Double rsVenda) {
        this.rsVenda = rsVenda;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public String getEstoqueText(){
        if(getEstoque() > 0) {
            if (getUnidade().equals(Unidade.UND))
                return "Em estoque: " + String.format("%.0f", getEstoque()) + " " + getUnidade();
            else if(getUnidade().equals(Unidade.KG))
                return "Em estoque: " + String.format("%.3f", getEstoque()) + " " + getUnidade();
        }
        return "Sem estoque";
    }

    public String getRsVendaText(){
        return "R$ "+String.format("%.2f", getRsVenda());
    }

    public boolean isValid(){
        return descricao.trim().length() > 0 &&
               unidade != null &&
               rsVenda > 0.0;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", unidade=" + unidade +
                ", codBarras='" + codBarras + '\'' +
                ", categoria=" + categoria +
                ", rsCompra=" + rsCompra +
                ", rsVenda=" + rsVenda +
                ", estoque=" + estoque +
                '}';
    }
}
