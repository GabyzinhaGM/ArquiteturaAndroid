package br.com.zup.movieflix

import  br.com.zup.movieflix.register.repositorio.RegisterRepository
import  br.com.zup.movieflix.register.model.RegisterModel
import org.junit.Test
import org.junit.Assert.*

class RegisterUnitTest {
    @Test
    fun validateRegisterModel_shouldReturn_pastProperties() {
        val user = RegisterModel(userName = "Felipe", email = "felipe.dearaujo@zup.com.br", password = "melhorProfessorDoMundo")
        val repository = RegisterRepository()

        assertEquals(user, repository.registerUser(user))
    }


}