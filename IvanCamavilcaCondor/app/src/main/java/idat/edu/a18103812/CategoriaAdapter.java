package idat.edu.a18103812;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoriaAdapter extends ArrayAdapter<CategoriaItem> {

    public CategoriaAdapter(@NonNull Context context, ArrayList<CategoriaItem> categoriList) {
        super(context, 0, categoriList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private  View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.categoria_spinner_row,parent,false
            );
        }
        ImageView imageViewFlag = convertView.findViewById(R.id.image_view_flag);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        CategoriaItem currentItem = getItem(position);
        if (currentItem != null){
            imageViewFlag.setImageResource(currentItem.getNroFlagImage());
            textViewName.setText(currentItem.getNombre());
        }
        return convertView;
    }
}
