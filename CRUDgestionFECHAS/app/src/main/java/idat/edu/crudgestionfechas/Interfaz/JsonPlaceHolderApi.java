package idat.edu.crudgestionfechas.Interfaz;

import java.util.List;

import idat.edu.crudgestionfechas.entidad.Marca;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("all")
    Call<List<Marca>> getMarcas();
}
