package com.example.petvet_deanoc_josipstojanovic.navigation

import androidx.compose.runtime.Composable
//import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.screens.stanice.StaniceScreen
import com.example.petvet_deanoc_josipstojanovic.screens.savjetovaliste.SavjetovalisteScreen
import com.example.petvet_deanoc_josipstojanovic.screens.pocetna.PocetnaStranicaScreen


@Composable
fun NavGraph (navController: NavHostController, viewModel: LjubimacViewModel){
    NavHost(
        navController = navController,
        startDestination = Screens.PocetnaStranica.route)
    {
        composable(route = Screens.PocetnaStranica.route){
            PocetnaStranicaScreen(navController)
        }
        composable(route = Screens.Savjetovaliste.route){
            SavjetovalisteScreen(navController, viewModel)
        }
        composable(route = Screens.Stanice.route){
            StaniceScreen()
        }
    }
}
