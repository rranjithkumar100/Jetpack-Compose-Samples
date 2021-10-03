package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ActivityGradient : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientRootView()
        }
    }
}

@Composable
fun GradientRootView(){
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalGradient()
        HorizontalGradient2()
        VerticalGradient()
        LinearGradient()
        RadialGradientSample()
        SweepGradient()
    }
}

@Composable
fun HorizontalGradient(){
  val horizontal=  Brush.horizontalGradient(
        listOf(Color.Red, Color.Green, Color.Blue),
        startX = 0.0f,
        endX = 120.0f,
      //tileMode = TileMode.Mirror
    )
    Box(modifier = Modifier
        .size(120.dp)
        .background(horizontal))
}


@Composable
fun HorizontalGradient2(){
  val horizontal=  Brush.horizontalGradient(
      0.33f to Color.Red,
      0.66f to Color.Green,
      0.9f to Color.Blue,
        startX = 0.0f,
        endX = 120.0f,
      //tileMode = TileMode.Mirror
    )
    Box(modifier = Modifier
        .size(120.dp)
        .background(horizontal))
}

@Composable
fun RadialGradientSample(){
    // Create a radial gradient centered about the drawing area that is green on
    // the outer
    // edge of the circle and magenta towards the center of the circle
    val radial = Brush.radialGradient(listOf(Color.Green, Color.Magenta))
    Box(modifier = Modifier.size(120.dp).background(radial))
}

@Composable
fun VerticalGradient(){
    val vertical=  Brush.verticalGradient(
        listOf(Color.LightGray, Color.DarkGray, Color.Black),
        startY = 0.0f,
        endY = 120.0f,
        //tileMode = TileMode.Mirror
    )
    Box(modifier = Modifier
        .size(120.dp)
        .background(vertical))
}

@Composable
fun LinearGradient(){
    // Create a linear gradient that shows red in the top left corner
    // and blue in the bottom right corner
    val linear = Brush.linearGradient(listOf(Color.Red, Color.Blue))
    Box(modifier = Modifier
        .size(120.dp)
        .background(linear))
}

@Composable
fun SweepGradient(){
    // Create a radial gradient centered about the drawing area that is green on
    // the outer
    // edge of the circle and magenta towards the center of the circle
    val sweep = Brush.sweepGradient(listOf(Color.Cyan, Color.Magenta))
    Box(modifier = Modifier.size(120.dp).background(sweep))
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GradientPreview(){
    GradientRootView()
}