package idat.edu.crudgestionfechas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import idat.edu.crudgestionfechas.Interfaz.JsonPlaceHolderApi;
import idat.edu.crudgestionfechas.entidad.Marca;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private TextView textViewResult;
    private TextView textViewResultProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult= findViewById(R.id.text_view_result);

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("http://192.168.1.9:9995/api/marcas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Marca>> call = jsonPlaceHolderApi.getMarcas();

        call.enqueue(new Callback<List<Marca>>() {
            @Override
            public void onResponse(Call<List<Marca>> call, Response<List<Marca>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("codigo: " +response.code());
                    return;
                }
                List<Marca> marcas = response.body();
                for (Marca marca: marcas){
                    String content = "";
                    content +="codigo:  "+marca.getId() + "\n";
                    content +="nombre:  "+marca.getMarca() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Marca>> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });
    }
}