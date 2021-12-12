package net.jetpackcompose.composetext.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.jetpackcompose.composetext.R
import net.jetpackcompose.composetext.util.sdp

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
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "  Text  ") {
                        startActivity(Intent(context, TextBasicsActivity::class.java))
                    }
                    CustomButton(text = "Text Style") {
                        startActivity(Intent(context, ActivityTextStyles::class.java))
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "TextFields") {
                        startActivity(Intent(context, ActivityTextField::class.java))
                    }
                    CustomButton(text = " Buttons ") {
                        startActivity(Intent(context, ButtonsSampleActivity::class.java))
                    }
                }

                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "  Image  ") {
                        startActivity(Intent(context, ImageSamplesActivity::class.java))
                    }
                    CustomButton(text = "ListView ") {
                        startActivity(Intent(context, ActivityList::class.java))
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = " Modifier ") {
                        startActivity(Intent(context, ActivityModifiers::class.java))
                    }
                    CustomButton(text = "  Themes ") {
                        startActivity(Intent(context, ActivityThemes::class.java))
                    }

                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "Scaffold") {
                        startActivity(Intent(context, ScaffoldSampleActivity::class.java))
                    }
                    CustomButton(text = "  State  ") {
                        startActivity(Intent(context, ActivityStateManagement::class.java))
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "Animation") {
                        startActivity(Intent(context, AnimationSamplesActivity::class.java))
                    }
                    CustomButton(text = "  Card  ") {
                        startActivity(Intent(context, ActivityCard::class.java))
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {

                    CustomButton(text = "ProgressBar") {
                        startActivity(Intent(context, ActivityProgressIndicator::class.java))
                    }
                    CustomButton(text = "  Alert Dialog  ") {
                        startActivity(Intent(context, ActivityAlertDialog::class.java))
                    }
                }
            }
        }
    }


}


@Composable
fun CustomButton(text: String, onClickCallBack: () -> Unit) {
    Button(onClick = onClickCallBack, modifier = Modifier .padding(10.dp)) {
        Text(text = text, modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp))
    }
}