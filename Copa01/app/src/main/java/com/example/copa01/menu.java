package com.example.copa01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class menu extends AppCompatActivity {

   // FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
      //  fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        View botaofechar = findViewById(R.id.btnsair);
        botaofechar.setOnClickListener(new View.OnClickListener(){
           
            @Override
            public void onClick(View view){
                finish();
            }
            
        });

        androidx.cardview.widget.CardView bt = (androidx.cardview.widget.CardView)findViewById(R.id.btmacostes);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(menu.this, home.class);
                startActivity(it);
            }
        });


        androidx.cardview.widget.CardView bt1 = (androidx.cardview.widget.CardView)findViewById(R.id.btnselecoes);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(menu.this, selecaonova.class);
                startActivity(it);
            }
        });







        androidx.cardview.widget.CardView bt6 = (androidx.cardview.widget.CardView)findViewById(R.id.btnmapa);

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(menu.this, mapa.class);
                startActivity(it);
            }
        });

        androidx.cardview.widget.CardView bt2 = (androidx.cardview.widget.CardView)findViewById(R.id.btnloja);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(menu.this, loja.class);
                startActivity(it);
            }
        });


        androidx.cardview.widget.CardView btn4 = (androidx.cardview.widget.CardView)findViewById(R.id.btnjogo);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(menu.this, jogosensor.class);
                startActivity(it);
            }
        });



    }


    // Hino - youtube
    public void btnhino (View view) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=Z7pFwsX6UVc&ab_channel=brasilhinario");
        Intent hino = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Z7pFwsX6UVc&ab_channel=brasilhinario"));
        startActivity(hino);
    }


    // Pesquisar/buscar

    public void btnpesquisa (View view){
        Intent pesquisar = new Intent(Intent.ACTION_WEB_SEARCH);
        String query = "Estádios que semearam a copa";
        pesquisar.putExtra(SearchManager.QUERY, query);
        startActivity(pesquisar);
    }

    // Email

    public void btnemail(View view) throws UnsupportedEncodingException {


        String uriText =
                "mailto:leonardo.mazzuco2019@gmail.com" +
                        "?subject=" + URLEncoder.encode("Alguma sugestão?", "utf-8") +
                        "&body=" + URLEncoder.encode("Quaiques duvidas, escreva abaixo", "utf-8");
        Uri uri = Uri.parse(uriText);

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(uri);
        startActivity(email);

    }

    /*
    // Mapa

    public void btnmapa(View view)
    {

        Uri location = Uri.parse("geo:@25.4207485,51.4904623,17z");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);

    }*/

    // telefone

    public void btnchamada(View view)
    {
        Uri uri = Uri.parse("tel:1194163310");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }




    /*

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 10){
            if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLocation();
            }
            else{
                {
                    Toast.makeText(menu.this, "Permissão de localização negada.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
        }
        else{
            requestPermission();
        }
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);
    }
*/
/*
    public void btnmapa(View view) {
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(menu.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(menu.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            ActivityCompat.requestPermissions(menu.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            return;
        }

        LocationManager LocManager = (LocationManager) getSystemService(menu.this.LOCATION_SERVICE);
        LocationListener LocListener = new classLocalizacao();

        LocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, LocListener);

        if (LocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            String texto = "Latitude.: " + classLocalizacao.latitude + "\n" +
                    "Longitude: " + classLocalizacao.longitude + "\n";
            Toast.makeText(menu.this, texto, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(menu.this, "Requerimento negado.", Toast.LENGTH_LONG).show();
        }

        this.mostrarLocalizacaoDados(classLocalizacao.latitude, classLocalizacao.longitude);

    }

    public void mostrarLocalizacaoDados(double latidude, double longitude) {
        TextView textloc = findViewById(R.id.txtvw_loc_perm);


        textloc.setText("Patterson te hackeou, você está seguro:" + "\n" + latidude + "\n" + longitude);

    }


}
*/
}