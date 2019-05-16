package br.ufc.mobile.vendasfacil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import br.ufc.mobile.vendasfacil.R;
import br.ufc.mobile.vendasfacil.presenter.FornecedoresPresenter;
import br.ufc.mobile.vendasfacil.presenter.impl.FornecedoresPresenterImpl;
import br.ufc.mobile.vendasfacil.ui.adapter.RecyclerFornecedoresAdapter;

public class FornecedoresActivity extends AppCompatActivity{

    private RecyclerView recyclerFornecedores;
    private FornecedoresPresenter presenter = new FornecedoresPresenterImpl();
    private RecyclerFornecedoresAdapter adapterFornecedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedores);
        setUpToolbar();
        setUpListFornecedores();
    }

    @Override
    protected void onResume() {
        setUpListFornecedoresAdapter();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pesquisa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            setUpSearchView(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpSearchView(MenuItem item) {
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterFornecedores.getFilter().filter(s);
                return true;
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpListFornecedores() {
        recyclerFornecedores = findViewById(R.id.activity_fornecedores_recycler_fornecedores);
        recyclerFornecedores.setLayoutManager(new LinearLayoutManager(this));

        setUpListFornecedoresAdapter();
    }

    private void setUpListFornecedoresAdapter() {
        adapterFornecedores = new RecyclerFornecedoresAdapter(presenter.getFornecedores());
        recyclerFornecedores.setAdapter(adapterFornecedores);
    }

    public void openFornecedorDetails(View view) {
        Intent it = new Intent(this, FornecedoresDetailsActivity.class);
        startActivityForResult(it, 0);
    }

}
