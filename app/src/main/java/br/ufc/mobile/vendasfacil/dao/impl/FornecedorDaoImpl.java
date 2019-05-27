package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.FornecedorDao;
import br.ufc.mobile.vendasfacil.model.Fornecedor;
import br.ufc.mobile.vendasfacil.repository.FornecedorRepository;
import br.ufc.mobile.vendasfacil.repository.ProdutoRepository;
import br.ufc.mobile.vendasfacil.dao.ProdutoDao;
import br.ufc.mobile.vendasfacil.model.Produto;

public class FornecedorDaoImpl implements FornecedorDao {

    @Override
    public void save(Fornecedor obj) {
        FornecedorRepository.getInstance().save(obj);
    }

    @Override
    public boolean remove(Fornecedor obj) {
        return true;
    }

    @Override
    public List<Fornecedor> getAll() {
        return FornecedorRepository.getInstance().getAll();
    }

    @Override
    public boolean update(Fornecedor obj) {
        return FornecedorRepository.getInstance().update(obj);
    }

    @Override
    public String getNewId() {
        return null;
    }
}
