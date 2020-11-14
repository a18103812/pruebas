package idat.retrofit_prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import idat.retrofit_prueba2.interfaces.JsonPlaceHolderApi;
import idat.retrofit_prueba2.model.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mJsonTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJsonTextView= findViewById(R.id.jsonText);
        getProducts();
    }

    private void getProducts (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9:9993/api/producto/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Producto>> call = jsonPlaceHolderApi.getPro();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()){
                    mJsonTextView.setText("codigo: "+response.code());
                    return;
                }
                List<Producto> productoList = response.body();
                //obtener tipos
                for (Producto producto: productoList ){
                    String content="";
                    content += "codigo:  "+ producto.getPro_codigo() +"\n";
                    content += "nombre:  "+ producto.getPro_nombre() +"\n";
                    content += "descripcion:  "+ producto.getPro_descripcion() +"\n";
                    content += "precio:  "+ producto.getPro_precio() +"\n\n";
                    mJsonTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                     mJsonTextView.setText(t.getMessage());
            }
        });
    }
}