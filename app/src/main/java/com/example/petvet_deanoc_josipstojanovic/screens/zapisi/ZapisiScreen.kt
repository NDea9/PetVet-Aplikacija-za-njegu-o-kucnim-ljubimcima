package com.example.petvet_deanoc_josipstojanovic.screens.zapisi


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import com.example.petvet_deanoc_josipstojanovic.R
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import com.example.petvet_deanoc_josipstojanovic.EvidencijaPreferencesDataStore
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac
import kotlinx.coroutines.launch


@Composable
fun ZapisiScreen() {

    Column {
        Row() {
            Text(text = "Sadržaj Zapisnika:",
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold
            )
        }

//        LazyColumn{
//            items(klju;evi){
//                   klju; ->
//
//           }}
    }
}

@Composable
@Preview
fun ZapisiScreenPreview() {
    ZapisiScreen()
}
