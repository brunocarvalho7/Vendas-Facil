package br.ufc.mobile.vendasfacil.presenter.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.FornecedorDao;
import br.ufc.mobile.vendasfacil.dao.impl.FornecedorDaoImpl;
import br.ufc.mobile.vendasfacil.model.Fornecedor;
import br.ufc.mobile.vendasfacil.presenter.FornecedoresPresenter;

public class FornecedoresPresenterImpl implements FornecedoresPresenter {

    private FornecedorDao dao;

    public FornecedoresPresenterImpl(){
        dao = new FornecedorDaoImpl();
    }

    @Override
    public List<Fornecedor> getFornecedores() {
        return dao.getAll();
    }

}
