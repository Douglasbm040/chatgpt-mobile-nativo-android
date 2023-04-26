package com.example.estudo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MessageCard(message: Message) {
    Row (
        Modifier
            .padding(all = 3.dp)
            .fillMaxWidth(.7f),
        verticalAlignment = Alignment.CenterVertically
    ){

        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.anonimo),
            contentDescription = "contact",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color(37, 211, 102), CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = message.auth)
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp, color = Color(18, 140 ,126)) {
                Text(text = message.body,modifier = Modifier.padding(8.dp), color = Color.White)
            }
        }
    }


}