package br.com.alura.aluraviagens.extensions

fun Int.formataDiasParaTexto(): String {
    return if (this > 1) {
        "$this dias"
    } else {
        "$this dia"
    }
}