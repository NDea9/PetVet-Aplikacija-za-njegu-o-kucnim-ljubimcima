package com.example.petvet_deanoc_josipstojanovic.screens.incijalni

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import com.example.petvet_deanoc_josipstojanovic.R
import androidx.compose.material.icons.*
import androidx.compose.ui.platform.testTag


@Composable
fun IncijalniScreen(navController: NavController) {
    Column(

    ) {
        Row{
            Image(
                painterResource(id = R.drawable.logo) ,
                contentDescription = "Greeting photo",
                modifier = Modifier.size(width = 400.dp, height = 400.dp)
                      .testTag("testTag_IncijalniZaslon_Logotip")
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(onClick = {navController.navigate(Screens.PocetnaStranica.route)},
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .testTag("testTag_IncijalniZaslon_startButton"),


            )
            {
                Column(
                  horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                    painterResource(id = R.drawable.sape) ,
                    contentDescription = "Jedna od zivotinja",
                    modifier = Modifier.size(width = 200.dp, height = 200.dp)
                )
                    Text("Započni avanturu",
                        fontFamily = FontFamily.Cursive,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize
                    )
                    /*Text(
                        stringResource(id = R.string.naslov_0),
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,

                        )*/
                }

            }

        }
        

    }
}

@Composable
@Preview
fun IncijalniScreenPreview() {
    val navController = rememberNavController()
    IncijalniScreen(navController)
}
