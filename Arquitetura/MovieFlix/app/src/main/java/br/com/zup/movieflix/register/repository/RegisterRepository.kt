package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.data.datasource.local.dao.RegisterDao
import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository(private val registerDao: RegisterDao) {

    fun registerUser(user: RegisterModel): RegisterModel {
        registerDao.registerUser(user)
        return user
    }
}
