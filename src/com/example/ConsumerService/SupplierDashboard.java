package com.example.ConsumerService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.example.model.Vendor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: venkatesh
 * Date: 4/8/14
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierDashboard extends Activity implements View.OnClickListener {

    private Button nearByButton;
    private Button locationByButton;
    private ListView vendorListView;
    private TextView locationInfo;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_dashboard);
        String[] products = {"TV", "LAPTOP", "UPS"};

        Vendor vendor1 = new Vendor("Prem", "9885080234", "Hyderabad", "17.511829800000000000",
                "78.384622600000060000", products);

        Vendor vendor2 = new Vendor("Sree", "9885080234", "Mumbai", "17.453461300000000000",
                "78.438704499999970000", products);

        List<Vendor> vendors = new ArrayList<Vendor>();
        vendors.add(vendor1);
        vendors.add(vendor2);
        getWidgets();

        vendorListView.setAdapter(new SupplierListAdapter(this, vendors));
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
        //To change body of created methods use File | Settings | File Templates.
    }

    private void searchByNear() {


    }
}
