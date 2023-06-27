package com.example.petvet_deanoc_josipstojanovic.screens.detalji

import android.icu.lang.UCharacter.NumericType
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.petvet_deanoc_josipstojanovic.R
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel

@Composable
fun DetaljiScreen(param: Int, viewModel: LjubimacViewModel) {
    val zivi_podaci = viewModel.readAllData
    val lista_ljubimaca_objekata: List<Ljubimac> by zivi_podaci.observeAsState(emptyList())

    var ljubimac: Ljubimac
    var slikaRes: String
    var opis: String
    var omiljena_hrana: String
    var dnevna_hrana: String
    var dnevna_voda: String
    var potreban_prostor: String
    var slikaId: Int = -1
    var myList: List<String> = emptyList()
    for (n in lista_ljubimaca_objekata){
        if (n.id == param){
             ljubimac = n
             slikaRes            = n.urlSlika
             opis                = n.detaljanOpis
             omiljena_hrana      = n.omiljenaHrana
             dnevna_hrana        = n.dnevnaHrana
             dnevna_voda         = n.dnevnaVoda
             potreban_prostor    = n.potrebanProstor

            //ZA prikaz slike trebam id
            val context = LocalContext.current
            slikaId = remember(ljubimac.urlSlika) {
                context.resources.getIdentifier(
                    ljubimac.urlSlika,
                    "drawable",
                    context.packageName
                )
            }
            myList = listOf("${slikaId}", "${opis}", "${omiljena_hrana}",
                                "${dnevna_hrana}", "${dnevna_voda}", "${potreban_prostor}")
            break
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        items(myList){
            polje ->
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if(isNumeric(polje)){
                        Image(
                            painterResource(id = slikaId) ,
                            contentDescription = "Jedna od zivotinja",
                            modifier = Modifier.size(width = 300.dp, height = 300.dp)
                        )
                    }
                    else{
                        Text(
                            text = "${polje}",
                            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        )
                    }
                }

        }
    }
}

fun isNumeric(input: String): Boolean {
    return input.matches("-?\\d+(\\.\\d+)?".toRegex())
}

@Composable
@Preview
fun DetaljiScreenPreview() {
    //DetaljiScreen()
}
