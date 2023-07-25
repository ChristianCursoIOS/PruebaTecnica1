package com.appscloud.pruebatecnica.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class APICliente {

    private static final String API_KEY = "adaDataService.svc/ObtenerMisAuditoriasPorFecha?llavemaestra=1058028";

    public interface DatoService {
        @GET(API_KEY)// ENDPOINT
        Call<String> getDatosAPI();
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dev.auditoriadev.com/ServicioADAProd/")
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
            service = retrofit.create(DatoService.class); // iniciar
        }

        return service;
    }
}
