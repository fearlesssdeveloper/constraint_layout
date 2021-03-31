package br.com.alura.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.Pacote
import kotlinx.android.synthetic.main.item_pacote.view.*

class ListaPacotesAdapter(private val context: Context, private val pacotes: List<Pacote>) : BaseAdapter() {
    override fun getCount(): Int {
        return pacotes.size
    }

    override fun getItem(posicao: Int): Pacote {
        return pacotes[posicao]
    }

    override fun getItemId(posicao: Int): Long {
        return 0
    }

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false)
        val pacote = pacotes[posicao]
        val local = viewCriada.item_pacote_local
        local.text = pacote.local
        val imagem = viewCriada.item_pacote_imagem
        val resources = context.resources
        val idDoDrawable = resources.getIdentifier(pacote.imagem, "drawable", context.packageName)
        val drawableImagemPacote = resources.getDrawable(idDoDrawable)
        imagem.setImageDrawable(drawableImagemPacote)
        val dias = viewCriada.item_pacote_dias
        dias.text = "${pacote.dias} dias"
        val preco = viewCriada.item_pacote_preco
        preco.text = pacote.preco.toString()
        return viewCriada
    }

}
