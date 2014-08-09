package com.example.ConsumerService;

import android.app.Activity;
import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.model.Vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierDashboard extends Activity implements View.OnClickListener, LocationListener {

    private Button nearByButton;
    private Button locationByButton;
    private ListView vendorListView;
    private TextView locationInfo;
    List<Vendor> vendors = new ArrayList<Vendor>();

    protected LocationManager locationManager;
    private double latitude = 0;
    private double longitude = 0;
    Location currentLocation;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_dashboard);
        getVendors();
        getWidgets();
        getGeoLocation();
        vendorListView.setAdapter(new SupplierListAdapter(this, vendors, currentLocation));
    }

    private void getVendors() {
        String[] products = {"TV", "LAPTOP", "UPS"};
        Vendor vendor1 = new Vendor("Prem", "9885080234", "Kukatpalli", "17.511829800000000000",
                "78.384622600000060000", products);
        Vendor vendor2 = new Vendor("Sree", "8187835811", "Jublihills", "17.453461300000000000",
                "78.438704499999970000", products);
        Vendor vendor3 = new Vendor("Ram", "9908671431", "ameerpet", "17.434801700000000000",
                "78.448010999999950000", products);

        Vendor vendor4 = new Vendor("Ram", "9849112148", "secundrabad", "17.439929500000000000",
                "78.498274100000000000", products);

        Vendor vendor5 = new Vendor("Krishna", "9948755155", "miyapur", "17.418892700000000000",
                "78.580279499999960000", products);
        vendors.add(vendor1);
        vendors.add(vendor2);
        vendors.add(vendor3);
        vendors.add(vendor4);
        vendors.add(vendor5);
    }


    public void getGeoLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    10000, 1, this);
        } else if (locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 10000, 1, this);
        } else {
            Toast.makeText(getApplicationContext(), "Enable Location", Toast.LENGTH_LONG).show();
        }
        currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude = currentLocation.getLatitude();
        longitude = currentLocation.getLongitude();
        displayCurrentLocation(currentLocation);
    }

    protected void displayCurrentLocation(Location params) {
        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
        Location location = params;
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(),
                    location.getLongitude(), 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (addresses != null && addresses.size() > 0) {
            Address address = addresses.get(0);
            Log.d("Address ", address.getAdminArea());
            Log.d("Address ", address.getAddressLine(0));
            Log.d("Address ", address.getCountryName());
            Log.d("Address ", address.getLocality());
            Log.d("Address ", address.getSubAdminArea());
            Log.d("Address ", address.getPostalCode());

            locationInfo.setText(address.getAddressLine(0) + "\n" + address.getLocality()
                    + "\n" + address.getSubAdminArea() + "\n" +
                    address.getAdminArea() + "\n" + address.getPostalCode());
        }
    }


    private void getWidgets() {
        nearByButton = (Button) findViewById(R.id.button_search_near);
        locationByButton = (Button) findViewById(R.id.button_search_location);
        vendorListView = (ListView) findViewById(R.id.vendor_list);
        locationInfo = (TextView) findViewById(R.id.geo_location_text);
        nearByButton.setOnClickListener(this);
        locationByButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.button_search_near:
                searchByNear();
                break;
            case R.id.button_search_location:
                searchByLocation();
                break;
        }
    }

    private void searchByLocation() {
    }

    private void searchByNear() {

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        vendorListView.setAdapter(new SupplierListAdapter(this, vendors, location));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderEnabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderDisabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
