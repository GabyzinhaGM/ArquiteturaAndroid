package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    private var user: RegisterModel = RegisterModel("", "")

    fun registerUser(user: RegisterModel): RegisterModel {
        this.user = user
        return user
    }
}
