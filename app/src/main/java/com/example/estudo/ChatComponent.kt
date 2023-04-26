package com.example.estudo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import com.example.estudo.ui.theme.EstudoTheme
import kotlinx.coroutines.flow.onSubscription

@Composable
fun ChatComponent(viewModelText: TextFieldViewModel , viewModelChat: ChatViewModel) {
    val text: String by viewModelText.text.observeAsState("")
    val Mensagens: MutableList<Message> by  viewModelChat.conversation.collectAsState()


    EstudoTheme {
        Surface(color = Color.White){
            Column() {
                TopAppBarSample()
                Conversation(Mensagens)
                FieldMessage(text, onTextChange = {viewModelText.onTextChange(it)} , onSend = { viewModelChat.onSend(text) } , onclear = {viewModelText.clearText()})
            }
        }
    }
}