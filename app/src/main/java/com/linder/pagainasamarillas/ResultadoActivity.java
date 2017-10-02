package com.linder.pagainasamarillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerResult);


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // mAdapter = new ResultadoAdapter(getData());
        recyclerView.setAdapter(mAdapter);

    }
       /* public List<DatosResultado> getData() {

            List<DatosResultado> userModels = new ArrayList<>();
            userModels.add(new DatosResultado("LinderTec","mi casa","surco","989772179", R.drawable.logopizza));
            userModels.add(new DatosResultado("LinderTec","mi casa2","surco","989772179", R.drawable.logopizza));
            userModels.add(new DatosResultado("LinderTec","mi casa3","surco","989772179", R.drawable.logopizza));
            userModels.add(new DatosResultado("LinderTec","mi casa4","surco","989772179", R.drawable.logopizza));
            userModels.add(new DatosResultado("LinderTec","mi casa5","surco","989772179", R.drawable.logopizza));

            return userModels;
        }*/

    }