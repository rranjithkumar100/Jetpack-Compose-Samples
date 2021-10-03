package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ActivityCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardRootView()
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun CardRootView() {
        Column() {
            SimpleCard()
            CardWithShape()
            CardWithBorder()
            CardWithMultipleViews()
            CardWithContentColor()
        }
    }

    @Composable
    fun SimpleCard() {
        val paddingModifier = Modifier.padding(10.dp)
        Card(elevation = 10.dp, modifier = paddingModifier) {
            Text(text = "Simple Card with elevation", modifier = paddingModifier)
        }
    }
    @Composable
    fun CardWithShape() {
        val paddingModifier = Modifier.padding(10.dp)
        Card(shape = RoundedCornerShape(20.dp),elevation = 10.dp, modifier = paddingModifier) {
            Text(text = "Round corner shape", modifier = paddingModifier)
        }
    }

    @Composable
    fun CardWithBorder() {
        val paddingModifier = Modifier.padding(10.dp)
        Card(
            elevation = 10.dp,
            border = BorderStroke(1.dp, Color.Blue),
                    modifier = paddingModifier
            ) {
            Text(text = "Card with blue border", modifier = paddingModifier)
        }
    }

    @Composable
    fun CardWithMultipleViews() {
        val paddingModifier = Modifier.padding(10.dp)
        Card(
            elevation = 10.dp,
            modifier = paddingModifier
        ) {
            Column(modifier = paddingModifier) {
                Text(text = "First Text")
                Text(text = "Second Text")
            }
        }
    }

    @Composable
    fun CardWithContentColor() {
        val paddingModifier = Modifier.padding(10.dp)
        Card(
            elevation = 10.dp,
            contentColor = Color.Blue,
            modifier = paddingModifier
        ) {
            Column() {
                Text(text = "Text with card content color (Blue)",
                    modifier = paddingModifier)
                Text(text = "Text with card custom color",
                    color = Color.Black,
                    modifier = paddingModifier)

            }
        }
    }
}
