package com.example.copa01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class mapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        androidx.cardview.widget.CardView bt = (androidx.cardview.widget.CardView)findViewById(R.id.cardview_mapapramenu);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(mapa.this, menu.class);
                startActivity(it);

            }
        });


    }

    public void btnmapa (View view){
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(mapa.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(mapa.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            ActivityCompat.requestPermissions(mapa.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            return;
        }

        LocationManager LocManager = (LocationManager) getSystemService(mapa.this.LOCATION_SERVICE);
        LocationListener LocListener = new classLocalizacao();

        LocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, LocListener);

        if (LocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String texto = "Latitude.: " + classLocalizacao.latitude + "\n" +
                    "Longitude: " + classLocalizacao.longitude + "\n";
            Toast.makeText(mapa.this, texto, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mapa.this, "Requerimento negado.", Toast.LENGTH_LONG).show();
        }

        this.mostrarLocalizacaoDados(classLocalizacao.latitude, classLocalizacao.longitude);

    }

    public void mostrarLocalizacaoDados ( double latitude, double longitude) {
        TextView textloc = findViewById(R.id.txtpermissao);


        textloc.setText("Sua exata localização atual é:" + "\n" + latitude  + "\n" + longitude);

    }



// Mapa

    public void btnmapaestadio(View view)
    {

        Uri location = Uri.parse("geo:@25.4207485,51.4904623,17z");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);

    }

}