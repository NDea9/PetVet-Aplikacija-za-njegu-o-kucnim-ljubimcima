package com.example.petvet_deanoc_josipstojanovic.navigation

import androidx.compose.runtime.Composable
//import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.screens.stanice.StaniceScreen
import com.example.petvet_deanoc_josipstojanovic.screens.savjetovaliste.SavjetovalisteScreen
import com.example.petvet_deanoc_josipstojanovic.screens.pocetna.PocetnaStranicaScreen
import com.example.petvet_deanoc_josipstojanovic.screens.detalji.DetaljiScreen
import com.example.petvet_deanoc_josipstojanovic.screens.incijalni.IncijalniScreen
import com.example.petvet_deanoc_josipstojanovic.screens.formaevidencijska.FormaEvidencijska
import com.example.petvet_deanoc_josipstojanovic.screens.zapisi.ZapisiScreen

@Composable
fun NavGraph (navController: NavHostController, viewModel: LjubimacViewModel){
    NavHost(
        navController = navController,
        startDestination = Screens.Incijalni.route//Screens.PocetnaStranica.route
    )
    {
        composable(route = Screens.PocetnaStranica.route){

            PocetnaStranicaScreen(navController)
        }

        composable(route = Screens.Savjetovaliste.route){
            SavjetovalisteScreen(navController, viewModel,
                onNavigateToDetaljiScreen = {
                navController.navigate("${Screens.Detalji.route}/$it")
            })

        }
        composable(route = Screens.Stanice.route){
            StaniceScreen()
        }
        composable(route = Screens.Incijalni.route){
            IncijalniScreen(navController)
        }
        composable(
            route = "${Screens.Detalji.route}/{my_param}",
            arguments = listOf(
                navArgument("my_param"){
                    type = NavType.IntType
                }
            )
        ){
            val param = it.arguments?.getInt("my_param") ?: -1
            DetaljiScreen(param = param, viewModel)
        }
        composable(route = Screens.FormaEvidencijska.route){
            FormaEvidencijska(navController)
        }
        composable(route = Screens.Zapisi.route){
            ZapisiScreen()
        }
    }
}
