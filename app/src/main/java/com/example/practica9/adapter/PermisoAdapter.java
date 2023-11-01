package com.example.practica9.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica9.R;
import com.example.practica9.model.Permiso;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.PermisoViewHolder>{


    List<Permiso> Lista_permisos;

    public PermisoAdapter(List<Permiso> lista_permisos) {
        Lista_permisos = lista_permisos;
    }

    public interface PermissionRequester {
        void requestPermission(String permission);
    }

    @NonNull
    @Override
    public PermisoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View v= ly.inflate(R.layout.itempermisos, parent, false);
        return new PermisoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoViewHolder holder, int position) {
        Permiso p= Lista_permisos.get(position);
        holder.setData(p);

        holder.swPermiso.setOnCheckedChangeListener((buttonView, isChecked) -> {
            p.setEstado(isChecked);
            if (isChecked) {
                if (holder.itemView.getContext() instanceof PermissionRequester) {
                    ((PermissionRequester) holder.itemView.getContext()).requestPermission(p.getPermisos());
                }
            } else {
                p.setEstado(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Lista_permisos.size();
    }

    public class PermisoViewHolder extends RecyclerView.ViewHolder {

        TextView txtPermiso;
        TextView txtDesc;
        Switch swPermiso;
        Permiso pp;

        public PermisoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso= itemView.findViewById(R.id.txtPermiso);
            txtDesc= itemView.findViewById(R.id.txtDesc);
            swPermiso= itemView.findViewById(R.id.switch1);
        }

        public void setData(Permiso p) {
            pp = p;
            txtPermiso.setText(pp.getPermiso());
            txtDesc.setText(pp.getDescripcion());
            swPermiso.setChecked(pp.isEstado());
        }
    }
}
