package com.appscloud.pruebatecnica;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appscloud.pruebatecnica.api.APICliente;
import com.appscloud.pruebatecnica.model.Dato;
import com.appscloud.pruebatecnica.model.PokeRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainViewModel extends ViewModel {
    private final String TAG = "Descarga de datos";

    private final MutableLiveData<List<Dato>> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<Dato>> getDatosLista() {
        return mutableLiveData;
    }

    public void getDatos() {

        APICliente.DatoService service = APICliente.getInstance().getService();
        service.getDatosAPI().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }

        });


          /*  ArrayList<Dato> listaDatosM = new ArrayList<>();

            listaDatosM.add(new Dato("autiroria 1", "12/07/2023", "Tlalpan"));
            listaDatosM.add(new Dato("autiroria 2", "12/07/2023", "Tlalpan"));
            listaDatosM.add(new Dato("autiroria 3", "12/07/2023", "Tlalpan"));
            listaDatosM.add(new Dato("autiroria 4", "12/07/2023", "Tlalpan"));

            this.mutableLiveData.setValue(listaDatosM);

            return listaDatosM;*/


    }


}
