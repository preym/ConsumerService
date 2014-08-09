package com.example.ConsumerService;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.model.User;
import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 9/8/14
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierSignup extends Activity {

    private EditText nameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText retypeInput;
    private EditText otpInput;
    private EditText mobileInput;
    private Button registerButton;
    public User user;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_signup);
        getWidgets();
        applyListener();
    }

    private void applyListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isvalidateForm()) {
                    registerUser();
                }
            }
        });

    }

    private void registerUser() {
        //TODO: Register user in server side
        //TODO: if registration success take him to dashboard
        saveUser();
        callDashboardActivity();
    }

    private void saveUser() {
        SharedPreferences preferences = getSharedPreferences("supplier", 0);
        preferences.edit().putString("current_supplier",
                new Gson().toJson(user)).commit();
    }

    private void callDashboardActivity() {
        Intent intent = new Intent(this, SupplierDashboard.class);
        startActivity(intent);
    }

    private boolean isvalidateForm() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String retype = retypeInput.getText().toString();
        String mobile = mobileInput.getText().toString();
        String otp = otpInput.getText().toString();

        if (name == null || name.equals("")) {
            nameInput.setError(getErrorFormat("Please Enter User Name"));
            return false;
        }
        if (email == null || email.equals("")) {
            emailInput.setError(getErrorFormat("Please Enter Email Id"));
            return false;
        }
        if (password == null || password.equals("")) {
            passwordInput.setError(getErrorFormat("Please Enter Password"));
            return false;
        }
        if (retype == null || retype.equals("")) {
            retypeInput.setError(getErrorFormat("Please Enter Re password"));
            return false;
        }
        if (mobile == null || mobile.equals("")) {
            mobileInput.setError(getErrorFormat("Please Enter Mobile Number"));
            return false;
        }
//        if (otp == null || otp.equals("")) {
//            emailInput.setError(getErrorFormat("Please Enter OTP"));
//            return false;
//        }
        if (!password.equals(retype)) {
            retypeInput.setError(getErrorFormat("Password doesn't match"));
            return false;
        }
        user = new User();
        user.setUserName(name);
        user.setEmailId(email);
        user.setMobile(mobile);
        user.setOtp(otp);
        user.setPassword(password);
        return true;
    }

    private SpannableStringBuilder getErrorFormat(String message) {
        int ecolor = Color.BLUE;
        String estring = message;
        ForegroundColorSpan fgcspan = new ForegroundColorSpan(ecolor);
        SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
        ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);
        return ssbuilder;
    }

    private void getWidgets() {
        nameInput = (EditText) findViewById(R.id.signup_name);
        emailInput = (EditText) findViewById(R.id.signup_email);
        passwordInput = (EditText) findViewById(R.id.signup_pwd);
        retypeInput = (EditText) findViewById(R.id.signup_retype);
        otpInput = (EditText) findViewById(R.id.signup_otp);
        mobileInput = (EditText) findViewById(R.id.signup_mobile);
        registerButton = (Button) findViewById(R.id.signup_register);
    }
}
