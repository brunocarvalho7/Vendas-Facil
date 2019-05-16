package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.repository.ProdutoRepository;
import br.ufc.mobile.vendasfacil.dao.ProdutoDao;
import br.ufc.mobile.vendasfacil.model.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

    @Override
    public boolean save(Produto obj) {
        return ProdutoRepository.getInstance().save(obj);
    }

    @Override
    public Produto remove(Integer id) {
        return ProdutoRepository.getInstance().remove(id);
    }

    @Override
    public List<Produto> getAll() {
        return ProdutoRepository.getInstance().getAll();
    }

    @Override
    public Produto getById(Integer id) {
        return ProdutoRepository.getInstance().getById(id);
    }

    @Override
    public boolean update(Produto obj) {
        return ProdutoRepository.getInstance().update(obj);
    }
}
