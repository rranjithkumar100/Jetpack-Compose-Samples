package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.R
import net.jetpackcompose.composetext.color

class ImageSamplesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageRootView()
        }
    }


}

@Composable
fun ImageRootView() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background("#ff7043".color)
    ) {

        SimpleImage()
        Spacer(modifier = Modifier.padding(20.dp))

        CircleImageView()
        Spacer(modifier = Modifier.padding(20.dp))

        RoundCornerImageView()
        Spacer(modifier = Modifier.padding(20.dp))

        ImageWithBackgroundColor()
        Spacer(modifier = Modifier.padding(20.dp))

        ImageWithTint()


        Spacer(modifier = Modifier.padding(20.dp))
        ScaleTypeSamples()

    }
}

@Composable
fun ScaleTypeSamples() {
    Column() {
        Text(
            text = "contentScale (ScaleType)",
            color = Color.White,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Fill Bounds", color = Color.White)
        FillBounds()
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Fill Width", color = Color.White)
        FillWidth()
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Inside Fit", color = Color.White)
        InsideFit()
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Crop Scale", color = Color.White)
        CropFit()
    }
}

@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "Andy Rubin",
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun CircleImageView() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)   // add a border (optional)
    )
}

@Composable
fun RoundCornerImageView() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))                       // clip to the round corner shape
            .border(5.dp, Color.Gray, RoundedCornerShape(10))   // add a border (optional)
    )
}


@Composable
fun ImageWithBackgroundColor() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        modifier = Modifier
            .size(200.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}

@Composable
fun ImageWithTint() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size(200.dp)
    )
}

//scale types sample1
@Composable
fun FillBounds() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.FillBounds
    )
}

//scale types sample2
@Composable
fun FillWidth() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",

        modifier = Modifier
            .size(250.dp, 350.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.FillWidth
    )
}

//scale types sample3
@Composable
fun InsideFit() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.Inside
    )
}

//scale types sample4
@Composable
fun CropFit() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.Crop
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ImagePreview() {
    ImageRootView()
}
