package com.example.ConsumerService;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.model.Vendor;
import com.google.gson.Gson;

import java.text.DecimalFormat;
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
    Location currentLocation;


    public SupplierListAdapter(Context context, List<Vendor> vendors, Location location) {
        this.context = context;
        this.vendors = vendors;
        this.currentLocation = location;
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
        final Vendor vendor = vendors.get(position);
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
        Location targetLocation = new Location(LocationManager.GPS_PROVIDER);
        targetLocation.setLatitude(Double.parseDouble(vendor.getVendorLat()));
        targetLocation.setLongitude(Double.parseDouble(vendor.getVendorLong()));
        vendor.setLocation(targetLocation);
        float km = targetLocation.distanceTo(currentLocation) / 1000;
        distance.setText("Distance from Supplier " + new DecimalFormat("#.##").format(km) + " kms");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VendorDetailsActivity.class);
                intent.putExtra("vendor", new Gson().toJson(vendor));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
