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
    public boolean save(Fornecedor obj) {
        return FornecedorRepository.getInstance().save(obj);
    }

    @Override
    public Fornecedor remove(Integer id) {
        return FornecedorRepository.getInstance().remove(id);
    }

    @Override
    public List<Fornecedor> getAll() {
        return FornecedorRepository.getInstance().getAll();
    }

    @Override
    public Fornecedor getById(Integer id) {
        return FornecedorRepository.getInstance().getById(id);
    }

    @Override
    public boolean update(Fornecedor obj) {
        return FornecedorRepository.getInstance().update(obj);
    }
}
