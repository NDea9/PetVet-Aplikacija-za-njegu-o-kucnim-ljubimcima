package com.example.petvet_deanoc_josipstojanovic.screens.savjetovaliste

//import com.example.petvet_deanoc_josipstojanovic.navigation.Screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petvet_deanoc_josipstojanovic.R
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens


@Composable
fun SavjetovalisteScreen(navController: NavController, viewModel: LjubimacViewModel) {

    //viewModel.populateDb()

    val zivi_podaci = viewModel.readAllData
    val lista_ljubimaca_objekata: List<Ljubimac> by zivi_podaci.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            ){
            Text(
                stringResource(id = R.string.naslov_1_savjetovaliste),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn{
            items(lista_ljubimaca_objekata){
                ljubimac -> prikazTransform(ljubimac, navController)

            }
        }
    }
}
@Composable
fun prikazTransform(item: Ljubimac, navController: NavController) {

    Button (
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(),
        modifier = Modifier.padding(5.dp),
        onClick = {
            navController.navigate(Screens.Detalji.route)
        }
            ){
        Row(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${item.ime}\nlat. ${item.imeLatinsko}",
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            )

            val context = LocalContext.current
            val slikaId = remember(item.urlSlika) {
                context.resources.getIdentifier(
                    item.urlSlika,
                    "drawable",
                    context.packageName
                )
            }

            Image(
                painterResource(id = slikaId) ,
                contentDescription = "Jedna od zivotinja",
                modifier = Modifier.size(width = 100.dp, height = 100.dp)
            )
        }

    }
}

@Composable
@Preview
fun SavjetovalisteScreenPreview() {
    //val navController = rememberNavController()
    //SavjetovalisteScreen(navController)
}
