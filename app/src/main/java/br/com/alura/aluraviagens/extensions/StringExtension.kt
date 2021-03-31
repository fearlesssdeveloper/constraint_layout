package br.com.alura.aluraviagens.extensions

import android.content.Context
import android.graphics.drawable.Drawable

fun String.devolveDrawable(context: Context): Drawable {
    val resources = context.resources
    val idDoDrawable = resources.getIdentifier(this, "drawable", context.packageName)
    return resources.getDrawable(idDoDrawable)
}