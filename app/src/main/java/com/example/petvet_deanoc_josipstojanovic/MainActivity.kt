package com.example.petvet_deanoc_josipstojanovic

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph
import com.example.petvet_deanoc_josipstojanovic.screens.stanice.StaniceActivity



import androidx.activity.compose.setContent




class MainActivity : ComponentActivity() {

    val ljubimacViewModel: LjubimacViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        setContent {

            StaniceActivity()
            val navController = rememberNavController()

            NavGraph(navController = navController, viewModel = ljubimacViewModel)



        }
    }
}

private fun hasLocationPermission(context: Context): Boolean {
    val permission = Manifest.permission.ACCESS_FINE_LOCATION
    return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}

/*
package com.example.petvet_deanoc_josipstojanovic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph
import androidx.activity.viewModels
import androidx.compose.material3.Text
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel

class MainActivity : ComponentActivity() {
    val ljubimacViewModel: LjubimacViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController, viewModel = ljubimacViewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
*/