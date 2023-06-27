package com.example.petvet_deanoc_josipstojanovic.screens.pocetna

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
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

    ) {
        Row{
            Image(
                painterResource(id = R.drawable.logo) ,
                contentDescription = "Greeting photo",
                modifier = Modifier.size(width = 500.dp, height = 300.dp)
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
                    text = "Upoznajte raznolike vrste ljubimaca",
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold
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
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                modifier = Modifier.padding(5.dp),
                onClick = {

                    navController.navigate(Screens.Stanice.route)
                }
            ){
                Text(
                    text = "Pretražite veterinarske stanice",
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold
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
