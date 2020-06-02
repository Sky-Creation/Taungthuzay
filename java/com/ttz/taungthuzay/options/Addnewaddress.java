package com.ttz.taungthuzay.options;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ttz.taungthuzay.R;
import com.ttz.taungthuzay.utility.UserData;


public class Addnewaddress extends AppCompatActivity {
    Activity activity;
    private EditText cityEdit, locationEdit, flatnoEdit, pincodeEdit, stateEdit, lanmarkEdit, nameEdit, phonenumberEdit, alternatephonenumberEdit;
    private TextView saveDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewaddress);
        activity = this;

//        saveDetailsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (cityEdit.getText().toString().equals("") || locationEdit.getText().toString().equals("") ||
//                        flatnoEdit.getText().toString().equals("") || pincodeEdit.getText().toString().equals("") ||
//                        stateEdit.getText().toString().equals("") || lanmarkEdit.getText().toString().equals("") ||
//                        nameEdit.getText().toString().equals("") || phonenumberEdit.getText().toString().equals("") ||
//                        alternatephonenumberEdit.getText().toString().equals("")) {
//                    cityEdit.setError("city should not be left blank");
//                    locationEdit.setError("location should not be left blank");
//                    flatnoEdit.setError("flat no or building name should not be left blank");
//                    pincodeEdit.setError("postal code should not be left blank");
//                    nameEdit.setError("name should not be left blank");
//                    stateEdit.setError("state should not be left blank");
//                    phonenumberEdit.setError("mobile number should not be left blank");
//                } else {
//                    UserData.setDeliveryName(Addnewaddress.this, cityEdit.getText().toString());
//                    UserData.setDeliveryName(Addnewaddress.this, locationEdit.getText().toString());
//                    UserData.setDeliveryName(Addnewaddress.this, flatnoEdit.getText().toString());
//                    UserData.setDeliveryPincode(Addnewaddress.this, pincodeEdit.getText().toString());
//                    UserData.setDeliveryName(Addnewaddress.this, stateEdit.getText().toString());
//                    UserData.setDeliveryName(Addnewaddress.this, lanmarkEdit.getText().toString());
//                    UserData.setDeliveryName(Addnewaddress.this, nameEdit.getText().toString());
//                    UserData.setDeliveryMobileNo(Addnewaddress.this, phonenumberEdit.getText().toString());
//                    Intent i = new Intent(Addnewaddress.this, OrderAddressActivity.class);
//                    startActivity(i);
//                }
//            }
//        });
   }
//
//    private void initViews() {
//        cityEdit = findViewById(R.id.cityedit);
//        locationEdit = findViewById(R.id.locationedit);
//        flatnoEdit = findViewById(R.id.flatnoedit);
//        nameEdit = findViewById(R.id.name);
//        pincodeEdit = findViewById(R.id.pinCodeEdit);
//        phonenumberEdit = findViewById(R.id.phonenumber);
//        stateEdit = findViewById(R.id.state);
//        lanmarkEdit = findViewById(R.id.landmark);
//        alternatephonenumberEdit = findViewById(R.id.alternatephonenumber);
//        RadioGroup addressTypeRadioGroup = findViewById(R.id.addressTypeRadioGroup);
//        RadioButton homeTypeAddressRadio = findViewById(R.id.homeTypeAddressRadio);
//        RadioButton commercialTypeAddressRadio = findViewById(R.id.commercialTypeAddressRadio);
//        saveDetailsButton = findViewById(R.id.saveDetailsButton);
//
//    }
}
