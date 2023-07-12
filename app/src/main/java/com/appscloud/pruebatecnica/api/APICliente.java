package com.appscloud.pruebatecnica.api;

import com.appscloud.pruebatecnica.DatosAdapter;
import com.appscloud.pruebatecnica.model.Datos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class APICliente {

    public interface DatoService {
        @GET("1058028")
        Call<String> getDatos();
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dev.auditoriadev.com/ServicioADAProd/adaDataService.svc/ObtenerMisAuditoriasPorFecha/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    private DatoService service;

    //Singleton
    private static final APICliente ourInstance = new APICliente();

    public static APICliente getInstance() {
        return ourInstance;
    }

    private APICliente() {

    }

    public DatoService getService() {
        if (service == null) {
            service = retrofit.create(DatoService.class);

        }


        return service;

    }
}
