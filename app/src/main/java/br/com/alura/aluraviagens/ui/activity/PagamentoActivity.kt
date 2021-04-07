package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.TITULO_APPBAR_PAGAMENTO
import kotlinx.android.synthetic.main.activity_pagamento.*
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        title = TITULO_APPBAR_PAGAMENTO
        val pacoteSaoPaulo = Pacote("São Paulo", "sao_paulo_sp", 2, BigDecimal("244.99"))
        mostraPreco(pacoteSaoPaulo)

        activity_pagamento_botao_finaliza_compra.setOnClickListener {
            val intent = Intent(this, ResumoCompraActivity::class.java)
            startActivity(intent)
        }
    }

    private fun mostraPreco(pacote: Pacote) {
        val moedaBrasileira = pacote.preco.formataParaBrasileiro()
        activity_pagamento_preco_pacote.text = moedaBrasileira
    }
}