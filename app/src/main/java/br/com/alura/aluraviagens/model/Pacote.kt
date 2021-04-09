package br.com.alura.aluraviagens.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
class Pacote(val local: String, val imagem: String, val dias: Int, val preco: BigDecimal) : Parcelable