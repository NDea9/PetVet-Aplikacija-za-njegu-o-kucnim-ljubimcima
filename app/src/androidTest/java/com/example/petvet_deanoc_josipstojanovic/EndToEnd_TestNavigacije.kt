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
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import androidx.test.espresso.Espresso
import com.example.petvet_deanoc_josipstojanovic.data.Ljubimac



class EndToEnd_TestNavigacije{
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
    fun incijalniPocetnaSavjetovalisteDetalji(){
        //  nalazimo se na incijalnomScreenu
        //  navigacija sa incijalniScreen na pocetniScreen
        //  vrši se klik na "zapocnimo avanturu" Button sa psećim šapama
        composeTestRule.onNodeWithTag("testTag_IncijalniZaslon_startButton")
            .performClick()
        //  assertIsDisplayed se koristi da potvrdimo uspješnu navigaciju na pocetniScreen
        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_Logotip")
            .assertIsDisplayed()
            Thread.sleep(500)
        //  navigacija sa pocetniScreen na savjetovalisteScreen
        //  klik na prvi button u glavnom izborniku
        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_PrviNavigacijskiButton")
            .performClick()
        //  Provjera jesmo li se navigirali na savjetovalisteScreen?
        //  tako da provjerimo da li se kolumna prikazuje
        composeTestRule.onNodeWithTag("testTag_Savjetovaliste_Kolumna")
            .assertIsDisplayed()
            Thread.sleep(500)
        //  vracamo se na pocetniScreen (simulira back button pressed)
        Espresso.pressBack()
        //  klik na drugi button u izborniku - staniceScreen (str. sa google kartom)
        composeTestRule.onNodeWithTag("testTag_drugi_navigacijskiButton")
            .performClick()
        //  prikazuje li se naslov iznad karte?
        composeTestRule.onNodeWithTag("testTag_row_sa_kartom")
            .assertIsDisplayed()
            Thread.sleep(500)
        // Povratak na pocetni screen
        Espresso.pressBack()
        //  klik na treći button izbornika - Evidencija Ljubimaca
        composeTestRule.onNodeWithTag("testTag_treci_navigacijskiButton")
            .performClick()
        // Potvrđujemo sa assertIsDisplayed
        composeTestRule.onNodeWithText("Moji ljubimci: ")
            .assertIsDisplayed()
            Thread.sleep(500)
        // Povratak na pocetniScreen
        Espresso.pressBack()
        // vracamo se u savjetovalisteScreen da testiramo klik na svakog ljubimca
        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_PrviNavigacijskiButton")
            .performClick()
        // klikanje na svakog ljubimca prikazanog u savjetovalisteScreen
        // touch input simulira korisnikov scroll
        for (i in 0 until broj_zivotinja){
            composeTestRule.onNodeWithTag("testTag_LjubimacID_${i}", useUnmergedTree = true)
                .performClick()
            composeTestRule.onNodeWithTag("Slika_ljubimca_sa_ID_${i}", useUnmergedTree = true)
                .assertIsDisplayed()
            // nakon svakog otvaranja spava 0.5 sekunde
            // (da se lakse vidi sta se događa)
            Thread.sleep(400)
            Espresso.pressBack()
            // Touch Input - da bi se screen scrolao
            // ukoliko nešto nije vidljivo na screenu
            // test nije u mogućnosti interaktirati s tim elementom
            // mogli smo odabrati 5,6 ... bitno je da ima zaslona odozgo
            if(i == 4){
                composeTestRule.onNodeWithTag("testTag_LjubimacID_4", useUnmergedTree = true)
                    .performTouchInput {
                        down(center)
                        moveBy(Offset(viewConfiguration.touchSlop + 100, viewConfiguration.touchSlop - 1000))
                        up() }
            }
        }
        // Povratak na incijalni zaslon
        Espresso.pressBack()
        Espresso.pressBack()
        Thread.sleep(500)
    }
}
