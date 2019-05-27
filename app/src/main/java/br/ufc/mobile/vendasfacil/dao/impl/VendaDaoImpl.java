package br.ufc.mobile.vendasfacil.dao.impl;

import java.util.List;

import br.ufc.mobile.vendasfacil.dao.VendaDao;
import br.ufc.mobile.vendasfacil.model.Venda;
import br.ufc.mobile.vendasfacil.repository.VendaRepository;

public class VendaDaoImpl implements VendaDao {

    @Override
    public void save(Venda obj) {
        VendaRepository.getInstance().save(obj);
    }

    @Override
    public boolean remove(Venda venda) {
        return true;
    }

    @Override
    public List<Venda> getAll() {
        return null;
    }

    @Override
    public boolean update(Venda obj) {
        return false;
    }

    @Override
    public String getNewId() {
        return null;
    }
}
