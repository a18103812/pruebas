package idat.edu.a18103812;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private ArrayList<CategoriaItem> mCategoriaList;
private CategoriaAdapter mAdapter;

GridView gridView;
String[] codes = {"1","2","3",};
String[] names = {"conjunto","chavito","playero"};
String[] prices = {"10","35","47"};
int[] images = {R.drawable.conjunto,R.drawable.chavita,R.drawable.playero};


    GridView gridView2;
    String[] codes2 = {"test code"};
    String[] names2 = {"test name"};
    String[] prices2 = {"test price"};
    int[] images2 = {R.drawable.laptop,R.drawable.tecnico,R.drawable.accesorios};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);


CustomAdapter customAdapter = new CustomAdapter( codes,names,prices,images,this);
        CustomAdapter customAdapter2 = new CustomAdapter( codes2,names2,prices2,images2,this);

gridView.setAdapter(customAdapter);

        initList();

        //spinner
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);

        mAdapter= new CategoriaAdapter(this, mCategoriaList);
        spinnerCategoria.setAdapter(mAdapter);

        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoriaItem clickedItem = (CategoriaItem) parent.getItemAtPosition(position);
                String clickedCategoriaName = clickedItem.getNombre();
                Toast.makeText(MainActivity.this, clickedCategoriaName + "selected ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


public class CustomAdapter extends BaseAdapter{


        private String[] id;
        private String[] imageNames;
        private String[] precio;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

    public CustomAdapter(String[] id, String[] imageNames,  String[] precio,int[] imagesPhoto, Context context) {
        this.id = id;
        this.imageNames = imageNames;
        this.precio = precio;
        this.imagesPhoto = imagesPhoto;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return imagesPhoto.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null ){
            view = layoutInflater.inflate(R.layout.row_items, viewGroup,false);
        }
        TextView codigo = view.findViewById(R.id.codigo);
        TextView nombre = view.findViewById(R.id.nombreProducto);
        TextView precio_ = view.findViewById(R.id.precioProducto);
        ImageView imageview = view.findViewById(R.id.imageView);


        codigo.setText(id[i]);
        nombre.setText(imageNames[i]);
        precio_.setText(precio[i]);
        imageview.setImageResource(imagesPhoto[i]);

        return view;
    }
}





    private void initList() {
        mCategoriaList = new ArrayList<>();
        mCategoriaList.add(new CategoriaItem("Computo",R.drawable.computo));
        mCategoriaList.add(new CategoriaItem("Ropas",R.drawable.ropas));

    }
}