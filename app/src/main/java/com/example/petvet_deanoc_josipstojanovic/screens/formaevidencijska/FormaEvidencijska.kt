package com.example.petvet_deanoc_josipstojanovic.screens.formaevidencijska

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.petvet_deanoc_josipstojanovic.EvidencijaPreferencesDataStore
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import kotlinx.coroutines.launch




@Composable
fun PreferencesItem(preferences: Preferences) {
    val nameKey = stringPreferencesKey("ime")
    val name: String? = preferences[nameKey]
    // Use the name variable or other preferences as needed
    // For example:
    Text(text = name ?: "Default value")
    // Add more composables as needed to display the preferences
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormaEvidencijska(navController: NavController) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = EvidencijaPreferencesDataStore(context)

    val stanje = dataStore.vratiSveZapiseEvidencie.collectAsState(initial = emptyPreferences())
    val prefovi = stanje.value

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
        LazyColumn {
            //preferencesIte
        }

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ){

            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = Modifier
                    .padding(5.dp)
                    .testTag("testTag_treci_navigacijskiButton"),
                onClick = {
                    navController.navigate(Screens.Zapisi.route)

                }
            ){
                Text(
                    text = "Dodaj novi",
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }


    }


}

@Composable
@Preview
fun Screens.FormaEvidencijskaPreview() {
    //DetaljiScreen()
}


