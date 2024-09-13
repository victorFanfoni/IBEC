package br.com.myapplication.android

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BibliaActivity : AppCompatActivity() {

    private lateinit var textViewVerse: TextView
    private lateinit var spinnerBooks: Spinner
    private lateinit var spinnerChapters: Spinner
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button

    // Lista completa de livros da Bíblia
    private val books = listOf(
        "Gênesis", "Êxodo", "Levítico", "Números", "Deuteronômio",
        "Josué", "Juízes", "Rute", "1 Samuel", "2 Samuel",
        "1 Reis", "2 Reis", "1 Crônicas", "2 Crônicas", "Esdras",
        "Neemias", "Ester", "Jó", "Salmos", "Provérbios", "Eclesiastes", "Cantares", "Isaías",
        "Jeremias", "Lamentações", "Ezequiel", "Daniel", "Oséias", "Joel", "Amós",
        "Obadias", "Jonas", "Miquéias", "Naum", "Habacuque", "Sofonias",
        "Ageu", "Zacarias", "Malaquias", "Mateus", "Marcos", "Lucas", "João",
        "Atos", "Romanos", "1 Coríntios", "2 Coríntios", "Gálatas", "Efésios",
        "Filipenses", "Colossenses", "1 Tessalonicenses", "2 Tessalonicenses",
        "1 Timóteo", "2 Timóteo", "Tito", "Filemom", "Hebreus", "Tiago",
        "1 Pedro", "2 Pedro", "1 João", "2 João", "3 João", "Judas", "Apocalipse"
    )

    private val chapters = mapOf(
        "Gênesis" to (1..50).map { "Capítulo $it" },
        "Êxodo" to (1..40).map { "Capítulo $it" },
        "Levítico" to (1..27).map { "Capítulo $it" },
        "Números" to (1..36).map { "Capítulo $it" },
        "Deuteronômio" to (1..34).map { "Capítulo $it" },
        "Josué" to (1..24).map { "Capítulo $it" },
        "Juízes" to (1..21).map { "Capítulo $it" },
        "Rute" to (1..4).map { "Capítulo $it" },
        "1 Samuel" to (1..31).map { "Capítulo $it" },
        "2 Samuel" to (1..24).map { "Capítulo $it" },
        "1 Reis" to (1..22).map { "Capítulo $it" },
        "2 Reis" to (1..25).map { "Capítulo $it" },
        "1 Crônicas" to (1..29).map { "Capítulo $it" },
        "2 Crônicas" to (1..36).map { "Capítulo $it" },
        "Esdras" to (1..10).map { "Capítulo $it" },
        "Neemias" to (1..13).map { "Capítulo $it" },
        "Ester" to (1..10).map { "Capítulo $it" },
        "Jó" to (1..42).map { "Capítulo $it" },
        "Salmos" to (1..150).map { "Capítulo $it" },
        "Provérbios" to (1..31).map { "Capítulo $it" },
        "Eclesiastes" to (1..12).map { "Capítulo $it" },
        "Cantares" to (1..8).map { "Capítulo $it" },
        "Isaías" to (1..66).map { "Capítulo $it" },
        "Jeremias" to (1..52).map { "Capítulo $it" },
        "Lamentações" to (1..5).map { "Capítulo $it" },
        "Ezequiel" to (1..48).map { "Capítulo $it" },
        "Daniel" to (1..12).map { "Capítulo $it" },
        "Oséias" to (1..14).map { "Capítulo $it" },
        "Joel" to (1..3).map { "Capítulo $it" },
        "Amós" to (1..9).map { "Capítulo $it" },
        "Obadias" to (1..1).map { "Capítulo $it" },
        "Jonas" to (1..4).map { "Capítulo $it" },
        "Miquéias" to (1..7).map { "Capítulo $it" },
        "Naum" to (1..3).map { "Capítulo $it" },
        "Habacuque" to (1..3).map { "Capítulo $it" },
        "Sofonias" to (1..3).map { "Capítulo $it" },
        "Ageu" to (1..2).map { "Capítulo $it" },
        "Zacarias" to (1..14).map { "Capítulo $it" },
        "Malaquias" to (1..4).map { "Capítulo $it" },
        "Mateus" to (1..28).map { "Capítulo $it" },
        "Marcos" to (1..16).map { "Capítulo $it" },
        "Lucas" to (1..24).map { "Capítulo $it" },
        "João" to (1..21).map { "Capítulo $it" },
        "Atos" to (1..28).map { "Capítulo $it" },
        "Romanos" to (1..16).map { "Capítulo $it" },
        "1 Coríntios" to (1..16).map { "Capítulo $it" },
        "2 Coríntios" to (1..13).map { "Capítulo $it" },
        "Gálatas" to (1..6).map { "Capítulo $it" },
        "Efésios" to (1..6).map { "Capítulo $it" },
        "Filipenses" to (1..4).map { "Capítulo $it" },
        "Colossenses" to (1..4).map { "Capítulo $it" },
        "1 Tessalonicenses" to (1..5).map { "Capítulo $it" },
        "2 Tessalonicenses" to (1..3).map { "Capítulo $it" },
        "1 Timóteo" to (1..6).map { "Capítulo $it" },
        "2 Timóteo" to (1..4).map { "Capítulo $it" },
        "Tito" to (1..3).map { "Capítulo $it" },
        "Filemom" to (1..1).map { "Capítulo $it" },
        "Hebreus" to (1..13).map { "Capítulo $it" },
        "Tiago" to (1..5).map { "Capítulo $it" },
        "1 Pedro" to (1..5).map { "Capítulo $it" },
        "2 Pedro" to (1..3).map { "Capítulo $it" },
        "1 João" to (1..5).map { "Capítulo $it" },
        "2 João" to (1..1).map { "Capítulo $it" },
        "3 João" to (1..1).map { "Capítulo $it" },
        "Judas" to (1..1).map { "Capítulo $it" },
        "Apocalipse" to (1..22).map { "Capítulo $it" }
    )


    // Controles para o livro, capítulo e versículo atual
    private var currentBook = "Gênesis"
    private var currentChapter = 1
    private var currentVerse = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblia)

        // Inicializar os componentes da interface
        textViewVerse = findViewById(R.id.textViewVerse)
        spinnerBooks = findViewById(R.id.spinnerBooks)
        spinnerChapters = findViewById(R.id.spinnerChapters)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)

        // Configurar os adaptadores dos Spinners
        setupBookSpinner()
        setupListeners()

        // Atualiza o spinner de capítulos quando o livro é alterado
        updateChapters()
    }

    private fun setupBookSpinner() {
        val bookAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, books)
        bookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBooks.adapter = bookAdapter
    }

    private fun setupListeners() {
        // Quando um livro é selecionado
        spinnerBooks.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentBook = books[position]
                updateChapters()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Quando um capítulo é selecionado
        spinnerChapters.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentChapter = position + 1
                currentVerse = 1
                updateVerse()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Navegar para o versículo anterior
        buttonPrevious.setOnClickListener {
            if (currentVerse > 1) {
                currentVerse--
                updateVerse()
            }
        }

        // Navegar para o próximo versículo
        buttonNext.setOnClickListener {
            currentVerse++
            updateVerse()
        }
    }

    private fun updateChapters() {
        val chapterList = chapters[currentBook] ?: emptyList()
        val chapterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, chapterList)
        chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerChapters.adapter = chapterAdapter
    }

    private fun updateVerse() {
        // Atualiza o TextView com o versículo atual
        val verseText = "$currentBook $currentChapter:$currentVerse"
        textViewVerse.text = "Exibindo $verseText"
    }
}
