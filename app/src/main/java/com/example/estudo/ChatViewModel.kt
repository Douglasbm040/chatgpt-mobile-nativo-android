package com.example.estudo

import HttpUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.estudo.api.model.modelchatgpt
//import com.example.estudo.util.http
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

const val IsRecived: Boolean = true

class ChatViewModel: ViewModel() {
    val model = HttpUtil.apiService
    val Text = TextFieldViewModel()
    val ListMessage:MutableList<Message> = mutableListOf<Message>(
        Message("Use","ola", !IsRecived),
        Message("Chat GPT","e ai tudo nem mano ?", IsRecived)
    )


    private val _conversation = MutableStateFlow(ListMessage)// MutableStateFlow(ListMessage)
    val conversation: StateFlow<MutableList<Message>> = _conversation

    fun onConversationChange(newConversation: MutableList<Message>){
        _conversation.value = newConversation
    }

    fun onSend(newText: String) {
        _conversation.value.add(Message("android",newText, !IsRecived))

        /*thread {
            val text = model.ChatGpt(content = newText).body()
            _conversation.value.add(Message("android",text.toString(), IsRecived))
        }*/
    }
    fun re(va:String) {
        viewModelScope.launch {
            val complet = modelchatgpt(
                model = "text-davinci-003",
                prompt= va,
                max_tokens = 4000,
                0F
            )
            val a =  model.getcompletions(complet)
            a.code()
          return@launch
        }
    }

}