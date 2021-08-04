package net.jetpackcompose.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Box

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.jetpackcompose.composetext.ui.theme.ComposeTextTheme

class ModifierSamplesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ModifierSample()
                }
            }
        }
    }

}

@Composable
fun ModifierSample() {
    Column {
        TextWidthPadding()
        TextWithSize()
        AlphaSample()
    }
}

@Preview
@Composable
fun ModifierPreview() {
    ComposeTextTheme {
        ModifierSample()
    }
}

@Composable
fun TextWidthPadding(){
    Text(
        "Hello, World!",
        Modifier
            .padding(16.dp) // Outer padding; (For AndroidDev -> It's Margin)
            .background(color = Color.Green) // Solid element background color

            .padding(16.dp) // Inner padding; inside background, around text

    )
}

@Composable
fun TextWithSize(){
    Text(
        text = "Text with Size",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            .padding(Dp(10f))
            .size(
                width = Dp(250f), height = Dp(150f)
            )
    )
}
@Composable
fun AlphaSample() {
    Box(
        Modifier
            .size(150.dp)
            .alpha(0.1f)
            .background(Color.Red)
            .animateContentSize()

    )
}