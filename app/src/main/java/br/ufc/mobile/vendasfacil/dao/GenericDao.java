package br.ufc.mobile.vendasfacil.dao;

import java.util.List;

public interface GenericDao<T> {

    boolean save(T obj);
    T remove(Integer id);
    List<T> getAll();
    T getById(Integer id);
    boolean update(T obj);

}
