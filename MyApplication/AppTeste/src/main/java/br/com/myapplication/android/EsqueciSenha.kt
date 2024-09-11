package br.com.myapplication.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EsqueciSenha : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val buttonEnviar = findViewById<Button>(R.id.buttonResetPassword)
        val buttonVoltar = findViewById<TextView>(R.id.VoltaLogin)

        buttonEnviar.setOnClickListener {

            val toast = Toast.makeText(
                this,
                "Email enviado com sucesso",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
