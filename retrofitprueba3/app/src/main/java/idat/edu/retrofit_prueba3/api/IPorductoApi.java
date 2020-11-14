package idat.edu.retrofit_prueba3.api;

import java.util.List;

import idat.edu.retrofit_prueba3.modelo.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IPorductoApi {
    @GET("all")
    Call<List<Producto>> getProductos();
}
