package br.ufc.mobile.vendasfacil.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mobile.vendasfacil.dao.GenericDao;
import br.ufc.mobile.vendasfacil.model.Categoria;

public class CategoriaRepository implements GenericDao<Categoria> {

    public List<Categoria> categoriaList;
    public static CategoriaRepository instance;

    private CategoriaRepository() {
        categoriaList = new ArrayList<>();
        mock();
    }

    public static CategoriaRepository getInstance(){
        if(instance == null)
            instance = new CategoriaRepository();
        
        return instance;
    }

    @Override
    public boolean save(Categoria obj) {
        return categoriaList.add(obj);
    }

    @Override
    public Categoria remove(Integer id) {
        for(int i=0; i<categoriaList.size(); i++){
            if(categoriaList.get(i).getId().equals(id))
                return categoriaList.remove(i);
        }
        return null;
    }

    @Override
    public List<Categoria> getAll() {
        return categoriaList;
    }

    @Override
    public Categoria getById(Integer id) {
        for(int i=0; i<categoriaList.size(); i++){
            if(categoriaList.get(i).getId().equals(id))
                return categoriaList.get(i);
        }
        return null;
    }

    @Override
    public boolean update(Categoria obj) {
        for(int i=0; i<categoriaList.size(); i++){
            if(categoriaList.get(i).getId().equals(obj.getId())) {
                categoriaList.add(i, obj);
                return true;
            }
        }
        return false;
    }

    private void mock() {
        save(new Categoria(1,"Frios"));
        save(new Categoria(2,"Carnes"));
        save(new Categoria(3,"Biscoito"));
        save(new Categoria(4,"Ovos"));
        save(new Categoria(5,"Arroz"));
        save(new Categoria(6,"Feijão"));
    }
}
