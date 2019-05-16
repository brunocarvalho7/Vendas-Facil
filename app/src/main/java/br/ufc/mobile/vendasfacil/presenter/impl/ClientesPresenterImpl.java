package br.ufc.mobile.vendasfacil.presenter.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.ClienteDao;
import br.ufc.mobile.vendasfacil.dao.impl.ClienteDaoImpl;
import br.ufc.mobile.vendasfacil.model.Cliente;
import br.ufc.mobile.vendasfacil.presenter.ClientesPresenter;

public class ClientesPresenterImpl implements ClientesPresenter {

    private ClienteDao dao;

    public ClientesPresenterImpl(){
        dao = new ClienteDaoImpl();
    }

    @Override
    public List<Cliente> getClientes() {
        return dao.getAll();
    }

}
