package codigo.a18103812.idat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import codigo.a18103812.idat.R;
import codigo.a18103812.idat.entity.Ropas;

public class RopasAdapter extends ArrayAdapter<Ropas> {

    public RopasAdapter(@NonNull Context context, int resource, List<Ropas> objects) {
        super(context, resource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null) {
         convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_ropas,parent,false);

        }
        TextView txtId = convertView.findViewById(R.id.txtId);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        TextView txtPrecio = convertView.findViewById(R.id.txtPrecio);
        ImageView imgRopas=convertView.findViewById(R.id.imgRopas);

        Ropas ropas = getItem(position);
        imgRopas.setImageResource(ropas.);
        imgRopas.setImageResource(ropas.getId_());
        t
    }
}
