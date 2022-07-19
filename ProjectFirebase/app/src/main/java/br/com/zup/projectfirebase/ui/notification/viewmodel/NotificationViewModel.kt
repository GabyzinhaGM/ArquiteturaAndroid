package br.com.zup.projectfirebase.ui.notification.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import  br.com.zup.projectfirebase.domain.model.Message


class NotificationViewModel : ViewModel() {
    private val _notification = MutableLiveData<Message>()
    val notification = _notification


}

