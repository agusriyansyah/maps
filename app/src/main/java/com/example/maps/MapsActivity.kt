package com.example.maps


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude  = -7.747034
        val longitude =110.355398
        val latKontrakan = -7.745852
        val longKontrakan = 110.358438
        val latBurjo =  -7.747923
        val longBurjo = 110.354297
        val zoomlevel =15f
        val overlaySize =110f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty)
            .title("Universitas Teknologi Yogyakarta")
            .snippet("-7.747034,110.355398")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))

        val kos = LatLng(latKontrakan,longKontrakan)
        mMap.addMarker(MarkerOptions().position(kos)
            .title("Kontrakan")
            .snippet("-7.745852/110.358438")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val burjo = LatLng(latBurjo,longBurjo)
        mMap.addMarker(MarkerOptions().position(burjo)
            .title("Burjo")
            .snippet("-7.747923/110.354297")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))

        val googleOverlay= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.uty))
            .position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay2= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.rumah))
            .position(kos,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)

        val googleOverlay3= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.burjo))
            .position(burjo,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)

    }

}
