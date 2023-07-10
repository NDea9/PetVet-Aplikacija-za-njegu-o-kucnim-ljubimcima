package com.example.petvet_deanoc_josipstojanovic


import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.Espresso
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph
import com.example.petvet_deanoc_josipstojanovic.navigation.Screens
import com.example.petvet_deanoc_josipstojanovic.screens.savjetovaliste.SavjetovalisteScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UnitTest_prikazuje_li_se_stanice_i_MojiLJubimci {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController
    private var broj_zivotinja = 0
    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            val ljubimacViewModel: LjubimacViewModel

            ljubimacViewModel = viewModel(LjubimacViewModel::class.java)
            val zivi_podaci = ljubimacViewModel.readAllData
            val lista_ljubimaca_objekata: List<Ljubimac> by zivi_podaci.observeAsState(emptyList())
            broj_zivotinja = lista_ljubimaca_objekata.size

            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavGraph(navController = navController, viewModel = ljubimacViewModel)

        }
    }
    @Test
    // testiramo savjetovaliste i detetaljiScreen
    fun test_SavjetovalisteScreen_DetaljiScreen(){
        composeTestRule.onNodeWithTag("testTag_IncijalniZaslon_startButton")
            .performClick()
        composeTestRule.onNodeWithTag("testTag_drugi_navigacijskiButton")
            .performClick()
        // Prikazuje li se karta ispravno
        composeTestRule.onNodeWithTag("testTag_row_sa_kartom")
            .assertIsDisplayed()
        Espresso.pressBack()
        composeTestRule.onNodeWithTag("testTag_treci_navigacijskiButton")
            .performClick()
        // prikazuje li se MojiLjubimciScreenIspravno
        composeTestRule.onNodeWithText("Moji ljubimci: ")
            .assertIsDisplayed()
   }

}