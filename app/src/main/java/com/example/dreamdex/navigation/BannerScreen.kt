package com.example.dreamdex.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dreamdex.R

@Composable
fun BannerScreen(navController: NavHostController) {
    val modifier = Modifier
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.banner_image), contentDescription = "",
            modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )
        Column(modifier.wrapContentHeight()
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(color = Color.White.copy(0.5f), RoundedCornerShape(20.dp))
            .border(0.5.dp, Color.White, RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val offset = Offset(10.0f, 10f)
            Text(
                text = "DreamDex",
                modifier.padding(vertical = 25.dp),
                //fontWeight = FontWeight.Thin,
                color = Color(0xFF00315D),
                style = TextStyle(
                    fontSize = 34.sp,
                    /*shadow = Shadow(
                        color = Color(0xFFFC5A03),
                        offset = offset, blurRadius = 3f
                    ),*/
                    fontFamily = FontFamily(Font(R.font.bubble_mint)),
                    textAlign = TextAlign.Center
                )
            )
            Button(onClick = { navController.navigate("Home Screen")}
                ,modifier.padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .background(color = Color.White.copy(0.8f), RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = "Browse", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF00315D),
                    fontFamily = FontFamily(Font(R.font.inter)),
                    textAlign = TextAlign.Center
                ))
            }
        }
    }
}