package com.example.petvet_deanoc_josipstojanovic.screens.mojiljubimci

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MojiljubimciScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .testTag("testTag_Mojiljubimci_Kolumna"),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                //.fillMaxSize()
                .background(Color.Red),

        ){
            Text("Moji ljubimci: ",
                fontSize = MaterialTheme.typography.displayLarge.fontSize
            )



        }


    }
}

@Composable
@Preview
fun MojiljubimciScreenPreview() {
    //DetaljiScreen()
}


