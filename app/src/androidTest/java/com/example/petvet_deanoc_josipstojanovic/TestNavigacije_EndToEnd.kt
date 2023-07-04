package com.example.petvet_deanoc_josipstojanovic



import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag

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


class TestNavigacije_EndToEnd{
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

        composeTestRule.onNodeWithTag("testTag_IncijalniZaslon_startButton")
            .performClick()
        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_Logotip")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_PrviNavigacijskiButton")
            .performClick()
        composeTestRule.onNodeWithTag("testTag_Savjetovaliste_Kolumna")
            .assertIsDisplayed()

        Espresso.pressBack()

        composeTestRule.onNodeWithTag("testTag_drugi_navigacijskiButton")
            .performClick()
        composeTestRule.onNodeWithTag("testTag_row_sa_kartom")
            .assertIsDisplayed()

        Espresso.pressBack()

        composeTestRule.onNodeWithTag("testTag_PocetniZaslon_PrviNavigacijskiButton")
            .performClick()

        // klikanje na svakog ljubimca
        for (i in 0 until broj_zivotinja){

            composeTestRule.onNodeWithTag("testTag_LjubimacID_${i}", useUnmergedTree = true)
                .performClick()
            composeTestRule.onNodeWithTag("Slika_ljubimca_sa_ID_${i}", useUnmergedTree = true)
                .assertIsDisplayed()

            Espresso.pressBack()
            //skrolanje da bi se ostali elementi pojavili na ekranu
            if(i == 4){
                composeTestRule.onNodeWithTag("testTag_LjubimacID_4", useUnmergedTree = true)
                    .performTouchInput {
                        down(center)
                        moveBy(Offset(viewConfiguration.touchSlop + 100, viewConfiguration.touchSlop - 1000))
                        up() }
            }
        }
        Espresso.pressBack()


    }

}
