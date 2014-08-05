package com.example.ConsumerService;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendorDashboard extends Activity {
    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_dashboard);
        listView = (ListView) findViewById(R.id.listview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("products", 0);
        Map keys = preferences.getAll();
        Set keySet = keys.keySet();
        listView.setAdapter(new MyAdaptet(new ArrayList(keySet), this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinearLayout layout = (LinearLayout) view;
                String text = ((TextView) layout.getChildAt(0)).getText().toString();
                callProductDetailsActivity(text);
            }
        });
    }

    private void callProductDetailsActivity(String productName) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("product", productName);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vendor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
