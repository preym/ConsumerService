package com.example.ConsumerService;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
    Button vendor;
    Button supplier;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        vendor = (Button) findViewById(R.id.vendor);
        supplier = (Button) findViewById(R.id.supplier);
        applyActions();
    }

    private void applyActions() {
        vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callVendorDashboard();
            }
        });
        supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSupplierDashboard();
            }
        });
    }


    private void callSupplierDashboard() {
        Intent intent;
        SharedPreferences preferences = getSharedPreferences("supplier", 0);
        String currentSupplier = preferences.getString("current_supplier", null);
        if (currentSupplier == null || currentSupplier.equals("")) {
            intent = new Intent(this, SupplierSignup.class);
        } else {
            intent = new Intent(this, SupplierDashboard.class);
        }
        startActivity(intent);
    }

    private void callVendorDashboard() {
        Intent intent = new Intent(this, VendorDashboard.class);
        startActivity(intent);
    }
}
