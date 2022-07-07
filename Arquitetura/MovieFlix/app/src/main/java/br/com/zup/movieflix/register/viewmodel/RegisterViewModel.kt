package br.com.zup.movieflix.register.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.register.domain.RegisterUseCase
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel(application: Application) : ViewModel() {

    private val registerUseCase: RegisterUseCase = RegisterUseCase(application)

    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    val response: LiveData<RegisterModel> = _response

    fun registerUser(user: RegisterModel) {
        try {
            _response.value = registerUseCase.registerUser(user)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
