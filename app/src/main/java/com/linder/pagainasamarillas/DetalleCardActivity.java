package com.linder.pagainasamarillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetalleCardActivity extends AppCompatActivity {
    private TextView nombreDetalle,direcciondetalle,numerodetalle,lugardetalle;
    private ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_card);

        nombreDetalle = (TextView) findViewById(R.id.nombreDetalle);
        direcciondetalle = (TextView) findViewById(R.id.direccionDetalle);
        numerodetalle = (TextView) findViewById(R.id.numeroDetalle);
        lugardetalle = (TextView) findViewById(R.id.luagrDetalle);


        fondo = (ImageView) findViewById(R.id.fondoImagen);

        String name = getIntent().getExtras().getString("nombre");
        String direcc = getIntent().getExtras().getString("direccion");
        String lugar = getIntent().getExtras().getString("lugar");
        String numero = getIntent().getExtras().getString("numero");
        int imagen = getIntent().getExtras().getInt("imagen");
        nombreDetalle.setText(name);
        direcciondetalle.setText(direcc);
        numerodetalle.setText(numero);
        lugardetalle.setText(lugar);
        fondo.setImageResource(imagen);

    }
}
