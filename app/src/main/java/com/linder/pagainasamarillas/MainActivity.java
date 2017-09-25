package com.linder.pagainasamarillas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.filter;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private EditText buscador;
    private SearchView searchView;
    //final Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buscador = (EditText) findViewById(R.id.buscador);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerResult);


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ResultadoAdapter(getData());
        recyclerView.setAdapter(mAdapter);

    }
    public List<DatosResultado> getData() {

        List<DatosResultado> userModels = new ArrayList<>();
        userModels.add(new DatosResultado("Pizza Hut","mi casa","surco","989772179",R.drawable.logopizza));
        userModels.add(new DatosResultado("Bembos","mi casa2","surco","989772179", R.drawable.bembos));
        userModels.add(new DatosResultado("KFC","mi casa3","surco","989772179", R.drawable.kfc));
        userModels.add(new DatosResultado("Mediterraneo","mi casa4","surco","989772179", R.drawable.mediterraneo));
        userModels.add(new DatosResultado("Pardos","mi casa5","surco","989772179", R.drawable.pardos));

        return userModels;
    }

    /*public void setupSearch(){
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Buscar");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }*/
}