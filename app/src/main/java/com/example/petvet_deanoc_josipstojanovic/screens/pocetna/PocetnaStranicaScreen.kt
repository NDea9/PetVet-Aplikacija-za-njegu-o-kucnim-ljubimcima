package com.example.petvet_deanoc_josipstojanovic.screens.pocetna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import com.example.petvet_deanoc_josipstojanovic.R

@Composable
fun PocetnaStranicaScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(id = R.string.naslov_0),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(5.dp),
                onClick = {
                    navController.navigate(Screens.Savjetovaliste.route)
                }
            ) {
                Text(
                    stringResource(id = R.string.gumb_1_savjetovaliste),
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(5.dp),
                onClick = {
                    //TODO: Navigate to Home Screen
                    navController.navigate(Screens.Stanice.route)
                }
            ){
                Text(
                    stringResource(id = R.string.gumb_2_obliznje_stanice),
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
@Preview
fun PocetnaStranicaScreenPreview() {
    val navController = rememberNavController()
    PocetnaStranicaScreen(navController)
}
