package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.model.Cliente;
import br.ufc.mobile.vendasfacil.repository.ClienteRepository;
import br.ufc.mobile.vendasfacil.repository.ProdutoRepository;
import br.ufc.mobile.vendasfacil.dao.ClienteDao;
import br.ufc.mobile.vendasfacil.model.Produto;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public boolean save(Cliente obj) {
        return ClienteRepository.getInstance().save(obj);
    }

    @Override
    public Cliente remove(Integer id) {
        return ClienteRepository.getInstance().remove(id);
    }

    @Override
    public List<Cliente> getAll() {
        return ClienteRepository.getInstance().getAll();
    }

    @Override
    public Cliente getById(Integer id) {
        return ClienteRepository.getInstance().getById(id);
    }

    @Override
    public boolean update(Cliente obj) {
        return ClienteRepository.getInstance().update(obj);
    }

    @Override
    public Cliente getClientePadrao() {
        return ClienteRepository.getInstance().getById(0);
    }
}
