package br.com.myapplication.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {

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
        val buttonEnvolvaSe = findViewById<Button>(R.id.buttonEnvolva_se)
        val buttonAoVivo = findViewById<Button>(R.id.buttonAoVivo)

        buttonHome.setOnClickListener {
            Toast.makeText(
                this,
                "Botao Home clicado",
                Toast.
                LENGTH_SHORT
            ).show()
        }

        buttonNotifications.setOnClickListener {
            Toast.makeText(
                this,
                "Botao notificacoes clicado",
                Toast.
                LENGTH_SHORT
            ).show()
        }

        buttonBiblia.setOnClickListener {
            val intent = Intent(this, BibliaActivity::class.java)
            startActivity(intent)
        }

        buttonPalavra.setOnClickListener {
            

        }

        buttonAnotacoes.setOnClickListener {
            Toast.makeText(
                this,
                "Botao anotacoes clicado",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonOracoes.setOnClickListener {
            Toast.makeText(
                this,
                "Botao oracoes clicado",
                Toast.LENGTH_SHORT
            ).show()

        }

        buttonDoacoes.setOnClickListener {
            Toast.makeText(
                this,
                "Botao doacoes clicado",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonInscricoes.setOnClickListener {
            Toast.makeText(
                this,
                "Botao inscricoes clicado",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonAgenda.setOnClickListener {
            Toast.makeText(
                this,
                "Botao agenda clicado",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonEnvolvaSe.setOnClickListener {
            Toast.makeText(
                this,
                "Botao envolva-se clicado",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonAoVivo.setOnClickListener {
            Toast.makeText(
                this,
                "Botao ao vivo clicado",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
