package com.example.petvet_deanoc_josipstojanovic.screens.savjetovaliste

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
//import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import com.example.petvet_deanoc_josipstojanovic.R
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac


@Composable
fun SavjetovalisteScreen(navController: NavController, viewModel: LjubimacViewModel) {

    val zivi_podaci = viewModel.readAllData
    val lista_ljubimaca_objekata: List<Ljubimac> by zivi_podaci.observeAsState(emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
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
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = stringResource(id = R.string.slika_sa_psom)
        )
        Text("${R.drawable.dog}")
        LazyColumn{
            items(lista_ljubimaca_objekata){
                ljubimac -> prikazTransform(ljubimac)

            }
        }
    }
}

@Composable
fun prikazTransform(item: Ljubimac) {
    Row {
        Text("${item.ime}  lat. ${item.imeLatinsko}")

    }
}

@Composable
fun prikazSlikeTransform() {
    // Call the AsyncImage composable or any other image component here

}
@Composable
@Preview
fun SavjetovalisteScreenPreview() {
    val navController = rememberNavController()
    //SavjetovalisteScreen(navController)
}
