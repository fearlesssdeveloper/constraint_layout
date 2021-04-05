package br.com.alura.aluraviagens.extensions

import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.DIA_E_MES
import java.text.SimpleDateFormat
import java.util.*

fun Int.formataDiasParaTexto(): String {
    return if (this > 1) {
        "$this dias"
    } else {
        "$this dia"
    }
}

fun Int.periodoEmTexto(): String {
    val dataIda = Calendar.getInstance()
    val dataVolta = Calendar.getInstance()
    dataVolta.add(Calendar.DATE, this)
    val formatoBrasileiro = SimpleDateFormat(DIA_E_MES)
    val dataFormatadaIda = formatoBrasileiro.format(dataIda.time)
    val dataFormatadaVolta = formatoBrasileiro.format(dataVolta.time)
    return "$dataFormatadaIda - $dataFormatadaVolta de ${dataFormatadaVolta[Calendar.YEAR]}"
}