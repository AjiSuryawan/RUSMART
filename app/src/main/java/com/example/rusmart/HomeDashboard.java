package com.example.rusmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeDashboard extends AppCompatActivity {

    CardView cdCatatTagihan;
    CardView cdLihatTagihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);

        cdCatatTagihan = findViewById(R.id.cdCatatTagihan);
        cdLihatTagihan = findViewById(R.id.cdLihatTagihan);

        cdCatatTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeDashboard.this,Home_1.class);
                startActivity(intent);
            }
        });

        cdLihatTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeDashboard.this,Home_2.class);
                startActivity(intent);
            }
        });


    }
}
