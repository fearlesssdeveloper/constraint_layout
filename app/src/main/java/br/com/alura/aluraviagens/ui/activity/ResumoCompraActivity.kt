package br.com.alura.aluraviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.devolveDrawable
import br.com.alura.aluraviagens.extensions.formataDiasParaTexto
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.TITULO_APPBAR_RESUMO_COMPRA
import kotlinx.android.synthetic.main.activity_resumo_compra.*
import java.math.BigDecimal

class ResumoCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        title = TITULO_APPBAR_RESUMO_COMPRA

        val dados = intent
        if (dados.hasExtra("pacote")) {
            val pacote = dados.getParcelableExtra<Pacote>("pacote")!!

            mostraLocal(pacote)
            mostraImagem(pacote)
            mostraData(pacote)
            mostraPreco(pacote)
        }

    }

    private fun mostraPreco(pacote: Pacote) {
        activity_resumo_compra_preco_pacote.text = pacote.preco.formataParaBrasileiro()
    }

    private fun mostraData(pacote: Pacote) {
        activity_resumo_compra_data_viagem.text = pacote.dias.formataDiasParaTexto()
    }

    private fun mostraImagem(pacote: Pacote) {
        activity_resumo_compra_imagem_pacote.setImageDrawable(
            pacote.imagem.devolveDrawable(
                this
            )
        )
    }

    private fun mostraLocal(pacote: Pacote) {
        activity_resumo_compra_local_pacote.text = pacote.local
    }
}