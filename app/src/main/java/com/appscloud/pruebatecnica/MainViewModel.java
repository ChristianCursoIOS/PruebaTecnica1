package com.appscloud.pruebatecnica;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appscloud.pruebatecnica.api.APICliente;
import com.appscloud.pruebatecnica.model.Datos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Datos>> listaDatosM = new MutableLiveData<>();

    public LiveData<List<Datos>> getDatosLista() {
        return listaDatosM;
    }

    public void getDatos() {

        APICliente.DatoService service = APICliente.getInstance().getService();


        service.getDatos().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("PROBANDO", response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

        /*ArrayList<Datos> listaDatosM = new ArrayList<>();

        listaDatosM.add(new Datos("autiroria 1", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Datos("autiroria 2", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Datos("autiroria 3", "12/07/2023", "Tlalpan"));
        listaDatosM.add(new Datos("autiroria 4", "12/07/2023", "Tlalpan"));*/

       // this.listaDatosM.setValue(listaDatosM);

    }


}
