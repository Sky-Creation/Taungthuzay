package com.ttz.taungthuzay.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ttz.taungthuzay.R;


public class AccountActivity extends AppCompatActivity {
    TextView textViewviewallorder,textviewAddnewaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textViewviewallorder = findViewById(R.id.viewallorder);
        textViewviewallorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AccountActivity.this, Viewallororder.class);
                startActivity(in);
            }
        });
        textviewAddnewaddress=findViewById(R.id.tv_address);
        textviewAddnewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccountActivity.this,Addnewaddress.class);
                startActivity(intent);
            }
        });

    }
}
