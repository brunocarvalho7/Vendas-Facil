package br.ufc.mobile.vendasfacil.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufc.mobile.vendasfacil.model.Produto;
import br.ufc.mobile.vendasfacil.model.enums.Unidade;

public class ProdutoRepository  {

    public static int GEN_ID = 0;

    private Map<Integer, Produto> produtos;
    private static ProdutoRepository instance;

    private ProdutoRepository(){
        produtos = new TreeMap<>();
        mock();
    }

    public static ProdutoRepository getInstance(){
        if(instance == null)
            instance = new ProdutoRepository();

        return instance;
    }

    public boolean save(Produto obj) {
        obj.setId(GEN_ID++);
        return produtos.put(obj.getId(), obj) != null ? true : false;
    }

    public Produto remove(Integer id) {
        return produtos.remove(id);
    }

    public List<Produto> getAll() {
        return new ArrayList<>(produtos.values());
    }

    public Produto getById(Integer id) {
        for(int i=0; i<produtos.size(); i++){
            if(produtos.get(i).getId().equals(id))
                return produtos.get(i);
        }
        return null;
    }

    public boolean update(Produto obj) {
        return produtos.put(obj.getId(), obj) != null ? true : false;
    }

    private void mock(){
        save(new Produto(1,"Carne Moída", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
        save(new Produto(1,"Picanha", Unidade.KG, "12345", null, 2.0, 15.50,350.0));
        save(new Produto(1,"Arroz Tio João", Unidade.UND, "12345", null, 2.0, 2.50,50.0));
        save(new Produto(1,"Carne Moída Nvl.1", Unidade.KG, "12345", null, 2.0, 5.50,0.0));
        save(new Produto(1,"Carne Moída Nvl.2", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
        save(new Produto(1,"Feijão Branco", Unidade.UND, "12345", null, 2.0, 5.50,0.0));
        save(new Produto(1,"Carne Moída", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
        save(new Produto(1,"Carne Moída", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
        save(new Produto(1,"Carne Moída", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
        save(new Produto(1,"Carne Moída", Unidade.KG, "12345", null, 2.0, 5.50,50.0));
    }
}
