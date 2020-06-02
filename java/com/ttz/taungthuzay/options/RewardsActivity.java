package com.ttz.taungthuzay.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ttz.taungthuzay.R;
import com.ttz.taungthuzay.startup.MainActivity;

public class RewardsActivity extends AppCompatActivity {
    Button rewardbtn;
    RecyclerView recyclerViewreward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        recyclerViewreward = findViewById(R.id.recyclervieworder);
        rewardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RewardsActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}
