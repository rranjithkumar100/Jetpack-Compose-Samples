package net.jetpackcompose.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.ui.theme.MyAppTheme

class ActivityTextStyles : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextStyleContainer()
                }
            }
        }
    }

}

val baseTextStyle = TextStyle(color = Color.White, fontFamily = FontFamily.Serif)
val headingTextStyle = TextStyle(
    color = Color.Blue,
    fontFamily = FontFamily.Serif,
    fontWeight = FontWeight.Bold,
    textDecoration = TextDecoration.Underline
)


@Composable
fun TextStyleContainer() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextStyleSample()
        Text(text = "Basics", style = headingTextStyle)
        BasicTextStyles()
        Text(text = "Text Decoration Samples", style = headingTextStyle)
        TextDecorationStyle()

        Text(text = "Typography Samples", style = headingTextStyle)
        TextHeadingStyle()
        Text(text = "Merging two or more text styles", style = headingTextStyle)
        TextStyleMerge()
    }
}


@Composable
fun TextStyleSample() {
    Text(
        text = "TextStyle() Samples",
        style = TextStyle(
            color = "#e64a19".color, fontSize = 24.sp, fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun BasicTextStyles() {
    Column {
        Text(
            text = "Text with Color",
            style = TextStyle(color = Color.Red)
        )

        Text(
            text = "Text with Background Color",
            style = TextStyle(background = Color.Yellow)
        )

        Text(
            text = "Text with Shadow",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            )
        )

        Text(
            text = "Text with custom font",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive)
        )



        Text(
            text = "Text with big font size",
            style = TextStyle(fontSize = 30.sp)
        )
    }
}

@Composable
fun TextDecorationStyle() {
    Column {
        Text(
            text = "Text with Underline",
            style = TextStyle(
                color = "#3e2723".color, fontSize = 24.sp,
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            text = "Text with Strike",
            style = TextStyle(
                color = "#6200ea".color, fontSize = 24.sp,
                textDecoration = TextDecoration.LineThrough
            )
        )
    }
}

@Composable
fun TextStyleMerge() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background("#5c6bc0".color)
            .padding(10.dp)
    ) {
        Text(text = "Base style", style = baseTextStyle)
        Text(
            text = "Style with extra bold",
            style = baseTextStyle.plus(
                TextStyle(fontWeight = FontWeight.ExtraBold).plus(
                    TextStyle(
                        background = Color.Gray
                    )
                )
            )
        )
        Text(
            text = "Style with Typography",
            style = baseTextStyle.plus(MaterialTheme.typography.h5)
        )
        Text(
            text = "Extending font size",
            style = baseTextStyle.plus(TextStyle(fontSize = 36.sp))
        )

    }
}


@Composable
fun TextHeadingStyle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background("#78909c".color)
    ) {
        Text(
            text = "Heading 3",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "Heading 4",
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Heading 5",
            style = MaterialTheme.typography.h5
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextStylePreview() {
    MyAppTheme {
        TextStyleContainer()
    }
}