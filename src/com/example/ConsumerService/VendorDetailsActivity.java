package com.example.ConsumerService;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import com.example.model.Vendor;
import com.google.gson.Gson;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 9/8/14
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendorDetailsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_details);
        String addressString = "";
        Vendor vendor = new Gson().fromJson(getIntent().getStringExtra("vendor"), Vendor.class);
        String[] products = vendor.getVendorProducts();
        String productString = "";
        for (int i = 0; i < products.length; i++) {
            productString = productString + ", " + products[i];
        }

        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
        Location location = vendor.getLocation();
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(),
                    location.getLongitude(), 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (addresses != null && addresses.size() > 0) {
            Address address = addresses.get(0);
            addressString = address.getAddressLine(0) + "\n" + address.getLocality()
                    + "\n" + address.getSubAdminArea() + "\n" +
                    address.getAdminArea() + "\n" + address.getPostalCode();

        }

        TextView textView = (TextView) findViewById(R.id.vendor_details);
        textView.setText("Name: " + vendor.getVendorName() + "\n" +
                "Mobile:" + vendor.getVendorMobile() + "\n" +
                "Products:" + productString + "\n" +
                "Address:" + addressString);
    }
}
