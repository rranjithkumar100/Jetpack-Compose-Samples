package net.jetpackcompose.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

//        BackgroundColor()
        //WidthAndHeightModifier()
        //TextWidthPadding()
     //   SizeModifier()
       //AlphaModifier()
      //FillWidthModifier()
       //FillHeightModifier()
        //FillSizeModifier()
        RotateModifier()
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
fun BackgroundColor() {
    Text(
        text = "Text with Size",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            .padding(Dp(10f))
    )
}


@Composable
fun TextWidthPadding() {
    Text(
        "Padding and margin!",
        Modifier
            .padding(32.dp) // Outer padding; (For AndroidDev -> It's Margin)
            .background(color = Color.Green) // Solid element background color
            .padding(16.dp) // Inner padding; inside background, around text
    )
}


@Composable
fun SizeModifier() {
    Text(
        text = "Text with Size",
        color = Color.White,
        modifier = Modifier
            .background(Color.Cyan)
            .size(width = 250.dp, height = 100.dp)
    )
}

@Composable
fun WidthAndHeightModifier() {
    Text(
        text = "Width and Height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            .width(200.dp)
            .height(300.dp)
    )
}

@Composable
fun FillWidthModifier() {
    Text(
        text = "Text Width Match Parent",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .padding(Dp(10f))
            .fillMaxWidth(1f)
            .padding(Dp(10f))
    )
}

@Composable
fun FillHeightModifier() {
    Text(
        text = " Text with 75% Height ",
        color = Color.White,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.75f)
    )
}

@Composable
fun FillSizeModifier() {
    Text(
        text = " Text with Fill Size (Height and Width) ",
        color = Color.White,
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxSize()
    )
}

@Composable
fun AlphaModifier() {
    Box(
        Modifier
            .size(250.dp)
            .alpha(0.5f)
            .background(Color.Red)
    )
}

@Composable
fun RotateModifier() {
    Box(
        Modifier
            .rotate(45f)
            .size(250.dp)
            .background(Color.Red)
    )
}

@Composable
fun ScaleModifier() {
    Box(
        Modifier
            .scale(scaleX = 2f, scaleY = 3f)
            .size(200.dp, 200.dp)
    )
}