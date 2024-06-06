package com.example.clubdefutbol.views.activitys


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clubdefutbol.databinding.ItemdetallejugadoresBinding
import com.example.clubdefutbol.models.ModeloJugadores
import com.squareup.picasso.Picasso

//aqui se crea una lista o colecciones
class AdaptadorJugadores:RecyclerView.Adapter <AdaptadorJugadores.ViewHolder>() {
    //esta es una funcion que no devuelve nada va a detectar el click
    lateinit var onItemClickListener:(ModeloJugadores) ->Unit

    //aqui se declara
    var jugadoreslist= mutableListOf<ModeloJugadores>()
        //aqui se llena la lista
        set(value) {
            field=value
            this.notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorJugadores.ViewHolder {
        //aqui se crea el binding para poder pintar la fila conexion del xml con el code
        val binding=ItemdetallejugadoresBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AdaptadorJugadores.ViewHolder, position: Int) {
        //Aqui envio la posicion del perro u objeto del listado
        val jugadores:ModeloJugadores=jugadoreslist[position]
        holder.binjugadores(jugadores)
    }

    override fun getItemCount(): Int {
        //aqui se devuelve el tamaño de la lista
        return jugadoreslist.size
    }
    //un adaptador siempre va acompañado de un viewholder
    //se declara una clase y se crea dentro un viewHolder y le pasamos el bindig
    inner class ViewHolder(private val binding: ItemdetallejugadoresBinding):RecyclerView.ViewHolder(binding.root){
        //aqui se hace referncia al XML para pintar
        fun binjugadores(jugadores:ModeloJugadores) {
            //aqui se hace la referencia al binding de el xml
            binding.idjugador.text=jugadores.id
            binding.nombrejugador.text= jugadores.nombre
            binding.equipojugador.text= jugadores.club
            //se limpia el fondo por defecto
            binding.fotojugadorURL.setImageResource(0)

            //aqui le paso la Url que esta dentro del atributo perro o Dog y tambien la foto
            Picasso.get()
                .load(jugadores.foto)
                .into(binding.fotojugadorURL)
            //quiero que toda la fila sea clickeable
            binding.root.setOnClickListener{
                //si la funcion esta inicializada
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(jugadores)

            }


        }
    }

}