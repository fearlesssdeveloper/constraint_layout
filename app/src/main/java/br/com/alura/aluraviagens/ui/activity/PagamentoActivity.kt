package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.CHAVE_PACOTE
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.TITULO_APPBAR_PAGAMENTO
import kotlinx.android.synthetic.main.activity_pagamento.*
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        title = TITULO_APPBAR_PAGAMENTO

        carregaPacoteRecebido()

    }

    private fun carregaPacoteRecebido() {
        val dados = intent
        if (dados.hasExtra(CHAVE_PACOTE)) {
            val pacote = dados.getParcelableExtra<Pacote>(CHAVE_PACOTE)!!

            mostraPreco(pacote)

            configuraBotao(pacote)
        }
    }

    private fun configuraBotao(pacote: Pacote) {
        activity_pagamento_botao_finaliza_compra.setOnClickListener {
            vaiParaResumoCompra(pacote)
        }
    }

    private fun vaiParaResumoCompra(pacote: Pacote) {
        val intent = Intent(this, ResumoCompraActivity::class.java)
        intent.putExtra(CHAVE_PACOTE, pacote)
        startActivity(intent)
    }

    private fun mostraPreco(pacote: Pacote) {
        val moedaBrasileira = pacote.preco.formataParaBrasileiro()
        activity_pagamento_preco_pacote.text = moedaBrasileira
    }
}