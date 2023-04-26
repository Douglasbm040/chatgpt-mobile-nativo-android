package com.example.estudo

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Conversation(Messages:MutableList<Message>){
    LazyColumn(modifier = Modifier.fillMaxHeight(.9f)){
        items(Messages.size){
            message -> if (Messages[message].id == IsRecived) MessageCardRecive(Messages[message]) else MessageCard(message = Messages[message])
        }
    }

}