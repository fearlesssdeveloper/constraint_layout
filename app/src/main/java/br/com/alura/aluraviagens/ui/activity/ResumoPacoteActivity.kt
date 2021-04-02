package br.com.alura.aluraviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.extensions.devolveDrawable
import br.com.alura.aluraviagens.extensions.formataDiasParaTexto
import br.com.alura.aluraviagens.extensions.formataParaBrasileiro
import br.com.alura.aluraviagens.model.Pacote
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = "Resumo do pacote"
        val pacoteSaoPaulo = Pacote("São Paulo", "sao_paulo_sp", 2, BigDecimal("244.99"))
        resumo_pacote_local.text = pacoteSaoPaulo.local
        resumo_pacote_imagem.setImageDrawable(pacoteSaoPaulo.imagem.devolveDrawable(this))
        resumo_pacote_dias.text = pacoteSaoPaulo.dias.formataDiasParaTexto()
        resumo_pacote_preco.text = pacoteSaoPaulo.preco.formataParaBrasileiro()
        val dataIda = Calendar.getInstance()
        val dataVolta = Calendar.getInstance()
        dataVolta.add(Calendar.DATE, pacoteSaoPaulo.dias)
        val formatoBrasileiro = SimpleDateFormat("dd/MM")
        val dataFormatadaIda = formatoBrasileiro.format(dataIda.time)
        val dataFormatadaVolta = formatoBrasileiro.format(dataVolta.time)
        val dataFormatadaDaViagem = "$dataFormatadaIda - $dataFormatadaVolta de ${dataFormatadaVolta[Calendar.YEAR]}"
        resumo_pacote_data.text = dataFormatadaDaViagem
    }
}