package com.example.estudo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldMessage(text:String, onTextChange: (String) -> Unit, onSend: (String) -> Unit , onclear: ()-> Unit){
    Surface(color = Color.Transparent, modifier = Modifier
        .fillMaxWidth(1f)
        .height(100.dp)
    ){
        Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .clip(CircleShape)
            ) {
                Row(
                    //horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(Icons.Filled.Face, contentDescription = "face", Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    TextField(
                        modifier = Modifier.width(250.dp),
                        value = text,
                        onValueChange = onTextChange,
                        placeholder = { Text(text = "Digite sua mensagem ...") },
                    )
                    /* Spacer(modifier = Modifier.width(6.dp))
                     Icon(Icons.Filled.Add, contentDescription = "face", Modifier.size(20.dp))
                     */Spacer(modifier = Modifier.width(6.dp))
                    Icon(Icons.Filled.Call, contentDescription = "face", Modifier.size(20.dp))
                    /*Spacer(modifier = Modifier.width(6.dp))
                    Icon(Icons.Filled.ThumbUp, contentDescription = "face", Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))*/
                }

            }

            Surface(modifier = Modifier.clip(CircleShape)) {
                IconButton(
                    onClick = {
                        onSend(text)
                        onclear()
                      },
                    ) {
                    Icon(
                        Icons.Filled.Send, contentDescription = "face",
                        /*Modifier
                            .size(10.dp)
                            .padding(15.dp),*/
                    )
                }
            }

        }
    }
}
