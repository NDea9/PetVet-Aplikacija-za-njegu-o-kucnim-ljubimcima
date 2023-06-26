package com.example.petvet_deanoc_josipstojanovic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph
import androidx.activity.viewModels
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
