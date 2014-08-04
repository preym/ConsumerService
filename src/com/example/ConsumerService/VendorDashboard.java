package com.example.ConsumerService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendorDashboard extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_dashboard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vendor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_product:
                callAddProductActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void callAddProductActivity() {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);


    }


}
