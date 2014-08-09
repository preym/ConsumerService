package com.example.ConsumerService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductListAdaptet extends BaseAdapter {
    List keySet;
    Context context;

    ProductListAdaptet(List keySet, Context context) {
        this.keySet = keySet;
        this.context = context;
    }

    @Override
    public int getCount() {
        return keySet.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, viewGroup, false);
        TextView textView = (TextView) rowView.findViewById(R.id.item);
        textView.setText((String) keySet.get(i));
        return rowView;
    }




}
