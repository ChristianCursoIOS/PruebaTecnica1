package com.appscloud.pruebatecnica;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.appscloud.pruebatecnica.databinding.ActivityMainBinding;
import com.appscloud.pruebatecnica.model.Dato;
import com.appscloud.pruebatecnica.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatosAdapter.OnItemClickListener {

    List<Dato> datoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<Dato> listaDatosM = new ArrayList<>();

        listaDatosM.add(new Dato("autiroria 1", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Dato("autiroria 2", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Dato("autiroria 3", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Dato("autiroria 4", "12/07/2023", "Tlalpan"));




        DatosAdapter datosAdapter = new DatosAdapter(listaDatosM);






       /* datosAdapter.setOnItemClickListener(new DatosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

        });*/

        binding.recyclerView.setAdapter(datosAdapter);
        datosAdapter.setOnItemClickListener(this);

        // Forma clasica de implementar interface observe
        /*mainViewModel.getDatosLista().observe(this, new Observer<List<Dato>>() {
            @Override
            public void onChanged(List<Dato> datoes) {
                datosAdapter.setOnItemClickListener(MainActivity.this);
            }
        });*/

        // forma lambda de implementar interface
        mainViewModel.getDatosLista().observe(this, datosLista ->
                datosAdapter.setOnItemClickListener(this));
        mainViewModel.getDatos();


    }


    @Override
    public void onItemClick(Dato dato) {
        Toast.makeText(this, dato.getAuditoria(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(Dato dato) {

    }
}