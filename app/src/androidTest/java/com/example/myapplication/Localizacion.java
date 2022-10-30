package com.example.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Localizacion implements LocationListener {

    Mapa mapa;
    TextView tvMensaje;

    public Mapa getMapa(){
        return mapa;
    }

    public void setMapa(Mapa mapa, TextView tvMensaje){
        this.mapa = mapa;
        this.tvMensaje = tvMensaje;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //este metodo sirve para que el gps reciba nuevas coordenadas
        String texto = "Mi ubicacion es: \n"
                + "Latitud ="+ location.getLatitude() + "\n"
                + "Longitud ="+ location.getLongitude();

        tvMensaje.setText(texto);

        mapas(location.getLatitude(), location.getLongitude());
    }

    public void mapas(double lat, double lon){
        //fragment del mapa
        FragmentMaps fragment = new FragmentMaps();

        Bundle bundle = new Bundle();
        bundle.putDouble("lat", new Double(lat));
        bundle.putDouble("lon", new Double(lon));
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getMapa().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fragment, null);
        fragmentTransaction.commit();


    }
    public void onStatusChanged(String provider, int status, Bundle extras){
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug", "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }


    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
        tvMensaje.setText("GPS Activado");
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
        tvMensaje.setText("GPS Desactivado");
    }

}
