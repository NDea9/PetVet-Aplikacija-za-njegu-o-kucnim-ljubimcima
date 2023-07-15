//API TomTom= lRJkA5RQVOFnf9G4AEuSp8KSANhHJILZ

package com.example.petvet_deanoc_josipstojanovic.screens.stanice


import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.petvet_deanoc_josipstojanovic.R
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker




class StaniceActivity : ComponentActivity() {
    //private val locationPermissionRequestCode = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StaniceScreen()
        }
    }
}
@Composable
fun StaniceScreen() {
    val context = LocalContext.current
    val locationPermissionRequestCode = remember { 100 }

    val mapView = rememberMapView()



    Box(
        contentAlignment = Alignment.Center
    ) {
        if (hasLocationPermission(context)) {
            AndroidView(factory = { mapView })
        } else {
            Button(onClick = { requestLocationPermission(context, locationPermissionRequestCode) }) {
                Text(text = "Request Location Permission")
            }
        }
    }

    setupMapView(mapView, context)

}

@Composable
fun rememberMapView(): MapView {
    val context = LocalContext.current
    return remember {
        Configuration.getInstance().load(context, androidx.preference.PreferenceManager.getDefaultSharedPreferences(context))
        val mapView = MapView(context)
        mapView.setTileSource(TileSourceFactory.MAPNIK)  //Ovdje mjenjam kartu: DEFAULT_TILE_SOURCE
        mapView
    }
}

private fun requestLocationPermission(context: Context, requestCode: Int) {
    ActivityCompat.requestPermissions(
        context as Activity,
        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
        requestCode
    )
}





private fun hasLocationPermission(context: Context): Boolean {
    val permission = Manifest.permission.ACCESS_FINE_LOCATION
    return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}

private fun setupMapView(mapView: MapView, context: Context) {
    Configuration.getInstance().load(context, androidx.preference.PreferenceManager.getDefaultSharedPreferences(context))
    mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)

    // Set user's location (Rijeka, Croatia)
    val userLocation = GeoPoint(45.3271, 14.4422)
    mapView.controller.setCenter(userLocation)
    mapView.controller.setZoom(12.0)

    addMarker(mapView, context, "Vet Clinic 1", 45.321, 14.441)
    addMarker(mapView, context, "Vet Clinic 2", 45.322, 14.442)
    addMarker(mapView, context, "Vet Clinic 3", 45.323, 14.443)
    addMarker(mapView, context, "Park 1", 45.324, 14.444)
    addMarker(mapView, context, "Park 2", 45.325, 14.445)
    addMarker(mapView, context, "Park 3", 45.326, 14.446)

}

private fun addMarker(mapView: MapView, context: Context, title: String, latitude: Double, longitude: Double) {
    val marker = Marker(mapView)
    marker.position = GeoPoint(latitude, longitude)
    marker.title = title
    marker.icon = ContextCompat.getDrawable(context, R.drawable.ic_marker)
    marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
    mapView.overlays.add(marker)
}




