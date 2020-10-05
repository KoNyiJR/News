package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends ArrayAdapter<Model> {

    private Context context;
    private List<Model> modelList;


    public Adapter(Context context, List<Model> modelList) {
        super(context, R.layout.test, modelList);

        this.context = context;
        this.modelList = modelList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test, null, true);
        TextView title = view.findViewById(R.id.title);
        TextView content = view.findViewById(R.id.content);
        ImageView imvImage = view.findViewById(R.id.imvImage);

        title.setText(modelList.get(position).getTitle());
        content.setText(modelList.get(position).getContent());
        Glide.with(context).load(modelList.get(position).getImage()).into(imvImage);

        return view;
    }
}
