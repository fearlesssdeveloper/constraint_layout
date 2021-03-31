package br.com.alura.aluraviagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.dao.PacoteDAO
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter
import kotlinx.android.synthetic.main.activity_lista_pacotes.*

class ListaPacotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)
        title = "Pacotes"
        val pacotes = PacoteDAO().lista()
        val listaDePacotes = lista_pacotes_listview
        listaDePacotes.adapter = ListaPacotesAdapter(this, pacotes)
    }
}
