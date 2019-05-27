package br.ufc.mobile.vendasfacil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.ufc.mobile.vendasfacil.R;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        setUpToolbar();
        setUpDrawerMenu();
    }

    @Override
    protected void onResume() {
        if(navigationPrincipal.getCheckedItem() != null)
            navigationPrincipal.getCheckedItem().setChecked(false);

        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_drawer_cliente) {
            openClienteActivity();
        }else if (id == R.id.menu_drawer_fornecedor) {
            openFornecedorActivity();
        }else if (id == R.id.menu_drawer_produto) {
            openProdutosActivity();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUpDrawerMenu() {
        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationPrincipal = findViewById(R.id.menu_lateral);
        navigationPrincipal.setNavigationItemSelectedListener(this);
    }

    private void setUpToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void openProdutosActivity() {
        startActivity(new Intent(this, ProdutosActivity.class));
    }

    private void openClienteActivity() {
        startActivity(new Intent(this, ClientesActivity.class));
    }

    private void openFornecedorActivity() {
        startActivity(new Intent(this, FornecedoresActivity.class));
    }

    public void openVendasActivity(View view){
        startActivity(new Intent(this, VendasActivity.class));
    }
}
