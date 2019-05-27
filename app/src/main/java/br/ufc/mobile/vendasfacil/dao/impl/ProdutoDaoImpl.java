package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.repository.ProdutoRepository;
import br.ufc.mobile.vendasfacil.dao.ProdutoDao;
import br.ufc.mobile.vendasfacil.model.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

    @Override
    public void save(Produto obj) {
        ProdutoRepository.getInstance().save(obj);
    }

    @Override
    public boolean remove(Produto obj) {
        return true;
    }

    @Override
    public List<Produto> getAll() {
        return ProdutoRepository.getInstance().getAll();
    }

    @Override
    public boolean update(Produto obj) {
        return ProdutoRepository.getInstance().update(obj);
    }

    @Override
    public String getNewId() {
        return null;
    }

    @Override
    public Produto getByBarCode(String barCode) {
        return ProdutoRepository.getInstance().getByBarCode(barCode);
    }
}
