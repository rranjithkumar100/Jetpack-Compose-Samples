package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.ui.theme.MyAppTheme
import net.jetpackcompose.composetext.ui.theme.Purple200

class TextBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextContainer()
                }
            }
        }
    }

}
@Composable
fun SizeModifier(label: String, size: TextUnit) {
    Text(label, fontSize = size)
}
@Composable
fun ColorText() {
    Text("Color Text", color = Purple200)
}
@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText() {
    Text("Italic Text", fontStyle = FontStyle.Italic)
}
@Composable
fun MaxLines() {
    Text("hello ".repeat(50), maxLines = 2)
}
@Composable
fun OverflowedText() {
    Text("Overflow text  ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}
@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}
@Composable
fun TextContainer() {
    Column {
        SizeModifier("Big text", 40.sp)
        ColorText()
        BoldText()
        ItalicText()
        OverflowedText()
        SelectableText()
        MaxLines()

    }
}

val  redTextStyle = TextStyle(color = Color.Red,fontSize = 30.sp)
@Preview( showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Row {
        TextContainer()
    }
}