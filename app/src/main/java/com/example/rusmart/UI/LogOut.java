package com.example.rusmart.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rusmart.Model.PrefManager;
import com.example.rusmart.R;
import com.facebook.login.LoginManager;

public class LogOut extends AppCompatActivity {

    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        btnLogOut = findViewById(R.id.btnLogOut);

        SharedPreferences mLogin = getSharedPreferences("login", Context.MODE_PRIVATE);



        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {

                            case DialogInterface.BUTTON_POSITIVE:
                                SharedPreferences mLogin = getSharedPreferences("login", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = mLogin.edit();
                                editor.clear();
                                editor.apply();
                                Intent intent = new Intent(LogOut.this, SplashScreen.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            case DialogInterface.BUTTON_NEGATIVE:
                                Toast.makeText(getApplicationContext(), "Data gagal di simpan", Toast.LENGTH_LONG).show();
                                break;
                        }

                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Apakah anda yakin ingin keluar?").setPositiveButton("Ya", dialog)
                        .setNegativeButton("Tidak", dialog).show();

            }
        });

    }
}
