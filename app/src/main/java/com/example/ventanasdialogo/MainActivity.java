package com.example.ventanasdialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnV_Mensaje, btnV_Botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnV_Mensaje = findViewById(R.id.btnV_Mensaje);
        btnV_Botones = findViewById(R.id.btnV_Botones);

        btnV_Mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Atención");
                ad.setMessage("Esto es un mensaje. Pulsa el boton atras para volver");
                ad.setIcon(android.R.drawable.ic_dialog_alert);
                ad.show();
            }
        });

        btnV_Botones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Atención");
                ad.setMessage("Esto es un mensaje. Pulsa el boton OK para volver");
                ad.setIcon(android.R.drawable.ic_dialog_alert);
                ad.setCancelable(false);
                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
//                ad.setNeutralButton("Recordarme más tarde", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "Has pulsado Recordarme más tarde", Toast.LENGTH_SHORT).show();
//                        dialog.cancel();
//                    }
//                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    @TargetApi(16) //Suprime los errores de correspondencia de API
                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
                        finishAffinity(); //Cierra la pila (A PARTIR DE LA API 16)
                    }
                });
                ad.show();
            }
        });
    }
}
