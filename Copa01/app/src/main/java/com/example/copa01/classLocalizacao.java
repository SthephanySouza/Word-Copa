package com.example.copa01;

import android.location.Location;
import android.location.LocationListener;

public class classLocalizacao implements LocationListener{

    public static double latitude;
    public static double longitude;

    @Override
    public void onLocationChanged(Location location){
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();


    }
}
