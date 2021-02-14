package com.gabrielazbarreto.easylist;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout flContainerForFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flContainerForFragment = (FrameLayout) findViewById(R.id.flContainerForFragment);
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        SemListaTextoFragment semLista = new SemListaTextoFragment();
        managerFragment(semLista, "SEM_LISTA");

    }

    //método que trata a troca de página dos botões de navegação
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_listas:
                    //SemListaTextoFragment semLista = new SemListaTextoFragment();
                    NewProductFragment novoProduto = new NewProductFragment();
                    managerFragment(novoProduto, "SEM_LISTA");
                    return true;
                case R.id.navigation_compras:
                    SemComprasTextoFragment semCompras = new SemComprasTextoFragment();
                    managerFragment(semCompras, "SEM_COMPRAS");
                    return true;
                case R.id.navigation_graficos:
                    SemGraficoTextoFragment semGrafico = new SemGraficoTextoFragment();
                    managerFragment(semGrafico, "SEM_GRAFICO");
                    return true;
            }
            return false;
        }

    };

    //métodos responsável por mudar os fragmentes exibidos
    private void managerFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainerForFragment, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //TODO: tratamento do botão de voltar: alterar a string para definir qual é o ultimo fragmento
    @Override
    public void onBackPressed() {
        String fragmentoFinal = "SEM_LISTA";
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentoFinal);
        if(fragment != null) {
            if (fragment.isVisible()) {
                finish();
                return;
            }
        }
        super.onBackPressed();
    }
}