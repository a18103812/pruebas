package idat.edu.crudgestionfechas.Interfaz;

import java.util.List;

import idat.edu.crudgestionfechas.entidad.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApiProducto {
    @GET("all")
    Call<List<Producto>> getProductos();
}
