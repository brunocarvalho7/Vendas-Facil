package br.ufc.mobile.vendasfacil.presenter.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.ProdutoDao;
import br.ufc.mobile.vendasfacil.dao.impl.ProdutoDaoImpl;
import br.ufc.mobile.vendasfacil.model.Produto;
import br.ufc.mobile.vendasfacil.presenter.ProdutosPresenter;

public class ProdutosPresenterImpl implements ProdutosPresenter {

    private ProdutoDao dao;

    public ProdutosPresenterImpl(){
        dao = new ProdutoDaoImpl();
    }

    @Override
    public List<Produto> getProdutos() {
        return dao.getAll();
    }

}
