package net.jetpackcompose.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.ui.theme.ComposeTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BigText()
                }
            }
        }
    }
}

@Composable
fun BigText() {
    Text("Hello World", fontSize = 40.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTextTheme {
        BigText()
    }
}