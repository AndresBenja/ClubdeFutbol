package com.example.clubdefutbol.views.fragmentos


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clubdefutbol.databinding.FragmentListadoJugadoresBinding
import com.example.clubdefutbol.models.ModeloJugadores
import com.example.clubdefutbol.views.activitys.AdaptadorJugadores
import java.lang.ClassCastException


class ListadoJugadoresFragment : Fragment() {

    private lateinit var binding: FragmentListadoJugadoresBinding
    private lateinit var dobleclick: ClubSelectListener

    interface ClubSelectListener {
        fun clubSelect (club: ModeloJugadores)

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
        val jugadoreslist = getFakeListado()
        //aqui se instancia osea se llama el adaptador
        val adaptadorJugadores = AdaptadorJugadores()
        val recicla = binding.recyclerViewclub
        //aqui le paso la lista que se invento
        adaptadorJugadores.jugadoreslist = jugadoreslist
        recicla.layoutManager = LinearLayoutManager(requireContext())
        recicla.adapter = adaptadorJugadores

        adaptadorJugadores.onItemClickListener = {
            dobleclick.clubSelect(it)

        }


    }

    fun getFakeListado(): MutableList<ModeloJugadores> {
        return mutableListOf(
            ModeloJugadores(
                id = "1",
                nombre = "Lionel Messi",
                posicion = "Delantero",
                camiseta = "10",
                club = "Paris Saint-Germain",
                foto = "https://media.admagazine.com/photos/637d11a6e63c8afac40e7a01/16:9/w_2560%2Cc_limit/1442809583",
                historia = "Considerado uno de los mejores futbolistas de todos los tiempos...",
                valor = "100000000"
            ),
            ModeloJugadores(
                id = "2",
                nombre = "Cristiano Ronaldo",
                posicion = "Delantero",
                camiseta = "7",
                club = "Manchester United",
                foto = "https://publish-p47754-e237306.adobeaemcloud.com/adobe/dynamicmedia/deliver/dm-aid--914bcfe0-f610-4610-a77e-6ea53c53f630/_330603286208.app.png?preferwebp=true&width=312",
                historia = "Conocido por su impresionante habilidad y dedicación...",
                valor = "90000000"
            ),
            ModeloJugadores(
                id = "3",
                nombre = "Neymar Jr",
                posicion = "Delantero",
                camiseta = "10",
                club = "Paris Saint-Germain",
                foto = "https://images.ecestaticos.com/f14xKs3Giq8RLAZrSE88WXPUMUc=/0x0:2272x1773/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2Fcf3%2F75d%2Fe27%2Fcf375de27bbcad55bfd6336472ce2c4f.jpg",
                historia = "Famoso por su creatividad y habilidad con el balón...",
                valor = "80000000"
            ),
            ModeloJugadores(
                id = "4",
                nombre = "Kylian Mbappé",
                posicion = "Delantero",
                camiseta = "7",
                club = "Paris Saint-Germain",
                foto = "https://s.hs-data.com/bilder/spieler/gross/284095.jpg",
                historia = "Joven talento con velocidad y técnica extraordinarias...",
                valor = "120000000"
            ),
            ModeloJugadores(
                id = "5",
                nombre = "Robert Lewandowski",
                posicion = "Delantero",
                camiseta = "9",
                club = "FC Barcelona",
                foto = "https://pbs.twimg.com/profile_images/1560186554781519873/wq6vdCir_400x400.jpg",
                historia = "Uno de los delanteros más prolíficos de su generación...",
                valor = "75000000"
            ),
            ModeloJugadores(
                id = "6",
                nombre = "Kevin De Bruyne",
                posicion = "Centrocampista",
                camiseta = "17",
                club = "Manchester City",
                foto = "https://www.mancity.com/meta/media/z00hnhu0/kevin-de-bruyne.png",
                historia = "Conocido por su visión y pases precisos...",
                valor = "85000000"
            ),
            ModeloJugadores(
                id = "7",
                nombre = "Luka Modric",
                posicion = "Centrocampista",
                camiseta = "10",
                club = "Real Madrid",
                foto = "https://publish-p47754-e237306.adobeaemcloud.com/adobe/dynamicmedia/deliver/dm-aid--323b5cf8-c89f-4158-addd-80b45571ff09/_383195890566.app.png?preferwebp=true&width=420",
                historia = "Uno de los centrocampistas más completos de su generación...",
                valor = "50000000"
            ),
            ModeloJugadores(
                id = "8",
                nombre = "Virgil van Dijk",
                posicion = "Defensa",
                camiseta = "4",
                club = "Liverpool",
                foto = "https://static.wikia.nocookie.net/liverpoolfc/images/6/65/VVD2023.jpeg/revision/latest?cb=20230828164014",
                historia = "Reconocido por su fortaleza y liderazgo en defensa...",
                valor = "70000000"
            ),
            ModeloJugadores(
                id = "9",
                nombre = "Sergio Ramos",
                posicion = "Defensa",
                camiseta = "4",
                club = "Paris Saint-Germain",
                foto = "https://publish-p47754-e237306.adobeaemcloud.com/adobe/dynamicmedia/deliver/dm-aid--288a5800-1fc0-46fc-a385-c1831ec1c73a/_330734572556.app.png?preferwebp=true&width=312",
                historia = "Conocido por su agresividad y habilidades defensivas...",
                valor = "45000000"
            ),
            ModeloJugadores(
                id = "10",
                nombre = "Alisson Becker",
                posicion = "Portero",
                camiseta = "1",
                club = "Liverpool",
                foto = "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/default/0002/25/thumb_124734_default_news_size_5.jpeg",
                historia = "Reconocido como uno de los mejores porteros del mundo...",
                valor = "65000000"
            ),
            ModeloJugadores(
                id = "11",
                nombre = "Jan Oblak",
                posicion = "Portero",
                camiseta = "13",
                club = "Atlético Madrid",
                foto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1BX9cXAMtXyz64vKrzXOERWpNBKbB7BCuAg&s",
                historia = "Destacado por sus impresionantes reflejos y paradas...",
                valor = "60000000"
            ),
            ModeloJugadores(
                id = "12",
                nombre = "Mohamed Salah",
                posicion = "Delantero",
                camiseta = "11",
                club = "Liverpool",
                foto = "https://backend.liverpoolfc.com/sites/default/files/styles/xs/public/2023-07/pp-23-24-mens-home-body-salah.webp?itok=hOje16Dr",
                historia = "Famoso por su velocidad y habilidad para marcar goles...",
                valor = "90000000"
            )
        )
    }
}

