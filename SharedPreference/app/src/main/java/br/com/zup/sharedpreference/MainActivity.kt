package br.com.zup.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var pref: SharedPreferences
    lateinit var prefEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        iniciarPrefs()

        recuperarPrefs()

        binding.btnSalvar.setOnClickListener {
            salvarPrefs()
        }

    }

    private fun iniciarPrefs() {
        pref = getSharedPreferences("Shared", Context.MODE_PRIVATE)
        prefEditor = pref.edit()

    }

    private fun recuperarPrefs() {

        val nome = pref.getString("NOMEPRODUTO", "")
        val quantidade = pref.getInt("QUANTIDADEPRODUTO", 0)

        binding.etNomeProduto.setText(nome)
        binding.etQuantidadeProduto.setText(quantidade)

    }

    private fun salvarPrefs() {

        val nomeProduto = binding.etNomeProduto.text.toString()
        val quantidadeProduto = binding.etQuantidadeProduto.text.toString().toInt()
        prefEditor.putString("NOMEPRODUTO", nomeProduto)
        prefEditor.putInt("QUANTIDADEPRODUTO", quantidadeProduto)
        prefEditor.apply()

    }

}

