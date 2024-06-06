package com.example.clubdefutbol.views.fragmentos


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clubdefutbol.databinding.FragmentListadoJugadoresBinding
import com.example.clubdefutbol.models.ModeloJugadores
import com.example.clubdefutbol.viewmodels.ClubdeFutbolViewModel
import com.example.clubdefutbol.views.activitys.AdaptadorJugadores
import java.lang.ClassCastException


class ListadoJugadoresFragment : Fragment() {

    private lateinit var binding: FragmentListadoJugadoresBinding
    private lateinit var dobleclick: ClubSelectListener
    private lateinit var listadoViewModel: ClubdeFutbolViewModel

    interface ClubSelectListener {
        fun clubSelect(club: ModeloJugadores)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dobleclick = try {
            context as ClubSelectListener

        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement selectListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoJugadoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val jugadoreslist = getFakeListado()

        //llamar a la variable ViewModel con el ViewModel Provider
        listadoViewModel= ViewModelProvider(this).get(ClubdeFutbolViewModel::class.java)

        //aqui se instancia osea se llama el adaptador
        val adaptadorJugadores = AdaptadorJugadores()
        val recicla = binding.recyclerViewclub

        listadoViewModel.clubdefutbol_ld.observe(viewLifecycleOwner) {


            //aqui le paso la lista que se invento

            adaptadorJugadores.jugadoreslist = it
            recicla.layoutManager = LinearLayoutManager(requireContext())
            recicla.adapter = adaptadorJugadores
        }
        adaptadorJugadores.onItemClickListener = {
            dobleclick.clubSelect(it)

        }


    }

}

