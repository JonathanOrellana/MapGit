package com.cdp.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Sv extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText Latitud,Longitud;
    GoogleMap Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);

        Latitud =findViewById(R.id.edtLatitud);
        Longitud=findViewById(R.id.edtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Map=googleMap;
        this.Map.setOnMapClickListener(this);
        this.Map.setOnMapLongClickListener(this);
        //

        LatLng ES = new LatLng(13.6914757,-89.250271412759);
        Map.addMarker(new MarkerOptions().position(ES).title("El Salvador"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(ES));
        //posicion inicial en el mapa cuando carga

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Latitud.setText(String.valueOf(latLng.latitude));
        Longitud.setText(String.valueOf(latLng.longitude));
        //genera a un solo click

        Map.clear();

        LatLng ES = new LatLng(latLng.latitude,latLng.longitude);
        Map.addMarker(new MarkerOptions().position(ES).title(""));
        Map.moveCamera(CameraUpdateFactory.newLatLng(ES));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        Latitud.setText(String.valueOf(latLng.latitude));
        Longitud.setText(String.valueOf(latLng.longitude));

        Map.clear();

        LatLng ES = new LatLng(latLng.latitude,latLng.longitude);
        Map.addMarker(new MarkerOptions().position(ES).title(""));
        Map.moveCamera(CameraUpdateFactory.newLatLng(ES));
    }
}