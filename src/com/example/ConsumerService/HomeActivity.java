package com.example.ConsumerService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vendor:
                callVendorDashboard();
                break;
            case R.id.supplier:
                callSupplierDashboard();
                break;
        }
    }

    private void callSupplierDashboard() {
        Intent intent = new Intent(this, SupplierDashboard.class);
        startActivity(intent);
    }

    private void callVendorDashboard() {
        Intent intent = new Intent(this, SupplierDashboard.class);
        startActivity(intent);
    }
}
