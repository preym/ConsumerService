package com.example.ConsumerService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.model.Vendor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 9/8/14
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierListAdapter extends BaseAdapter {
    Context context;
    List<Vendor> vendors;


    public SupplierListAdapter(Context context, List<Vendor> vendors) {
        this.context = context;
        this.vendors = vendors;
    }

    @Override
    public int getCount() {
        return vendors.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.vendor_details_item, null);
        Vendor vendor = vendors.get(position);

        TextView name = (TextView) view.findViewById(R.id.vendor_name);
        TextView products = (TextView) view.findViewById(R.id.vendor_products);
        TextView distance = (TextView) view.findViewById(R.id.vendor_distance);
        ImageView image = (ImageView) view.findViewById(R.id.vendor_image);

        name.setText(vendor.getVendorName());
        String productString = "";
        for (int i = 0; i < vendor.getVendorProducts().length; i++) {
            productString = productString + ", " + vendor.getVendorProducts()[i];
        }
        products.setText("Type of Products: " + productString);
        return view;
    }
}
