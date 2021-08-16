package net.jetpackcompose.composetext

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class HomeActivity : ComponentActivity() {
    private  val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                CustomButton(text = "Text Samples") {
                    Log.d(TAG, "text click oncreate: ")
                }
            }
        }
    }


}

@Composable
fun CustomButton(text: String, onClick: () -> Int) {
    Button(onClick = {
        Log.d("TAG", "CustomButton: click")
       onClick
    }) {
        Text(text = text)
    }
}