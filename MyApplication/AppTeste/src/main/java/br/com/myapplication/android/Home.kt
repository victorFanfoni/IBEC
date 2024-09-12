package br.com.myapplication.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonHome = findViewById<ImageView>(R.id.buttonHome)
        val buttonNotifications = findViewById<ImageView>(R.id.buttonNotifications)
        val buttonBiblia = findViewById<Button>(R.id.buttonBili)
        val buttonPalavra = findViewById<Button>(R.id.buttonPalavra)
        val buttonAnotacoes = findViewById<Button>(R.id.buttonAnotacoes)
        val buttonOracoes = findViewById<Button>(R.id.buttonOracoes)
        val buttonDoacoes = findViewById<Button>(R.id.buttonDoacoes)
        val buttonInscricoes = findViewById<Button>(R.id.buttonInscricoes)
        val buttonAgenda = findViewById<Button>(R.id.buttonAgenda)
        val buttonEnvolva_se = findViewById<Button>(R.id.buttonEnvolva_se)
        val buttonAoVivo = findViewById<Button>(R.id.buttonAoVivo)


    }
}
