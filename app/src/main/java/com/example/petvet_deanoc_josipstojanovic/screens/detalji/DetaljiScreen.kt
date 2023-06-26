package com.example.petvet_deanoc_josipstojanovic.screens.detalji

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.petvet_deanoc_josipstojanovic.R

@Composable
fun DetaljiScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),


    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Detaljnije o ...",
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
@Preview
fun DetaljiScreenPreview() {
    DetaljiScreen()
}
