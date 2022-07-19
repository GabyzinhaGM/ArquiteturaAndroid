package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.data.datasource.local.dao.RegisterDao
import br.com.zup.movieflix.data.datasource.remote.RetrofitService
import br.com.zup.movieflix.data.model.MovieResponse
import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository(private val registerDao: RegisterDao) {

    fun registerUser(user: RegisterModel): RegisterModel {
        registerDao.registerUser(user)
        return user
    }

    suspend fun getAllMovies () : MovieResponse {
        return RetrofitService.apiService.getAllMovies()
    }
}
