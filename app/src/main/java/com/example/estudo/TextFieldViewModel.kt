package com.example.estudo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TextFieldViewModel:ViewModel() {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    fun onTextChange(newText: String){
        _text.value = newText
    }
    fun clearText(){
        _text.value = ""
    }
}