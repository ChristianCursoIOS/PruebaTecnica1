package com.appscloud.pruebatecnica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.appscloud.pruebatecnica.api.APICliente;
import com.appscloud.pruebatecnica.databinding.ActivityMainBinding;
import com.appscloud.pruebatecnica.model.Datos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel mainViewModel =new ViewModelProvider(this).get(MainViewModel.class);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatosAdapter datosAdapter = new DatosAdapter();
        datosAdapter.setOnItemClickListener(new DatosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Datos datos) {
                Toast.makeText(MainActivity.this, datos.getAuditoria(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recyclerView.setAdapter(datosAdapter);
        mainViewModel.getDatosLista().observe(this, datos -> {
            datosAdapter.submitList(datos);

        });


       // APICliente.getInstance().getService().getDatos();
        mainViewModel.getDatos();
    }
}