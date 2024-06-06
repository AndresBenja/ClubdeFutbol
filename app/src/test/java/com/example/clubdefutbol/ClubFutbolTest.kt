package com.example.clubdefutbol

import com.example.clubdefutbol.models.ModeloJugadores
import org.junit.Assert.assertEquals

import org.junit.Test

class ClubFutbolTest {

    lateinit var clubdefutbol: ModeloJugadores

    @Test
    fun testearcreaciondeljugador (){
        clubdefutbol= ModeloJugadores(
            id = "1",
            nombre = "Lionel Messi",
            posicion = "Delantero",
            camiseta = "10",
            club = "Paris Saint-Germain",
            foto = "https://media.admagazine.com/photos/637d11a6e63c8afac40e7a01/16:9/w_2560%2Cc_limit/1442809583",
            historia = "Considerado uno de los mejores futbolistas de todos los tiempos...",
            valor = "100.000.000"
        )
        assertEquals("1",clubdefutbol.id)
        assertEquals("Lionel Messi",clubdefutbol.nombre)
        assertEquals("Delantero", clubdefutbol.posicion)
        assertEquals("10",clubdefutbol.camiseta)
        assertEquals("Paris Saint-Germain", clubdefutbol.club)
        assertEquals("https://media.admagazine.com/photos/637d11a6e63c8afac40e7a01/16:9/w_2560%2Cc_limit/1442809583",clubdefutbol.foto)
        assertEquals("Considerado uno de los mejores futbolistas de todos los tiempos...",clubdefutbol.historia)
        assertEquals("100.000.000",clubdefutbol.valor)

    }




}