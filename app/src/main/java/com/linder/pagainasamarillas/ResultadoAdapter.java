package com.linder.pagainasamarillas;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linderhassinger on 9/20/17.
 */

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ViewHolder> implements Filterable{

    private List<DatosResultado> datosResultados, filterList;
    private Context mContext;
    // private CustomFilter mFilter;



    public ResultadoAdapter(Context context,List<DatosResultado> datosResultados) {
        this.datosResultados = datosResultados;
        this.mContext = context;
        this.filterList = new ArrayList<DatosResultado>();
        this.filterList.addAll(this.datosResultados);
        //mFilter = new CustomFilter(ResultadoAdapter.this);

    }



    @Override
    public ResultadoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultadoAdapter.ViewHolder holder, int position) {

        //Filter
        DatosResultado datosResultado = filterList.get(position);
        final String name = datosResultados.get(position).getNameEmpresa();
        final String direccion = datosResultados.get(position).getDireccion();
        final String lugar = datosResultados.get(position).getLugar();
        final String numero = datosResultados.get(position).getNumero();
        final int imagen = datosResultados.get(position).getImagen();


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

                //Mandamos los datos al otro lado
                intent.putExtra("nombre",name);
                intent.putExtra("direccion",direccion);
                intent.putExtra("lugar",lugar);
                intent.putExtra("numero",numero);
                intent.putExtra("imagen",imagen);
                view.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return (null != filterList ? filterList.size() : 0);
        //return datosResultados.size();
    }

    @Override
    public Filter getFilter() {
        return null;
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


    public class CustomFilter extends Filter {
        private ResultadoAdapter mAdapter;
        private CustomFilter(ResultadoAdapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            datosResultados.clear();
            final FilterResults results = new FilterResults();
            if (constraint.length() == 0) {
                datosResultados.addAll(datosResultados);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();
                for (final DatosResultado mWords : datosResultados) {
                    if (mWords.getNameEmpresa().toLowerCase().startsWith(filterPattern)) {
                        datosResultados.add(mWords);
                    }
                }
            }
            results.values = datosResultados;
            results.count = datosResultados.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.mAdapter.notifyDataSetChanged();
        }


    }

    public void filter(final String text) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                filterList.clear();

                if (TextUtils.isEmpty(text)) {

                    filterList.addAll(datosResultados);

                } else {
                    for (DatosResultado item : datosResultados) {
                        if (item.getNameEmpresa().toLowerCase().contains(text.toLowerCase()) ||
                                item.getDireccion().toLowerCase().contains(text.toLowerCase())) {
                            filterList.add(item);
                        }
                    }
                }

                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();

    }


    }
