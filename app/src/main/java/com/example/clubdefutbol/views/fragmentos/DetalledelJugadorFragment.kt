package com.example.clubdefutbol.views.fragmentos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.clubdefutbol.databinding.FragmentDetalledelJugadorBinding
import com.squareup.picasso.Picasso

class DetalledelJugadorFragment : Fragment() {

    private lateinit var binding: FragmentDetalledelJugadorBinding

    private val args: DetalledelJugadorFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalledelJugadorBinding.inflate(inflater, container, false)
        val jugadores = args.jugadores
        binding.texnombreJ.text = jugadores?.nombre
        binding.texclubJ.text = jugadores?.club
        binding.texPosiJ.text = jugadores?.posicion
        binding.texcamisetaJ.text = jugadores?.camiseta
        binding.texIDJ.text = jugadores?.id
        binding.texHistoryJ.text = jugadores?.historia
        binding.texValorJ.text = jugadores?.valor
        binding.fotoUrl.setImageResource(0)

        //aqui le paso la Url que esta dentro del atributo perro o Dog y tambien la foto
        Picasso.get()
            .load(jugadores?.foto)
            .into(binding.fotoUrl)

        binding.btn1.setOnClickListener{
            sendEmailWithClubfutbol(jugadores?.nombre, jugadores?.id)

        }


        return binding.root

    }

    fun sendEmailWithClubfutbol(textnombreJ: String?, textIDJ: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abebello@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiero comprar un futbolista")
        intent.putExtra(
            Intent.EXTRA_TEXT, "Hola\n" +
                    "Vi el jugador ${textnombreJ} de código ${textIDJ} y me gustaría que me contactaran a este correo o al\n" +
                    "siguiente número ___\n" +
                    "Quedo atento."
        )
        val packageManager = requireContext().packageManager

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Enviar por correo"))
        } else {
            Toast.makeText(
                requireContext(),
                "Tienes que tener instalada una aplicación de correo",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}


