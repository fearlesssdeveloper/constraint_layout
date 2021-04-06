package br.com.alura.aluraviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.devolveDrawable
import br.com.alura.aluraviagens.extensions.formataDiasParaTexto
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.model.Pacote
import kotlinx.android.synthetic.main.activity_resumo_compra.*
import java.math.BigDecimal

class ResumoCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        title = "Resumo da compra"

        val pacoteSaoPaulo = Pacote("São Paulo", "sao_paulo_sp", 2, BigDecimal("244.99"))
        activity_resumo_compra_local_pacote.text = pacoteSaoPaulo.local
        activity_resumo_compra_imagem_pacote.setImageDrawable(pacoteSaoPaulo.imagem.devolveDrawable(this))
        activity_resumo_compra_data_viagem.text = pacoteSaoPaulo.dias.formataDiasParaTexto()
        activity_resumo_compra_preco_pacote.text = pacoteSaoPaulo.preco.formataParaBrasileiro()
    }
}