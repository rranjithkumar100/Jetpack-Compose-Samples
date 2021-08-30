package net.jetpackcompose.composetext.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val SemiBlack = Color(0xFF242121)
val SemiWhite = Color(0xFFFAF6F6)
val graySurface = Color(0xFF202124)


val Colors.PageBackground: Color
    @Composable
    get() {
        return if (isLight)  Color.White
        else  Color.Black
    }