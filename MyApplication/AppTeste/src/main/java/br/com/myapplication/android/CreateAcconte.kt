package br.com.myapplication.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAccount : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acconte)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val nome = findViewById<EditText>(R.id.edit_nome)
        val email = findViewById<EditText>(R.id.edit_email)
        val senha = findViewById<EditText>(R.id.edit_senha)
        val confirmarSenha = findViewById<EditText>(R.id.edit_confirm_senha)
        val celular = findViewById<EditText>(R.id.edit_celular)
        val dataNascimento = findViewById<EditText>(R.id.edit_data_nascimento)
        val igreja = findViewById<EditText>(R.id.edit_igreja)
        val spinnerGenero = findViewById<Spinner>(R.id.spinner_genero)
        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)
        val voltarLogin = findViewById<TextView>(R.id.btn_voltar)

        buttonCriarConta.setOnClickListener {
            val nomeText = nome.text.toString().trim()
            val emailText = email.text.toString().trim()
            val senhaText = senha.text.toString().trim()
            val confirmarSenhaText = confirmarSenha.text.toString().trim()
            val celularText = celular.text.toString().trim()
            val dataNascimentoText = dataNascimento.text.toString().trim()
            val igrejaText = igreja.text.toString().trim()
            val generoSelecionado = spinnerGenero.selectedItem?.toString() ?: "Não selecionado"

            when {
                nomeText.isEmpty() || emailText.isEmpty() || senhaText.isEmpty() ||
                        confirmarSenhaText.isEmpty() || celularText.isEmpty() || dataNascimentoText.isEmpty() ||
                        igrejaText.isEmpty() -> {
                    showToast("Por favor, preencha todos os campos.")
                }
                senhaText != confirmarSenhaText -> {
                    showToast("As senhas não coincidem.")
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches() -> {
                    showToast("Por favor, insira um e-mail válido.")
                }
                generoSelecionado == "Não selecionado" -> {
                    showToast("Por favor, selecione um gênero.")
                }
                else -> {
                    auth.createUserWithEmailAndPassword(emailText, senhaText)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "createUserWithEmail:success")
                                // Navegar para a tela de login após a criação da conta
                                startActivity(Intent(this, Login::class.java))
                                finish()
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                showToast("Erro ao criar conta: ${task.exception?.message}")
                            }
                        }
                }
            }
        }

        voltarLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "CreateAccountActivity"
    }
}
