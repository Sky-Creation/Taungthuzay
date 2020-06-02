package com.ttz.taungthuzay.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ttz.taungthuzay.R;
import com.ttz.taungthuzay.startup.MainActivity;


public class MyOrderActivity extends AppCompatActivity {
    Button orderbtn;
    RecyclerView recyclerVieworder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        orderbtn = findViewById(R.id.myorderbutton);
        recyclerVieworder = findViewById(R.id.recyclervieworder);
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MyOrderActivity.this, MainActivity.class);
                startActivity(in);
            }
        });

    }
}
