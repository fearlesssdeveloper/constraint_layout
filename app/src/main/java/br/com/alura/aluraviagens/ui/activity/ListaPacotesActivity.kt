package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.dao.PacoteDAO
import br.com.alura.aluraviagens.ui.activity.ConstantesActivities.Companion.TITULO_APPBAR
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter
import kotlinx.android.synthetic.main.activity_lista_pacotes.*

class ListaPacotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)
        title = TITULO_APPBAR

        configuraLista()

        val intent = Intent(this, ResumoPacoteActivity::class.java)
        startActivity(intent)
    }

    private fun configuraLista() {
        val pacotes = PacoteDAO().lista()
        val listaDePacotes = lista_pacotes_listview
        listaDePacotes.adapter = ListaPacotesAdapter(this, pacotes)
    }
}
