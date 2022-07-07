package br.com.zup.movieflix.register.domain

import android.app.Application
import br.com.zup.movieflix.data.datasource.RegisterDatabase
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterUseCase(application: Application) {

    private val registerDao = RegisterDatabase.getDatabase(application).registerDao()
    private val repository: RegisterRepository = RegisterRepository(registerDao)

    fun registerUser(user: RegisterModel): RegisterModel {
        repository.registerUser(user)
        return user
    }
}
