package com.example.ConsumerService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddProductActivity extends Activity {
    MenuItem item;
    Button saveButton;
    EditText productName;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        getWidgets();
    }

    private void getWidgets() {
        productName = (EditText) findViewById(R.id.prodct_name);
        saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProduct();
            }
        });

    }

    private void saveProduct() {
        String input = productName.getText().toString();

        if (input.equals("")) {
            productName.setError("Please Enter Product Name");
        } else {
            //TODO: SaveProduct
            item.setVisible(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vendor_menu, menu);
        item = menu.findItem(R.id.add_product);
        item.setVisible(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_product:
                addSubItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addSubItem() {

    }
}
