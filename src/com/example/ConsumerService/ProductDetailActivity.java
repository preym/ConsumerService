package com.example.ConsumerService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends Activity {
    TextView title;
    ListView listView;
    Button addButton;
    String productName;
    String inputProductName;
    List<String> existingList;
    SharedPreferences preferences;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        getWidgets();
        getExixtingList();
        applyAdapter();
    }

    private void applyAdapter() {
        listView.setAdapter(new MyAdaptet(existingList, this));
    }

    private void getExixtingList() {
        preferences = getSharedPreferences("subproducts", 0);
        String existingJson = preferences.getString(productName, null);
        if (existingJson == null || existingJson.equals("")) {
            existingList = new ArrayList<String>();
        } else {
            existingList = new Gson().fromJson(existingJson, List.class);
        }
    }

    private void getWidgets() {
        title = (TextView) findViewById(R.id.product_title);
        listView = (ListView) findViewById(R.id.sub_products);
        addButton = (Button) findViewById(R.id.button_add_sub_product);
        productName = getIntent().getStringExtra("product");
        title.setText(productName);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSubProduct();
            }
        });

    }

    private void addSubProduct() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Add Subproduct");
        alertDialog.setMessage("Enter Item Name");
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        inputProductName = input.getText().toString();
                        if (!inputProductName.equals("")) {
                            if (existingList.contains(inputProductName)) {
                                input.setError("Product Already Exist");
                            } else {
                                saveProduct(inputProductName);
                                dialog.dismiss();
                            }
                        }
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private void saveProduct(String inputProductName) {
        if (existingList == null) {
            existingList = new ArrayList();
        }
        existingList.add(inputProductName);
        preferences.edit().putString(productName, new Gson().toJson(existingList)).commit();
        applyAdapter();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
