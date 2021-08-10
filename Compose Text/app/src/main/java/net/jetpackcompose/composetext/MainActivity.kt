package net.jetpackcompose.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.ui.theme.ComposeTextTheme
import net.jetpackcompose.composetext.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextContainer()
                }
            }
        }
    }

}
@Composable
fun TextContainer() {
    Column {
        SizeModifier("Big text", 40.sp)
        MaxLines()
        ColorText()
        BoldText()
        ItalicText()
        OverflowedText()
        SelectableText()
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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTextTheme {
        TextContainer()
    }
}