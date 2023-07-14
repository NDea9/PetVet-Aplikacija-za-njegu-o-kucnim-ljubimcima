package com.example.petvet_deanoc_josipstojanovic.screens.mojiljubimci

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petvet_deanoc_josipstojanovic.EvidencijaDataStore
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MojiljubimciScreen() {


    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val dataStore = EvidencijaDataStore(context)

    val pohranjeniKljuč = dataStore.getKljuč.collectAsState(initial = "")
    val pohranjenoIme = dataStore.getIme.collectAsState(initial = "")
    val pohranjeniSpol = dataStore.getSpol.collectAsState(initial = "")
    val pohranjenaVrsta = dataStore.getVrsta.collectAsState(initial = "")
    val pohranjenaKilaža = dataStore.getKilaža.collectAsState(initial = "")
    val pohranjenaPrehrana = dataStore.getPrehrana.collectAsState(initial = "")
    var ključ by remember { mutableStateOf("") }
    var ime_lj by remember { mutableStateOf("") }
    var spol_lj by remember { mutableStateOf("") }
    var vrsta_lj by remember { mutableStateOf("") }
    var kilaža_lj by remember { mutableStateOf("") }
    var prehrana_lj by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            modifier = Modifier
                .padding(16.dp, top = 30.dp),
            text = "Šifra ljubimca",
            color = Color.Gray,
            fontSize = 18.sp
        )

        OutlinedTextField(//kilaži, konzumiranoj hrani, starosti, podrijetla, vlasnika i fotografija.
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = ključ,
            onValueChange = { ključ = it },
        )
        Text(
            modifier = Modifier
                .padding(16.dp, top = 16.dp),
            text = "Ime ljubimca",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = ime_lj,
            onValueChange = { ime_lj = it },
        )

        Text(
            modifier = Modifier
                .padding(16.dp, top = 16.dp),
            text = "Spol",
            color = Color.Gray,
            fontSize = 18.sp
        )
        //Prehrambene navike
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = spol_lj,
            onValueChange = { spol_lj = it },
        )
        Text(
            modifier = Modifier
                .padding(16.dp, top = 16.dp),
            text = "Pasmina (vrsta)",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = vrsta_lj,
            onValueChange = { vrsta_lj = it },
        )
        Text(
            modifier = Modifier
                .padding(16.dp, top = 16.dp),
            text = "Kilaža",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = kilaža_lj,
            onValueChange = { kilaža_lj = it },
        )
        Text(
            modifier = Modifier
                .padding(16.dp, top = 16.dp),
            text = "Prehrambene navike",
            color = Color.Gray,
            fontSize = 18.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = prehrana_lj,
            onValueChange = { prehrana_lj = it },
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(///////////////////////////////////////////////////////////////////////////////////
            text = "${pohranjeniKljuč.value!!} ${pohranjenoIme.value!!} ${pohranjeniSpol.value!!} ${pohranjenaVrsta.value!!} ${pohranjenaKilaža.value!!} ${pohranjenaPrehrana.value!!}",
            color = Color.Black,
            fontSize = 20.sp
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    dataStore.saveKljuč(ključ)
                    dataStore.saveIme(ime_lj)
                    dataStore.saveSpol(spol_lj)
                    dataStore.saveVrsta(vrsta_lj)
                    dataStore.saveKilaža(kilaža_lj)
                    dataStore.savePrehrana(prehrana_lj)
                }
            },
        ) {
            // button text
            Text(
                text = "Sačuvaj podatke",
                color = Color.White,
                fontSize = 18.sp
            )
        }


    }


}

@Composable
@Preview
fun MojiljubimciScreenPreview() {
    //DetaljiScreen()
}


