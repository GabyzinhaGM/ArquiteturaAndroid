package br.com.zup.movieflix

import  br.com.zup.movieflix.register.repository.RegisterRepository
import  br.com.zup.movieflix.register.model.RegisterModel
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegisterUnitTest {
    @Test
    fun validateRegisterModel_shouldReturn_pastProperties() {
        val user = RegisterModel()
        assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue()
    }


}