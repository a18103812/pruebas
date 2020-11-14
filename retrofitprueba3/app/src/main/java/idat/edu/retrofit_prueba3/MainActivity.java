package idat.edu.retrofit_prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import idat.edu.retrofit_prueba3.api.IPorductoApi;
import idat.edu.retrofit_prueba3.modelo.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView txtcodigo,txtnombre,txtdescripcion,txtprecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcodigo=findViewById(R.id.txtcodigo);
        txtnombre=findViewById(R.id.txtnombre);
        txtdescripcion=findViewById(R.id.txtdescripcion);
        txtprecio=findViewById(R.id.txtprecio);


         getProducto();

    }
    public void getProducto(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.9:9993/api/producto/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPorductoApi iPorductoApi = retrofit.create(IPorductoApi.class);

        Call<List<Producto>> llamar = iPorductoApi.getProductos();

        llamar.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()){
                    System.out.println("codigo: " +response.code());
                       return;
                }
                List<Producto> listaProductos = response.body();
                for (Producto pr: listaProductos){
                    txtcodigo.append(pr.getPro_codigo().toString()+"\n");
                    txtnombre.append(pr.getPro_nombre()+"\n");
                    txtdescripcion.append(pr.getPro_descripcion()+"\n");
                    txtprecio.append(pr.getPro_precio().toString()+"\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }
}