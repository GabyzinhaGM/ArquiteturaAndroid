package br.com.zup.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.zup.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pref = getSharedPreferences("Shared_preference", Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val nome = pref.getString("NOMEPRODUTO", "")
        val quantidade = pref.getInt("QUANTIDADEPRODUTO", 0)

        binding.etNomeProduto.setText(nome)
        binding.etQuantidadeProduto.setText(quantidade)

        binding.btnSalvar.setOnClickListener {

            val nomeProduto = binding.etNomeProduto.text.toString()
            val quantidadeProduto = binding.etQuantidadeProduto.text.toString().toInt()
            prefEditor.putString("NOMEPRODUTO", nomeProduto)
            prefEditor.putInt("QUANTIDADEPRODUTO", quantidadeProduto)
            prefEditor.apply()

        }

    }
}