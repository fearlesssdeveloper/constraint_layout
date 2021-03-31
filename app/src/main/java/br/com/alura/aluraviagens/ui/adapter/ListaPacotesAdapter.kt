package br.com.alura.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.Pacote
import kotlinx.android.synthetic.main.item_pacote.view.*
import java.text.DecimalFormat
import java.util.*

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

        mostraLocal(viewCriada, pacote)
        mostraImagem(viewCriada, pacote)
        mostraDias(viewCriada, pacote)
        mostraPreco(viewCriada, pacote)

        return viewCriada
    }

    private fun mostraPreco(viewCriada: View, pacote: Pacote) {
        val preco = viewCriada.item_pacote_preco
        val formatoBrasileiro = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        val precoDoPacote = pacote.preco
        val moedaBrasileira = formatoBrasileiro.format(precoDoPacote)
        preco.text = moedaBrasileira
    }

    private fun mostraDias(viewCriada: View, pacote: Pacote) {
        val dias = viewCriada.item_pacote_dias
        val qtdDias = pacote.dias
        var diasEmTexto = ""
        diasEmTexto = if (qtdDias > 1) {
            "$qtdDias dias"
        } else {
            "$qtdDias dia"
        }
        dias.text = diasEmTexto
    }

    private fun mostraImagem(viewCriada: View, pacote: Pacote) {
        val imagem = viewCriada.item_pacote_imagem
        val resources = context.resources
        val idDoDrawable = resources.getIdentifier(pacote.imagem, "drawable", context.packageName)
        val drawableImagemPacote = resources.getDrawable(idDoDrawable)
        imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun mostraLocal(viewCriada: View, pacote: Pacote) {
        val local = viewCriada.item_pacote_local
        local.text = pacote.local
    }

}
