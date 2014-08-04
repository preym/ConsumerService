package com.example.ConsumerService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocationHelper extends Activity implements LocationListener {
    protected LocationManager locationManager;
    protected Context context;
    private double latitude = 0;
    private double longitude = 0;
    TextView lat, lng;
    Button refresh;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lat = (TextView) findViewById(R.id.lat);
        lng = (TextView) findViewById(R.id.lng);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                refresh();
            }
        });
        dialog = new ProgressDialog(this);
        dialog.show();
        dialog.setMessage("Getting Coordinates");
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 10000,
                    1, this);
        } else if (locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 10000,
                    1, this);
        } else {
            dialog.dismiss();
            Toast.makeText(getApplicationContext(), "Enable Location", Toast.LENGTH_LONG).show();
        }
    }

    protected void refresh() {
        super.onResume();
        this.onCreate(null);
    }

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
        dialog.show();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        if (latitude != 0 && longitude != 0) {
            lat.setText("Latitude is :" + location.getLatitude());
            lng.setText("Longitude is :" + location.getLongitude());
            dialog.dismiss();
        }
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }
}
