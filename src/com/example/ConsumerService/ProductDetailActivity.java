package com.example.ConsumerService;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {
    TextView title;
    ListView listView;
    Button addButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        getWidgets();
    }

    private void getWidgets() {
        title = (TextView) findViewById(R.id.product_title);
        listView = (ListView) findViewById(R.id.sub_products);
        addButton = (Button) findViewById(R.id.add_product);
        String productName = getIntent().getStringExtra("product");
        title.setText(productName);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
