package com.appscloud.pruebatecnica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.appscloud.pruebatecnica.databinding.ListItemBinding;
import com.appscloud.pruebatecnica.model.Datos;

public class DatosAdapter extends ListAdapter<Datos, DatosAdapter.DatosViewHolder> {

    public static final DiffUtil.ItemCallback<Datos> DIFF_CALLBACK = new DiffUtil.ItemCallback<Datos>() {

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
    }
    private static OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(Datos datos);

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }

    @NonNull
    @Override
    public DatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new DatosViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull DatosViewHolder holder, int position) {
        Datos datos = getItem(position);
        holder.bind(datos);

    }


    static class DatosViewHolder extends RecyclerView.ViewHolder {

        private final ListItemBinding binding;


        public DatosViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void bind(Datos datos) {
            binding.tvAuditoria.setText(datos.getAuditoria());
            binding.tvFechaPlan.setText(datos.getFecha());
            binding.tvSucursal.setText(datos.getSucursal());

            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(datos);
            });

            binding.executePendingBindings(); // cuando demos scroll sirve pars que esto pinte de
            // manera inmediata


        }
    }
}
