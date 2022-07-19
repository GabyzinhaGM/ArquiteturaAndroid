package br.com.zup.movieflix.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.home.view.HomeActivity
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel
import br.com.zup.movieflix.ui.ViewState

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()

        binding.bvLogin.setOnClickListener {
            registerUser()
            viewModel.getAllMovies()
        }
    }

    private fun observer() {
        viewModel.response.observe(this) {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        viewModel.movieListState.observe(this) {
            when (it) {
                is ViewState.Success -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Filmes ${it.data.size}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is ViewState.Error -> {

                }
            }
        }
    }

    private fun registerUser() {
        if (checkMatchingPasswords()) {
            viewModel.registerUser(
                RegisterModel(
                    1,
                    binding.etUserNameRegister.text.toString(),
                    binding.etEmailRegister.text.toString()
                )
            )
        } else {
            Toast.makeText(this, "Ops,as senhas precisam ser iguais", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkMatchingPasswords(): Boolean {
        return (binding.etPasswordRegister.text.toString() == binding.etConfirmPasswordRegister.text.toString())
    }
}