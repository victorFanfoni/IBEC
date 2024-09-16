package br.com.myapplication.android

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.myapplication.android.banco.DatabaseHelper

class BibliaActivity : AppCompatActivity() {

    private lateinit var textViewVerse: TextView
    private lateinit var spinnerBooks: Spinner
    private lateinit var spinnerChapters: Spinner
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button
    private lateinit var databaseHelper: DatabaseHelper

    private var currentBook = "Gênesis"
    private var currentChapter = 1
    private var currentVerse = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblia)

        textViewVerse = findViewById(R.id.textViewVerse)
        spinnerBooks = findViewById(R.id.spinnerBooks)
        spinnerChapters = findViewById(R.id.spinnerChapters)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)

        databaseHelper = DatabaseHelper(this)

        setupBookSpinner()
        setupListeners()

        updateChapters()
    }

    private fun setupBookSpinner() {
        val books = databaseHelper.getBooks()
        val bookAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, books)
        bookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBooks.adapter = bookAdapter

        spinnerBooks.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentBook = books[position]
                updateChapters()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupListeners() {
        spinnerChapters.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentChapter = position + 1
                currentVerse = 1
                updateVerse()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        buttonPrevious.setOnClickListener {
            if (currentVerse > 1) {
                currentVerse--
                updateVerse()
            }
        }

        buttonNext.setOnClickListener {
            currentVerse++
            updateVerse()
        }
    }

    private fun updateChapters() {
        val chapterList = databaseHelper.getChapters(currentBook)
        val chapterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, chapterList)
        chapterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerChapters.adapter = chapterAdapter
    }

    private fun updateVerse() {
        val verseText = "$currentBook $currentChapter:$currentVerse"
        textViewVerse.text = "Exibindo $verseText"
    }
}
