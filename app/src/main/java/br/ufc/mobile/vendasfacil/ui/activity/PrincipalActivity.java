package br.ufc.mobile.vendasfacil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import br.ufc.mobile.vendasfacil.R;
import br.ufc.mobile.vendasfacil.task.Reports;
import br.ufc.mobile.vendasfacil.task.VendasDiarias;
import br.ufc.mobile.vendasfacil.task.VendasMensal;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationPrincipal;
    private TextView txtValorDia, txtQtdDia, txtMes, txtValorMes, txtQtdMes;
    private VendasDiarias vendasDiarias;
    private VendasMensal vendasMensal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        if(getIntent().getExtras() != null &&
                getIntent().getExtras().get("inicial") != null){
            Log.i("Relatório", "teste");
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }


        setUpToolbar();
        setUpDrawerMenu();
        setUpTextsViews();

        doReports();
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

    private void setUpTextsViews() {
        txtValorDia = findViewById(R.id.activity_principal_dia_valor);
        txtQtdDia   = findViewById(R.id.activity_principal_dia_qtd);
        txtMes      = findViewById(R.id.activity_principal_mes_descricao);
        txtValorMes = findViewById(R.id.activity_principal_mes_valor);
        txtQtdMes   = findViewById(R.id.activity_principal_mes_qtd);
    }

    private void setUpReports() {
        vendasDiarias = new VendasDiarias(this);
        vendasDiarias.setVendaCalculoListener(new Reports.VendaCalculoListener() {
            @Override
            public void onPostCalculo(Reports report) {
                txtQtdDia.setText(report.getQtdText());
                txtValorDia.setText(report.getTotalText());
            }
        });

        vendasMensal = new VendasMensal(this);
        vendasMensal.setVendaCalculoListener(new Reports.VendaCalculoListener() {
            @Override
            public void onPostCalculo(Reports report) {
                txtQtdMes.setText(report.getQtdText());
                txtValorMes.setText(report.getTotalText());
                txtMes.setText(report.getLabel());
            }
        });
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

    public void doReports(){
        setUpReports();
        vendasDiarias.execute();
        vendasMensal.execute();
    }
}
