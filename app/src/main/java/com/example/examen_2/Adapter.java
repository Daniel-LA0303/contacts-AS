package com.example.examen_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public Adapter (List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    @NonNull
    @Override
    public Adapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new Adapter.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolderDatos holder,final int position) {
        holder.asignarDatos(mData.get(position));
    }
    public void setItems(List<ListElement> items){
        mData = items;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView name, city, status, id;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            city = itemView.findViewById(R.id.cityTextView);
            status = itemView.findViewById(R.id.statusTextView);
            id = itemView.findViewById(R.id.idTextView);
        }
        public void asignarDatos(final ListElement item
        ){
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());
            id.setText(item.getId());
        }
    }
}