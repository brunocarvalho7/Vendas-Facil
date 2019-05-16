package br.ufc.mobile.vendasfacil.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufc.mobile.vendasfacil.model.Fornecedor;

public class FornecedorRepository {

    public static int GEN_ID = 0;

    private Map<Integer, Fornecedor> fornecedores;
    private static FornecedorRepository instance;

    private FornecedorRepository(){
        fornecedores = new TreeMap<>();
        mock();
    }

    public static FornecedorRepository getInstance(){
        if(instance == null)
            instance = new FornecedorRepository();

        return instance;
    }

    public boolean save(Fornecedor obj) {
        obj.setId(GEN_ID++);
        return fornecedores.put(obj.getId(), obj) != null ? true : false;
    }

    public Fornecedor remove(Integer id) {
        return fornecedores.remove(id);
    }

    public List<Fornecedor> getAll() {
        return new ArrayList<>(fornecedores.values());
    }

    public Fornecedor getById(Integer id) {
        return fornecedores.get(id);
    }

    public boolean update(Fornecedor obj) {
        return fornecedores.put(obj.getId(), obj) != null ? true : false;
    }

    private void mock(){
       save(new Fornecedor(1,"Pinheiro", "12345678", "Fernando"));
       save(new Fornecedor(1,"São Geraldo", "88877554", "Joaquim"));
       save(new Fornecedor(1,"M Dias Branco", "44569874", "José"));
    }
}
