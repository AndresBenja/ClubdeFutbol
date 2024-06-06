package com.example.clubdefutbol.views.activitys

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.clubdefutbol.R
import com.example.clubdefutbol.models.ModeloJugadores
import com.example.clubdefutbol.views.fragmentos.ListadoJugadoresFragment
import com.example.clubdefutbol.views.fragmentos.ListadoJugadoresFragmentDirections

class MainActivity : AppCompatActivity(),ListadoJugadoresFragment.ClubSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun clubSelect(jugadores: ModeloJugadores) {
        findNavController(R.id.fragmentContainerView).navigate(ListadoJugadoresFragmentDirections.actionListadoJugadoresFragmentToDetalledelJugadorFragment(jugadores))
    }
}