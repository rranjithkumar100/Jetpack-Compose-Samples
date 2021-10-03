package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ActivityProgressIndicator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressBarRootView()
        }
    }

    @Composable
    private fun ProgressBarRootView() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Linear Progress Indicator",modifier = Modifier.padding(10.dp), style = MaterialTheme.typography.h5)
            LinearProgressIndicator()
            LinearProgressIndicator(0.7f)
            CustomLinearProgressBar()

            Text(text = "Circular Progress Indicator",modifier = Modifier.padding(10.dp), style = MaterialTheme.typography.h5)
            CircularProgressIndicator()
            CircularProgressIndicator(progress = 0.75f)
            CircularProgressAnimated()
            CustomCircularProgressBar()

        }
    }


    @Composable
    private fun CustomLinearProgressBar(){
        Column(modifier = Modifier.fillMaxWidth()) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp),
                backgroundColor = Color.LightGray,
                color = Color.Red)
        }
    }

    //Indeterminate (Infinity)
    @Composable
    private fun CustomCircularProgressBar(){
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = Color.Green,
                strokeWidth = 10.dp)

    }


    //Determinate (based on input)
    @Composable
    private fun CircularProgressAnimated(){
        val progressValue = 0.75f
        val infiniteTransition = rememberInfiniteTransition()

        val progressAnimationValue by infiniteTransition.animateFloat(
            initialValue = 0.0f,
            targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)))

        CircularProgressIndicator(progress = progressAnimationValue)
    }

}
