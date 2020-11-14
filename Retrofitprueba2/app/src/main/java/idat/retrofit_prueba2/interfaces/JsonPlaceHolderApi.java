package idat.retrofit_prueba2.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

import idat.retrofit_prueba2.model.Producto;

public interface JsonPlaceHolderApi {
    @GET("all")
    Call<List<Producto>> getPro();

}
