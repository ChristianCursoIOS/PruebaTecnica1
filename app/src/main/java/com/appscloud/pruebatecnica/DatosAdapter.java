package com.appscloud.pruebatecnica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appscloud.pruebatecnica.api.APICliente;
import com.appscloud.pruebatecnica.databinding.ListItemBinding;
import com.appscloud.pruebatecnica.model.Dato;

import java.util.List;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.DatosViewHolder> {

    /* public static final DiffUtil.ItemCallback<Datos> DIFF_CALLBACK = new DiffUtil.ItemCallback<Datos>() {

         @Override
         public boolean areItemsTheSame(@NonNull Datos oldItem, @NonNull Datos newItem) {
             //User properties may have changed if reloaded from DB, but ID is fixed

             return oldItem.getId().equals(newItem.getId());
         }

         @Override
         public boolean areContentsTheSame(@NonNull Datos oldItem, @NonNull Datos newItem) {
             //NOTE: if you use equals, your object must properly  override Object#equals()
             //Incorrectly returning false here will  result into many animations
             return oldItem.equals(newItem);
         }
     };


     protected DatosAdapter() {
         super(DIFF_CALLBACK);
     }*/
    private static OnItemClickListener onItemClickListener;
    private final List<Dato> datoList;
    private Context context;


    public DatosAdapter(List<Dato> datos) {
        this.datoList = datos;
    }


    public interface OnItemClickListener {
        void onItemClick(Dato dato);

        void onLongItemClick(Dato dato);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }

    @NonNull
    @Override
    public DatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        this.context = parent.getContext();

        return new DatosViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull DatosViewHolder holder, int position) {
        final Dato dato = datoList.get(position);
        holder.bind(dato);

    }

    @Override
    public int getItemCount() {
        return this.datoList.size();
    }


    public static class DatosViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public DatosViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Dato datos) {
            binding.tvAuditoria.setText(datos.getAuditoria());
            binding.tvFechaPlan.setText(datos.getFechaInicioPlan());
            binding.tvSucursal.setText(datos.getSucursal());

            // Forma con lambda para asignar el evento escuchador (listener)
            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(datos);
            });

            // Forma clasica para asignar el evento escuchador (listener)
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onLongItemClick(datos);
                    return true;
                }
            });
            binding.executePendingBindings(); // cuando demos scroll sirve pars que esto pinte de
            // manera inmediata


        }
    }
}
