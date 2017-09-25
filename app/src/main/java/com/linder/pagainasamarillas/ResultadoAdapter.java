package com.linder.pagainasamarillas;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by linderhassinger on 9/20/17.
 */

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ViewHolder>{

    private List<DatosResultado> datosResultados;

    public ResultadoAdapter(List<DatosResultado> datosResultados) {
        this.datosResultados = datosResultados;
    }

    @Override
    public ResultadoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultadoAdapter.ViewHolder holder, int position) {
        String name = datosResultados.get(position).getNameEmpresa();
        String direccion = datosResultados.get(position).getDireccion();
        String lugar = datosResultados.get(position).getLugar();
        String numero = datosResultados.get(position).getNumero();
        int imagen = datosResultados.get(position).getImagen();


        holder.name.setText(name);
        holder.direccion.setText(direccion);
        holder.lugar.setText(lugar);
        holder.numero.setText(numero);
        holder.imagen.setImageResource(imagen);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","hola");
                Intent intent = new Intent(view.getContext(),DetalleCardActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }

    public void updateList(List<DatosResultado> list){
        datosResultados = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datosResultados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,direccion,lugar,numero;
        private ImageView imagen;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameCompany);
            direccion = (TextView) itemView.findViewById(R.id.direccion);
            lugar = (TextView) itemView.findViewById(R.id.lugar);
            numero = (TextView) itemView.findViewById(R.id.numero);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            cardView = (CardView) itemView.findViewById(R.id.cardResult);



        }

    }

}
