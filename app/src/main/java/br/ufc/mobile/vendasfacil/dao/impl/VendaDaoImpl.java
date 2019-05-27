package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.VendaDao;
import br.ufc.mobile.vendasfacil.model.Venda;
import br.ufc.mobile.vendasfacil.repository.VendaRepository;

public class VendaDaoImpl implements VendaDao {

    @Override
    public boolean save(Venda obj) {
        return VendaRepository.getInstance().save(obj);
    }

    @Override
    public Venda remove(Integer id) {
        return null;
    }

    @Override
    public List<Venda> getAll() {
        return null;
    }

    @Override
    public Venda getById(Integer id) {
        return null;
    }

    @Override
    public boolean update(Venda obj) {
        return false;
    }
}
