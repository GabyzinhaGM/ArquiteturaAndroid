package br.com.zup.movieflix.register.viewmodel

import android.app.Application
import androidx.lifecycle.*
import br.com.zup.movieflix.data.SingleLiveEvent
import br.com.zup.movieflix.data.model.MovieResult
import br.com.zup.movieflix.register.domain.RegisterUseCase
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository
import br.com.zup.movieflix.ui.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val registerUseCase: RegisterUseCase = RegisterUseCase(application)

    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    val response: LiveData<RegisterModel> = _response

    fun registerUser(user: RegisterModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    _response.value = registerUseCase.registerUser(user)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private val movieUseCase = RegisterUseCase(application)
    val movieListState = SingleLiveEvent<ViewState<List<MovieResult>>>()

    fun getAllMovies() {ssss
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    movieUseCase.getAllMoviesNetwork()
                }
                movieListState.value = response
            } catch (ex: Exception) {
                movieListState.value =
                    ViewState.Error(Throwable("Não foi possível carregar a lista vinda da internet!"))
            }
        }
}
