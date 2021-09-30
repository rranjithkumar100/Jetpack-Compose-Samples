package net.jetpackcompose.composetext.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.R


val NexaFont = FontFamily(Font(R.font.nexa_regular), Font(R.font.nexa_bold,FontWeight.Bold))

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = FontFamily.Serif,
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = NexaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = NexaFont,
        fontSize = 20.sp,
    )

)

val Typography.customTitle: TextStyle
    @Composable
    get() {
        return  TextStyle(
                fontFamily = NexaFont,
                fontSize = 30.sp
        )
    }
