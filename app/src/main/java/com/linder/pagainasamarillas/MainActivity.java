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
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.filter;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<DatosResultado> allList;
    private EditText buscador;
    //private SearchView searchViewBus;
    //final Context context;

    final String company[] = {"Pizza Hut","Bembos","KFC","Mediterraneo","Pardos"};
   // ArrayList<String> empresa = new ArrayList<String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // buscador = (EditText) findViewById(R.id.buscador);
       // searchViewBus = (SearchView) findViewById(R.id.buscador);

        setList();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerResult);


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ResultadoAdapter(this,allList);
        recyclerView.setAdapter(mAdapter);

//        setupSearchView();

    }

    public void setList() {

        allList = new ArrayList<DatosResultado>();

        DatosResultado item = new DatosResultado();
        item.setDatosResultado("Pizza Hut","Av. siempre viva 123","surco","989772179",R.drawable.logopizza);
        allList.add(item);

        item = new DatosResultado();
        item.setDatosResultado("Bembos","Av. siempre viva 345","surco","989772179", R.drawable.bembos);
        allList.add(item);

        item = new DatosResultado();
        item.setDatosResultado("KFC","Av. siempre viva 655","surco","989772179", R.drawable.kfc);
        allList.add(item);

        item = new DatosResultado();
        item.setDatosResultado("Mediterraneo","Av. siempre viva 898","surco","989772179", R.drawable.mediterraneo);
        allList.add(item);

        item = new DatosResultado();
        item.setDatosResultado("Pardos","Av. siempre viva 655","surco","989772179", R.drawable.pardos);
        allList.add(item);


        /*for (int i = 0; i < 9; i++) {
            item = new DatosResultado();
            item.setDatosResultado("Pizza Hut","mi casa","surco","989772179",R.drawable.logopizza);
            allList.add(item);
        }*/

    }



    /*public List<DatosResultado> getData() {

        List<DatosResultado> userModels = new ArrayList<>();

        //empresa.add("Pizza Hut");
        userModels.add(new DatosResultado(company[0],"mi casa","surco","989772179",R.drawable.logopizza));
        userModels.add(new DatosResultado(company[1],"mi casa2","surco","989772179", R.drawable.bembos));
        userModels.add(new DatosResultado(company[2],"mi casa3","surco","989772179", R.drawable.kfc));
        userModels.add(new DatosResultado(company[3],"mi casa4","surco","989772179", R.drawable.mediterraneo));
        userModels.add(new DatosResultado(company[4],"mi casa5","surco","989772179", R.drawable.pardos));

        return userModels;
    }*/

    /*private void setupSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Buscar");
    }*/
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }


}