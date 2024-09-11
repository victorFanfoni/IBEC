package br.com.myapplication.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val email = findViewById<EditText>(R.id.edit_email)
        val senha = findViewById<EditText>(R.id.edit_senha)
        val buttonLogin = findViewById<Button>(R.id.button_entrar)
        val buttonCriarConta = findViewById<TextView>(R.id.button_criar_conta)
        val butEsqueciSenha = findViewById<TextView>(R.id.textView4)

        buttonLogin.setOnClickListener {
            val emailText = email.text.toString()
            val senhaText = senha.text.toString()

            if (emailText.isEmpty() || senhaText.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(emailText, senhaText)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, navigate to Home activity
                        Log.d("Login", "signInWithEmail:success")
                        val intent = Intent(this, Home::class.java) // Ensure that Home activity exists
                        startActivity(intent)
                        finish()
                    } else {
                        // Sign in fails, display a message to the user.
                        Log.w("Login", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Autenticação falhou. Verifique suas credenciais.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        buttonCriarConta.setOnClickListener {
            val intent = Intent(this, CreateAcconte::class.java)
            startActivity(intent)
            finish()
        }

        butEsqueciSenha.setOnClickListener {
            val intent = Intent(this, EsqueciSenha::class.java)
            startActivity(intent)
            finish()
        }
    }
}
