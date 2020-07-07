package com.example.login_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;
    private FusedLocationProviderClient mFusedLocationClient;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location1 = new LatLng(35.1173707 , 129.0135435);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.title("부산국민체육센터");
        markerOptions1.snippet("체육센터");
        markerOptions1.position(location1);
        googleMap.addMarker(markerOptions1);

        LatLng location2 = new LatLng(35.0739274 , 129.0142455);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.title("송도스포츠센터");
        markerOptions2.snippet("체육센터");
        markerOptions2.position(location2);
        googleMap.addMarker(markerOptions2);

        LatLng location3 = new LatLng(35.1147662  , 129.029394);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.title("중구 웰빙체육관");
        markerOptions3.snippet("체육센터");
        markerOptions3.position(location3);
        googleMap.addMarker(markerOptions3);

        LatLng location4 = new LatLng(35.1035884  , 129.1057493);
        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.title("남구국민체육센터 ");
        markerOptions4.snippet("체육센터");
        markerOptions4.position(location4);
        googleMap.addMarker(markerOptions4);

        LatLng location5 = new LatLng(35.075622  , 129.063827);
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.title("영도구국민체육센터 ");
        markerOptions5.snippet("체육센터");
        markerOptions5.position(location5);
        googleMap.addMarker(markerOptions5);

        LatLng location6 = new LatLng(35.2061384  , 129.0336223);
        MarkerOptions markerOptions6 = new MarkerOptions();
        markerOptions6.title("백양 생활체육관");
        markerOptions6.snippet("체육센터");
        markerOptions6.position(location6);
        googleMap.addMarker(markerOptions6);

        LatLng location7 = new LatLng(35.2308018  , 129.0152346);
        MarkerOptions markerOptions7 = new MarkerOptions();
        markerOptions7.title("북구국민체육센터 ");
        markerOptions7.snippet("체육센터");
        markerOptions7.position(location7);
        googleMap.addMarker(markerOptions7);

        LatLng location8 = new LatLng(35.1946124  , 129.0554819);
        MarkerOptions markerOptions8 = new MarkerOptions();
        markerOptions8.title("부산시체육회관 ");
        markerOptions8.snippet("체육센터");
        markerOptions8.position(location8);
        googleMap.addMarker(markerOptions8);

        LatLng location9 = new LatLng(35.5005251  , 128.5590002);
        MarkerOptions markerOptions9 = new MarkerOptions();
        markerOptions9.title("올림픽기념 국민생활관");
        markerOptions9.snippet("체육센터");
        markerOptions9.position(location9);
        googleMap.addMarker(markerOptions9);

        LatLng location10 = new LatLng(35.180644  , 129.174249);
        MarkerOptions markerOptions10 = new MarkerOptions();
        markerOptions10.title("부산한마음스포츠센터 ");
        markerOptions10.snippet("체육센터");
        markerOptions10.position(location10);
        googleMap.addMarker(markerOptions10);

        LatLng location11 = new LatLng(35.0895093  , 128.9966447);
        MarkerOptions markerOptions11 = new MarkerOptions();
        markerOptions11.title("사하구국민체육센터 ");
        markerOptions11.snippet("체육센터");
        markerOptions11.position(location11);
        googleMap.addMarker(markerOptions11);

        LatLng location12 = new LatLng(35.2193914  , 129.0939866);
        MarkerOptions markerOptions12 = new MarkerOptions();
        markerOptions12.title("금정 구민체육관");
        markerOptions12.snippet("체육센터");
        markerOptions12.position(location12);
        googleMap.addMarker(markerOptions12);

        LatLng location13 = new LatLng(35.2435294  , 129.2062737);
        MarkerOptions markerOptions13 = new MarkerOptions();
        markerOptions13.title("기장생활체육공원 ");
        markerOptions13.snippet("체육센터");
        markerOptions13.position(location13);
        googleMap.addMarker(markerOptions13);

        LatLng location14 = new LatLng(35.3030436  , 129.2385553);
        MarkerOptions markerOptions14 = new MarkerOptions();
        markerOptions14.title("기장군국민체육센터 ");
        markerOptions14.snippet("체육센터");
        markerOptions14.position(location14);
        googleMap.addMarker(markerOptions14);

        LatLng location15 = new LatLng(35.1474038  , 128.9926109);
        MarkerOptions markerOptions15 = new MarkerOptions();
        markerOptions15.title("사상구국민체육센터 ");
        markerOptions15.snippet("체육센터");
        markerOptions15.position(location15);
        googleMap.addMarker(markerOptions15);

        LatLng location16 = new LatLng(35.1843684  , 129.0849523);
        MarkerOptions markerOptions16 = new MarkerOptions();
        markerOptions16.title("연제구 국민체육센터");
        markerOptions16.snippet("체육센터");
        markerOptions16.position(location16);
        googleMap.addMarker(markerOptions16);

        LatLng location17 = new LatLng(35.1804403  , 128.9550106);
        MarkerOptions markerOptions17 = new MarkerOptions();
        markerOptions17.title("강서브라이트센터 ");
        markerOptions17.snippet("체육센터");
        markerOptions17.position(location17);
        googleMap.addMarker(markerOptions17);

        LatLng location18 = new LatLng(35.1599412  , 129.1248148);
        MarkerOptions markerOptions18 = new MarkerOptions();
        markerOptions18.title("수영구민체육센터 ");
        markerOptions18.snippet("체육센터");
        markerOptions18.position(location18);
        googleMap.addMarker(markerOptions18);

        LatLng location19 = new LatLng(35.0904273  , 128.8974995);
        MarkerOptions markerOptions19 = new MarkerOptions();
        markerOptions19.title("명지레포츠센터 ");
        markerOptions19.snippet("체육센터");
        markerOptions19.position(location19);
        googleMap.addMarker(markerOptions19);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 16));
    }

    public void onLastLocationButtonClicked(View view) {
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(myLocation).title("현재 위치"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                }
            }
        });
    }
}