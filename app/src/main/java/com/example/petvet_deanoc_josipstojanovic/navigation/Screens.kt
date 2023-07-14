package com.example.petvet_deanoc_josipstojanovic.navigation


sealed class Screens(val route: String) {
    object PocetnaStranica: Screens("pocetnaStranica_screen")
    object Savjetovaliste: Screens("savjetovaliste_screen")
    object Stanice: Screens("stanice_screen")
    object Detalji: Screens("detalji_screen")
    object Incijalni: Screens("incijalni_screen")

    object FormaEvidencijska: Screens("mojiljubimci_screen")
    object Zapisi: Screens("zapisi_screen")
}
