package com.example.petvet_deanoc_josipstojanovic

import android.app.Application
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.petvet_deanoc_josipstojanovic.data.LjubimacViewModel
import com.example.petvet_deanoc_josipstojanovic.navigation.NavGraph
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class EndToEndTest{
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        composeRule.activity.setContent{
            val context = LocalContext.current// or provide your application instance
            val ljubimacViewModel = LjubimacViewModel(application = Application())

            val navController = rememberNavController()
            NavGraph(navController = navController, viewModel = ljubimacViewModel)

        }
    }
    @Test
    fun testAppNavigationWorksProperly(){
        val context = composeRule.activity.applicationContext
        // Nalazimo se na pocetnom screenu aplikacije.
        // Dokazujemo da se naslov i 2 gumba prikazuju na ekranu.
        composeRule.onNodeWithText(context.getString(R.string.naslov_0))
            .assertIsDisplayed()
        composeRule.onNodeWithText(context.getString(R.string.gumb_1_savjetovaliste))
            .assertIsDisplayed()
        composeRule.onNodeWithText(context.getString(R.string.gumb_2_obliznje_stanice))
            .assertIsDisplayed()

        // pritiscemo prvi gumb da se navigiramo na savjetovaliste
        composeRule.onNodeWithText(context.getString(R.string.gumb_1_savjetovaliste))
            .performClick()

        // provjeravamo da li smo uspjesno navigirani tako da
        // provjerimo da li se naslov i gumb (sadrzaj) prikazuje.
        composeRule.onNodeWithText(context.getString(R.string.naslov_1_savjetovaliste))
            .assertIsDisplayed()
        composeRule.onNodeWithText(context.getString(R.string.gumb_2_obliznje_stanice))
            .assertIsDisplayed()

        // pritiscemo gumb da bi se navigirali na obliznje veterinarske stanice
        composeRule.onNodeWithText(context.getString(R.string.gumb_2_obliznje_stanice))
            .performClick()

        // provjeravamo da li se sadrzaj uspjesno prikazao.
        composeRule.onNodeWithText(context.getString(R.string.naslov_2_obliznje_stanice))
            .assertIsDisplayed()

    }
}
