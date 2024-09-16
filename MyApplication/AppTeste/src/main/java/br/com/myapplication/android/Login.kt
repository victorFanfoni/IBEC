package br.com.myapplication.android

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var isPasswordVisible = false // Flag to check password visibility

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
        val eyeIcon = findViewById<ImageView>(R.id.eye_icon) // Eye icon view

        // Toggle password visibility
        eyeIcon.setOnClickListener {
            if (isPasswordVisible) {
                // Hide password
                senha.transformationMethod = PasswordTransformationMethod.getInstance()
                eyeIcon.setImageResource(R.drawable.ic_eye_open) // Change icon to "eye open"
            } else {
                // Show password
                senha.transformationMethod = HideReturnsTransformationMethod.getInstance()
                eyeIcon.setImageResource(R.drawable.ic_eye_closed) // Change icon to "eye closed"
            }
            isPasswordVisible = !isPasswordVisible

            // Move cursor to the end of the text
            senha.setSelection(senha.text.length)
        }

        // Login button functionality
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
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Autenticação falhou. Verifique suas credenciais.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        // Create account button functionality
        buttonCriarConta.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
            finish()
        }

        // Forgot password button functionality
        butEsqueciSenha.setOnClickListener {
            val intent = Intent(this, EsqueciSenha::class.java)
            startActivity(intent)
            finish()
        }
    }
}
