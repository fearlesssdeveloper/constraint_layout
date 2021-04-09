package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.devolveDrawable
import br.com.alura.aluraviagens.extensions.formataDiasParaTexto
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.extensions.periodoEmTexto
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.TITULO_APPBAR_RESUMO_PACOTE
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal

class ResumoPacoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = TITULO_APPBAR_RESUMO_PACOTE

        val dados = intent
        if (dados.hasExtra("pacote")){
            val pacote = dados.getParcelableExtra<Pacote>("pacote")!!
            mostraLocal(pacote)
            mostraImagem(pacote)
            mostraDias(pacote)
            mostraPreco(pacote)
            mostraData(pacote)

            resumo_pacote_botao_realiza_pagamento.setOnClickListener {
                val intent = Intent(this, PagamentoActivity::class.java)
                intent.putExtra("pacote", pacote)
                startActivity(intent)
            }
        }

    }

    private fun mostraData(pacote: Pacote) {
        val dataFormatadaDaViagem = pacote.dias.periodoEmTexto()
        resumo_pacote_data.text = dataFormatadaDaViagem
    }

    private fun mostraPreco(pacote: Pacote) {
        resumo_pacote_preco.text = pacote.preco.formataParaBrasileiro()
    }

    private fun mostraDias(pacote: Pacote) {
        resumo_pacote_dias.text = pacote.dias.formataDiasParaTexto()
    }

    private fun mostraImagem(pacote: Pacote) {
        resumo_pacote_imagem.setImageDrawable(pacote.imagem.devolveDrawable(this))
    }

    private fun mostraLocal(pacote: Pacote) {
        resumo_pacote_local.text = pacote.local
    }
}