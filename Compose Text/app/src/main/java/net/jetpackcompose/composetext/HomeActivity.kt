package net.jetpackcompose.composetext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.reflect.KClass

class HomeActivity : ComponentActivity() {
    private val TAG = "HomeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton(text = "Text Samples") {
                    startActivity(Intent(context,TextBasicsActivity::class.java))
                }
                CustomButton(text = "Text Style Samples") {
                    startActivity(Intent(context,ActivityTextStyles::class.java))
                }
                CustomButton(text = "Modifier Samples") {
                    startActivity(Intent(context,ModifierSamplesActivity::class.java))
                }
                CustomButton(text = "Button Samples") {
                    startActivity(Intent(context,ButtonsSampleActivity::class.java))
                }
                CustomButton(text = "Textfields ") {
                    startActivity(Intent(context,ActivityTextField::class.java))
                }
                CustomButton(text = "Image Samples ") {
                    startActivity(Intent(context,ImageSamplesActivity::class.java))
                }
                CustomButton(text = "ListView ") {
                    startActivity(Intent(context,ListViewSampleActivity::class.java))
                }
                CustomButton(text = "Gradient Samples ") {
                    startActivity(Intent(context,GradientSamplesActivity::class.java))
                }
                CustomButton(text = "Scaffold Sample ") {
                    startActivity(Intent(context,ScaffoldSampleActivity::class.java))
                }

            }
        }
    }


}


@Composable
fun CustomButton(text: String, onClickCallBack: () -> Unit) {
    Button(onClick = onClickCallBack, modifier = Modifier.padding(10.dp)) {
        Text(text = text, modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp))
    }
}